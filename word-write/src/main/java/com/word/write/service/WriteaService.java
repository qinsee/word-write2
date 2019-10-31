package com.word.write.service;

import com.word.write.pojo.Paper;
import com.word.write.pojo.Writea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface WriteaService {
    List<Paper> findPaperByPnum(String pnum, Integer classid);
    List<Paper> showExam(String pnum, Integer classid);
    List<Writea> findWritea(Integer isyes
            , String writeDateStart
            , String writeDateEnd
            , String pnum
            , String stuclass
            , int pageStart
            , int pageSize
    );
    List<Writea> findWriteaByIsYes(Integer isyes
            , String pnum
            , Integer stuclass
            , String stuid
    );
    int findWriteaCount(Integer isyes
            , String writeDateStart
            , String writeDateEnd
            , String pnum
            , String stuclass

    );
    int countPaper(String pnum, Integer classid);
    int addWritea(Writea writea);
    int delWritea(Integer writeid);
}
