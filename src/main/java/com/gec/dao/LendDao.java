package com.gec.dao;

import com.gec.entity.Lend;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LendDao {
    public List<Lend> getAllLend();
    public int addLend(@Param("bookId") String ids,@Param("readerId")String readerNumber,@Param("lendDate") Date lendDate,@Param("backDate") Date backDate,@Param("backType") Integer backType,@Param("exceptRemarks") String exceptRemarks);
    public int deleteLendListByIds(List<String> id);
    public int backLendListByIds(@Param("backDate") Date backDate);
}
