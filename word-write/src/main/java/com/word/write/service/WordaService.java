package com.word.write.service;

import com.word.write.pojo.Worda;

import java.util.List;

public interface WordaService {
    List<Worda> findWorda(String wordmeaning, String word, Integer pageStart, Integer pageSize);
    int countWorda(String wordmeaning, String word);
    int addWorda(Worda sc);
    Worda findOneWorda(Integer id);
    int updWorda(Worda sc);
    int delWorda(Integer id);
}
