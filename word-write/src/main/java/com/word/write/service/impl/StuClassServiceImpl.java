package com.word.write.service.impl;

import com.word.write.dao.StuClassMapper;
import com.word.write.pojo.StuClass;
import com.word.write.pojo.Student;
import com.word.write.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StuClassServiceImpl implements StuClassService{
    @Resource
    private StuClassMapper stuClassMapper;

    @Override
    public List<StuClass> findStuClass(String name,Integer pageStart,Integer pageSize) {
        return stuClassMapper.findStuClass(name,pageStart,pageSize);
    }

    @Override
    public int countStuClass(String name) {
        return stuClassMapper.countStuClass(name);
    }

    @Override
    public int addStuClass(String classname) {
        return stuClassMapper.addStuClass(classname);
    }

    @Override
    public StuClass findOne(Integer id) {
        return stuClassMapper.findOne(id);
    }

    @Override
    public int updStuClass(StuClass sc) {
        return stuClassMapper.updStuClass(sc);
    }

    @Override
    public List<Student> findStudent(Integer stuclass) {
        return stuClassMapper.findStudent(stuclass);
    }

    @Override
    public int delStuClass(Integer classid) {
        return stuClassMapper.delStuClass(classid);
    }

    @Override
    public int delStudent(Integer stuclass) {
        return stuClassMapper.delStudent(stuclass);
    }
}
