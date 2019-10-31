package com.word.write.service;

import com.word.write.pojo.StuClass;
import com.word.write.pojo.Student;

import java.util.List;

public interface StuClassService {
    List<StuClass> findStuClass(String name, Integer pageStart, Integer pageSize);
    int countStuClass(String name);
    int addStuClass(String classname);
    StuClass findOne(Integer id);
    int updStuClass(StuClass sc);
    List<Student> findStudent(Integer stuclass);
    int delStuClass(Integer classid);
    int delStudent(Integer stuclass);
}
