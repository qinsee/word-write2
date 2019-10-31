package com.word.write.service.impl;

import com.word.write.dao.TeacherMapper;
import com.word.write.pojo.Teacher;
import com.word.write.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public int addTeacherService(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int updTeacherService(Teacher teacher) {
        return teacherMapper.updTeacher(teacher);
    }

    @Override
    public int delTeacherService(Integer tid) {
        return teacherMapper.delTeacher(tid);
    }

    @Override
    public List<Teacher> findTeacherService(String tname, Integer stuclass, int pageStart, int pageSize) {
        return teacherMapper.findTeacher(tname, stuclass, pageStart, pageSize);
    }

    @Override
    public Teacher findTeacherByIdService(Integer tid) {
        return teacherMapper.findTeacherById(tid);
    }

    @Override
    public int findTeacherCountService(String tname, Integer stuclass) {
        return teacherMapper.findTeacherCount(tname,stuclass);
    }
}
