package com.word.write.dao;

import com.word.write.pojo.StuClass;
import com.word.write.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StuClassMapper {
    List<StuClass> findStuClass(@Param("name") String name, @Param("pageStart") Integer pageStart, @Param("pageSize") Integer pageSize);
    int countStuClass(@Param("name") String name);
    int addStuClass(@Param("classname") String classname);
    StuClass findOne(@Param("id") Integer id);
    int updStuClass(StuClass sc);
    List<Student> findStudent(@Param("stuclass") Integer stuclass);
    int delStuClass(@Param("classid") Integer classid);
    int delStudent(@Param("stuclass") Integer stuclass);
}
