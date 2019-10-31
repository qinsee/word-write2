package com.word.write.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Paper {
    //题目号
    private Integer pid;
    //试卷号
    private String pnum;
    //单词序号
    private Integer wordid;
    //试卷日期
    private String pdate;
    //考试班级
    private Integer classid;
    //出题人员
    private String username;
    //单词
    private String word;
    //单词
    private String wordmeaning;
    //班级名
    private String classname;

}
