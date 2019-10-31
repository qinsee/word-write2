package com.word.write.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Writea {
    //序号
    private Integer writeid;
    //题目号
    private Integer pid;
    //默写单词
    private String writeword;
    //默写是否正确
    private Integer isyes;
    //默写日期
    private String writedate;
    //学生ID
    private String stuid;
    //学生班级id
    private Integer stuclass;
    //试卷号
    private String  pnum;
    private Integer pid1;
    private String stuid1;
    private Integer classid;
    private String wordmeaning;
    private String word;
}
