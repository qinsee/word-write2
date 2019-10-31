package com.word.write.service;

import com.word.write.pojo.Paper;
import com.word.write.pojo.StuClass;

import java.util.List;

public interface PaperService {
    int addPaperService(Paper paper);
    int updPaperService(Paper paper);
    int delPaperService(String pnum);
    int findPaperCountService(String pnum
            ,String pdateStart
            ,String pdateEnd
            ,Integer classid
            ,String username);
    List<Paper> findPaperService(String pnum
            , String pdateStart
            , String pdateEnd
            , Integer classid
            , String username
            , int pageStart
            , int pageSize);
    List<StuClass> findStuClassService();
    int findWordaCountService();
    Paper findPaperByIdService(Integer pid);
}
