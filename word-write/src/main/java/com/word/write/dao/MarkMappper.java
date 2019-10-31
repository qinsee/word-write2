package com.word.write.dao;

import com.word.write.pojo.Mark;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MarkMappper {
    List<Mark> findMark(@Param("isflag") Integer isflag
            , @Param("markDateStart") String markDateStart
            , @Param("markDateEnd") String markDateEnd
            , @Param("pnum") String pnum
            , @Param("stuclass") Integer stuclass
            , @Param("pageStart") int pageStart
            , @Param("pageSize") int pageSize
    );
    int findMarkCount(@Param("isflag") Integer isflag
            , @Param("markDateStart") String markDateStart
            , @Param("markDateEnd") String markDateEnd
            , @Param("pnum") String pnum
            , @Param("stuclass") Integer stuclass
    );
    Mark findMarkById(@Param("mid") Integer mid);
    int addMark(Mark mark);
    int updMark(Mark mark);
    int delMark(@Param("mid") Integer mid);
}
