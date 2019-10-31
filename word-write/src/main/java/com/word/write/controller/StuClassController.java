package com.word.write.controller;

import java.util.*;
import com.alibaba.fastjson.JSON;
import com.word.write.pojo.StuClass;
import com.word.write.pojo.Student;
import com.word.write.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("stuClass")
public class StuClassController {
    @Autowired
    private StuClassService stuClassService;

    @RequestMapping("/openFind")
    public String openFind(){
        return "stuclass/findStuClass";
    }

    @RequestMapping("/findByName")
    @ResponseBody
    public String findByName(@RequestParam(value = "classname", required = false) String classname, HttpServletRequest request){
        // 获取页面显示的条数
        int pageNum = Integer.parseInt(request.getParameter("limit")); //pageSize
        // 获取页面当前页
        int currPage = Integer.parseInt(request.getParameter("page")); //pageIndex
        // 计算数据库的分页从第几行开始取数
        int pageCount =(currPage - 1) * pageNum;
        List<StuClass> list=stuClassService.findStuClass(classname,pageCount,pageNum);
        int count=stuClassService.countStuClass(classname);
        String json= JSON.toJSONString(list);
        String path = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":" + json + "}";
        return path;
    }
    @RequestMapping("openAddStuClass")
    public String openAddStuClass(){
        return "stuclass/addStuClass";
    }

    @RequestMapping("addStuClass")
    @ResponseBody
    public String addStuClass(String classname){
    int count =stuClassService.addStuClass(classname);
    return JSON.toJSONString(count);
    }
    @RequestMapping("openUpdStuClass")
    public String openUpdStuClass(Model model,Integer id){
        StuClass sc=stuClassService.findOne(id);
        model.addAttribute("sc",sc);
        return "stuclass/updStuClass";
    }

    @RequestMapping("updStuClass")
    @ResponseBody
    public String updStuClass(StuClass sc){
        int count =stuClassService.updStuClass(sc);
        return JSON.toJSONString(count);
    }

    @RequestMapping("delStuClass")
    @ResponseBody
    public String delStuClass(Integer classid){
        List<Student> list=stuClassService.findStudent(classid);
        int count=0;
        if (list.size()!=0){
            System.out.println("是否有学生"+list.size());
            return JSON.toJSONString(count);
        }else {
            count=stuClassService.delStuClass(classid);
        }
        System.out.print("count"+count);
        return JSON.toJSONString(count);
    }

    @RequestMapping("delAll")
    @ResponseBody
    public String delAll(Integer classid){
        int count=stuClassService.delStudent(classid);
        System.out.print("删除学生"+count);
        if (count>0){
            count=stuClassService.delStuClass(classid);
            System.out.print("删除班级"+count);
        }
        return JSON.toJSONString(count);
    }
}
