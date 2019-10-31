package com.word.write.dao;

import com.word.write.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
      int addStudent(Student student);
      int updStudent(Student student);
      int delStudent(@Param("stuid") String stuid);
      List<Student> findStudent(@Param("stuname") String stuname
              ,@Param("stuclass") Integer stuclass
              , @Param("pageStart") int pageStart
              , @Param("pageSize") int pageSize);
      Student findStudentById(@Param("stuid") String stuid);
      int findStudentCount(@Param("stuname") String stuname,@Param("stuclass") Integer stuclass);
}