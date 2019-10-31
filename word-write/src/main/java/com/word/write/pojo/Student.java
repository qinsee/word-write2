package com.word.write.pojo;

import lombok.Data;

@Data
public class Student {
    //学生id
    private String stuid;
    //学生班级id
    private Integer stuclass;
    //学生姓名
    private String stuname;
    //学生手机号
    private String stuphone;
    //家长手机号
    private String parphone;

    private String stuclass1;
}
