package com.word.write.service;

import com.word.write.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    int addTeacherService(Teacher teacher);
    int updTeacherService(Teacher teacher);
    int delTeacherService( Integer tid);
    List<Teacher> findTeacherService( String tname
            , Integer stuclass
            , int pageStart
            , int pageSize);
    Teacher findTeacherByIdService(Integer tid);
    int findTeacherCountService(String tname,Integer stuclass);
}
