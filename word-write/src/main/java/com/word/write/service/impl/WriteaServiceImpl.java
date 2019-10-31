package com.word.write.service.impl;

import com.word.write.dao.WriteaMapper;
import com.word.write.pojo.Paper;
import com.word.write.pojo.Writea;
import com.word.write.service.WriteaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("writeaServiceImpl")
public class WriteaServiceImpl implements WriteaService {
    @Resource
    private WriteaMapper writeaMapper;
    @Override
    public List<Paper> findPaperByPnum(String pnum,Integer classid) {
        System.err.println(pnum+classid);
        return writeaMapper.findPaperByPnum(pnum,classid);
    }

    @Override
    public List<Paper> showExam(String pnum, Integer classid) {
        return writeaMapper.showExam(pnum, classid);
    }

    @Override
    public List<Writea> findWritea(Integer isyes, String writeDateStart, String writeDateEnd, String pnum, String stuclass, int pageStart, int pageSize) {
        return writeaMapper.findWritea(isyes, writeDateStart, writeDateEnd, pnum, stuclass, pageStart, pageSize);
    }

    @Override
    public List<Writea> findWriteaByIsYes(Integer isyes, String pnum, Integer stuclass, String stuid) {
        return writeaMapper.findWriteaByIsYes(isyes, pnum, stuclass, stuid);
    }

    @Override
    public int findWriteaCount(Integer isyes, String writeDateStart, String writeDateEnd, String pnum, String stuclass) {
        return writeaMapper.findWriteaCount(isyes, writeDateStart, writeDateEnd, pnum, stuclass);
    }

    @Override
    public int countPaper(String pnum, Integer classid) {
        return writeaMapper.countPaper(pnum, classid);
    }

    @Override
    public int addWritea(Writea writea) {
        return writeaMapper.addWritea(writea);
    }

    @Override
    public int delWritea(Integer writeid) {
        return writeaMapper.delWritea(writeid);
    }
}
