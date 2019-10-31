package com.word.write.pojo;

import lombok.Data;

@Data
public class Mark {
    //分数序号
    private Integer mid;
    //学生id
    private String stuid;
    //学生班级id
    private Integer stuclass;
    //学生分数
    private Double mark;
    //分数日期
    private String markdate;
    //是否发送给家长
    private Integer isflag;
    //备注
    private Integer remark;
    //试卷号
    private String pnum;
    //关联
    private String pnum1;
    private String stuid1;
    private Integer classid;
}
