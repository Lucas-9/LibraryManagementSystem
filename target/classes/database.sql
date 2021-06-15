drop database if exists `library`;
create database `library` character set utf8 collate utf8_general_ci;
use `library`;
drop table `user`;
create table `user`
(
    `id`                int primary key auto_increment comment '用户id',
    `username`          varchar(30) not null unique comment '用户名',
    `password`          varchar(40) not null comment '密码',
    `phone_number`      varchar(20) not null unique comment '手机号',
    `email`             varchar(30) not null unique comment '邮箱',
    `role`              varchar(30) not null default 'user' comment '角色',
    `borrowable_days`   int                  default 30 comment '可借天数',
    `borrowable_number` int                  default 3 comment '可借数目',
    `borrowed_number`   int                  default 0 comment '已借数目'
);
insert into `user`(`id`, `username`, `password`, `phone_number`, `email`, `role`)
values (1, 'lucas9', MD5('123456'), '12345678910', '1778410268@qq.com', 'SUPER_ADMIN');


create table `book`
(
    `id`           int primary key auto_increment comment '图书id',
    `cover_url`    varchar(200) comment '封面URL',
    `book_name`    varchar(50) comment '书名',
    `book_author`  varchar(30) comment '作者',
    `quantity`     int default 1 comment '数目',
    `introduction` text comment '简介',
    `isbn`         varchar(20) unique comment 'ISBN',
    `price`        varchar(10) comment '价格',
    `press`        varchar(50) comment '出版社'
);
drop table if exists `borrowingRecords`;
create table `borrowingRecords`
(
    `id`          int primary key auto_increment comment '借阅记录id',
    `book_name`   varchar(50) comment '书名',
    `book_id`     int comment '图书id',
    `borrower`    varchar(20) comment '借阅者',
    `loan_date`   date not null comment '借阅日期',
    `return_date` date default null comment '归还日期',
    `deadline`    int  default 30 comment '截至归还日期',
    `returned`    bool default false comment '是否归还'
);
select *
from `borrowingRecords`;
-- 查看定时器是否
SHOW VARIABLES LIKE 'event_scheduler';
-- 开启打开定时器，此设置关闭服务器后定时器也会关闭，我采用在my.ini的mysqld中设置event_scheduler = ON
SET GLOBAL event_scheduler = ON;
-- 查看事件
show events;
-- 删除事件
drop event if exists BookReturnCountdownEvent;
-- 产生事件
create event if not exists BookReturnCountdownEvent
    on schedule every 1 day starts curdate() # every + 间隔 + starts + 开始时间
    on completion preserve enable
    do update borrowingRecords
       set deadline = deadline - 1
       where returned = false;
