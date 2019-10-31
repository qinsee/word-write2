package com.word.write.dao;

import com.word.write.pojo.Worda;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WordaMapper {
    List<Worda> findWorda(@Param("wordmeaning") String wordmeaning, @Param("word") String word, @Param("pageStart") Integer pageStart, @Param("pageSize") Integer pageSize);
    int countWorda(@Param("wordmeaning") String wordmeaning, @Param("word") String word);
    int addWorda(Worda sc);
    Worda findOneWorda(@Param("id") Integer id);
    int updWorda(Worda sc);
    int delWorda(@Param("id") Integer id);
}
