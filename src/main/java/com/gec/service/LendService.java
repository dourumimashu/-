package com.gec.service;

import com.gec.entity.Lend;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface LendService {
    public List<Lend> getAllLend(Integer page, Integer limit);
    public boolean addLend(@Param("bookId") String ids,@Param("readerId")String readerNumber,@Param("lendDate") Date lendDate,@Param("backDate") Date backDate,@Param("backType") Integer backType,@Param("exceptRemarks") String exceptRemarks);
    public Boolean deleteLendListByIds(List<String> id);
    public Boolean backLendListByIds(@Param("backDate") Date backDate);

}
