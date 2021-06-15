
function queryRecord() {
    $.ajax({
        url:'/QueryRecordByBorrowerServlet',
        type:'POST',
        data:{'username':$('#user').text()},
        success:function (data) {
            createBookRecordsTableHead()
            let jsonData = JSON.parse(data);
            let recordList = jsonData.recordList;
            let tableBody = document.getElementById('tableBody');
            $('#tableBody').empty();
            for (let i = 0; i < recordList.length; i++) {
                let tr = document.createElement("tr");
                let td1 = document.createElement("td");
                let td2 = document.createElement("td");
                let td3 = document.createElement("td");
                let td4 = document.createElement("td");
                let td5 = document.createElement("td");
                let td6 = document.createElement("td");
                let td7 = document.createElement("td");
                let td8 = document.createElement("td");
                let td9 = document.createElement("td");
                let td10 = document.createElement("td");
                let td11 = document.createElement("td");
                td1.innerHTML = "" + (i + 1);
                td2.innerHTML = recordList[i].serialNumber;
                td3.innerHTML = recordList[i].bookName;
                td4.innerHTML = recordList[i].ISBN;
                td5.innerHTML = recordList[i].returned;
                td6.innerHTML = recordList[i].renewable;
                td7.innerHTML = recordList[i].loanDate;
                td8.innerHTML = recordList[i].deadline;
                td9.innerHTML = '未归还';
                if (recordList[i].renewable === true && recordList[i].returned === false) {
                    td10.innerHTML = "<button class='btn btn-success' type='button' onclick='renewBook(" + recordList[i].serialNumber + ")'>续借</button>";
                } else {
                    td10.innerHTML = "<button class='btn btn-success' disabled='disabled' type='button' onclick='renewBook(" + recordList[i].serialNumber + ")'>续借</button>";
                }
                if (recordList[i].returned === false) {
                    td11.innerHTML = "<button class='btn btn-success' type='button' onclick='returnBook(" + recordList[i].serialNumber + "," + recordList[i].ISBN + ")'>还书</button>";
                } else {
                    td9.innerHTML = recordList[i].returnDate;
                    td11.innerHTML = "<button class='btn btn-success' disabled='disabled' type='button' onclick='returnBook(" + recordList[i].serialNumber + "," + recordList[i].ISBN + ")'>还书</button>";
                }
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                tr.appendChild(td6);
                tr.appendChild(td7);
                tr.appendChild(td8);
                tr.appendChild(td9);
                tr.appendChild(td10);
                tr.appendChild(td11);
                tableBody.appendChild(tr);
            }
        }
    });
}

function createBookRecordsTableHead() {
    $('#tableHead').empty();
    let tableHead = document.getElementById('tableHead');
    let tr = document.createElement("tr");
    let td1 = document.createElement("th");
    let td2 = document.createElement("th");
    let td3 = document.createElement("th");
    let td4 = document.createElement("th");
    let td5 = document.createElement("th");
    let td6 = document.createElement("th");
    let td7 = document.createElement("th");
    let td8 = document.createElement("th");
    let td9 = document.createElement("th");
    let td10 = document.createElement("th");
    let td11 = document.createElement("th");
    td1.innerHTML = '序号';
    td2.innerHTML = '流水号';
    td3.innerHTML = "书名";
    td4.innerHTML = "ISBN";
    td5.innerHTML = "是否归还";
    td6.innerHTML = "可借阅";
    td7.innerHTML = "借阅日期";
    td8.innerHTML = "截止归还天数";
    td9.innerHTML = "归还日期";
    td10.innerHTML = "续借";
    td11.innerHTML = "还书";
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    tr.appendChild(td6);
    tr.appendChild(td7);
    tr.appendChild(td8);
    tr.appendChild(td9);
    tr.appendChild(td10);
    tr.appendChild(td11);
    tableHead.appendChild(tr);
}
