package com.word.write.service;

import com.word.write.pojo.StuClass;
import com.word.write.pojo.Student;

import java.util.List;

public interface StudentService {
    int addStudentService(Student student);
    int updStudentService(Student student);
    int delStudentService(String stuid);
    List<Student> findStudentService(String stuname,Integer stuclass,int pageStart,int pageSize);
    Student findStudentByIdService(String stuid);
    int findStudentCountService(String stuname,Integer stuclass);
}
