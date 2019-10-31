package com.word.write.service.impl;

import com.word.write.dao.MarkMappper;
import com.word.write.pojo.Mark;
import com.word.write.service.MarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("markServiceImpl")
public class MarkServiceImpl implements MarkService {
    @Resource
    private MarkMappper markMappper;

    @Override
    public List<Mark> findMarkService(Integer isflag, String markDateStart, String markDateEnd, String pnum, Integer stuclass, int pageStart, int pageSize) {
        return markMappper.findMark(isflag, markDateStart, markDateEnd, pnum, stuclass, pageStart, pageSize);
    }

    @Override
    public int findMarkCountService(Integer isflag, String markDateStart, String markDateEnd, String pnum, Integer stuclass) {
        return markMappper.findMarkCount(isflag, markDateStart, markDateEnd, pnum, stuclass);
    }

    @Override
    public Mark findMarkByIdService(Integer mid) {
        return markMappper.findMarkById(mid);
    }

    @Override
    public int addMarkService(Mark mark) {
        return markMappper.addMark(mark);
    }

    @Override
    public int updMarkService(Mark mark) {
        return markMappper.updMark(mark);
    }

    @Override
    public int delMarkService(Integer mid) {
        return markMappper.delMark(mid);
    }
}
