package com.word.write.service.impl;

import com.word.write.dao.WordaMapper;
import com.word.write.pojo.Worda;
import com.word.write.service.WordaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WordaServiceImpl implements WordaService {
    @Resource
    private WordaMapper wordaMapper;

    @Override
    public List<Worda> findWorda(String wordmeaning,String word,Integer pageStart,Integer pageSize) {
        return wordaMapper.findWorda(wordmeaning,word,pageStart,pageSize);
    }

    @Override
    public int countWorda(String wordmeaning, String word) {
        return wordaMapper.countWorda(wordmeaning,word);
    }

    @Override
    public int addWorda(Worda sc) {
        return wordaMapper.addWorda(sc);
    }

    @Override
    public Worda findOneWorda(Integer id) {
        return wordaMapper.findOneWorda(id);
    }

    @Override
    public int updWorda(Worda sc) {
        return wordaMapper.updWorda(sc);
    }

    @Override
    public int delWorda(Integer id) {
        return wordaMapper.delWorda(id);
    }
}
