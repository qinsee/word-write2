package com.word.write.dao;

import com.word.write.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TeacherMapper {
    int addTeacher(Teacher teacher);
    int updTeacher(Teacher teacher);
    int delTeacher(@Param("tid") Integer tid);
    List<Teacher> findTeacher(@Param("tname") String tname
            ,@Param("stuclass") Integer stuclass
            , @Param("pageStart") int pageStart
            , @Param("pageSize") int pageSize);
    Teacher findTeacherById(@Param("tid") Integer tid);
    int findTeacherCount(@Param("tname") String tname,@Param("stuclass") Integer stuclass);
}
