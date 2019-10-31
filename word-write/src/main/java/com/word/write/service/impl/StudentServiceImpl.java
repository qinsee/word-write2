package com.word.write.service.impl;

import com.word.write.dao.StudentMapper;
import com.word.write.pojo.Student;
import com.word.write.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public int addStudentService(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updStudentService(Student student) {
        return studentMapper.updStudent(student);
    }

    @Override
    public int delStudentService(String stuid) {
        return studentMapper.delStudent(stuid);
    }

    @Override
    public List<Student> findStudentService(String stuname,Integer stuclass, int pageStart, int pageSize) {
        return studentMapper.findStudent(stuname,stuclass, pageStart, pageSize);
    }

    @Override
    public Student findStudentByIdService(String stuid) {
        return studentMapper.findStudentById(stuid);
    }

    @Override
    public int findStudentCountService(String stuname,Integer stuclass) {
        return studentMapper.findStudentCount(stuname,stuclass);
    }
}
