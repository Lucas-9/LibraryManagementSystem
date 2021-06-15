package top.lucas9.mapper;

import org.apache.ibatis.annotations.Param;
import top.lucas9.entity.BorrowingRecords;

import java.time.LocalDate;
import java.util.List;

/**
 * @author lucas
 */
public interface RecordMapper {
    Integer insertRecord(@Param("record") BorrowingRecords record);
    Integer updateRecord(@Param("recordId")Integer recordId,@Param("returnDate") LocalDate returnDate);
    List<BorrowingRecords> selectRecordByKeyword(@Param("keyword") String keyword, @Param("isOneself") String isOneself);
}
