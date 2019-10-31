package com.word.write.service;

import com.word.write.pojo.Mark;

import java.util.List;

public interface MarkService {
    List<Mark> findMarkService(Integer isflag
            , String markDateStart
            , String markDateEnd
            , String pnum
            , Integer stuclass
            , int pageStart
            , int pageSize
    );
    int findMarkCountService(Integer isflag
            , String markDateStart
            , String markDateEnd
            , String pnum
            , Integer stuclass
    );
    Mark findMarkByIdService(Integer mid);
    int addMarkService(Mark mark);
    int updMarkService(Mark mark);
    int delMarkService(Integer mid);
}
