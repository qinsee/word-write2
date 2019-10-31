package com.word.write.controller;

import com.alibaba.fastjson.JSON;
import com.word.write.pojo.Teacher;
import com.word.write.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    //展示查询页面
    @RequestMapping("showFindTeacher")
    public String showFindPaper(){
        return "teacher/findTeacher";
    }
    //查询数据
    @RequestMapping("findTeacher")
    @ResponseBody
    public String findPaper(HttpServletRequest request, @RequestParam(value = "tname"
            , required = false) String tname
            , @RequestParam(value = "stuclass", required = false) Integer stuclass
    ){
        // 获取页面显示的条数
        int pageNum = Integer.parseInt(request.getParameter("limit")); //pageSize
        // 获取页面当前页
        int currPage = Integer.parseInt(request.getParameter("page")); //pageIndex
        // 计算数据库的分页从第几行开始取数
        // 假设每页显示条数为pageNum10条　当前页为第currPage3页　则(3-1)*10=20
        // sql 语句为　　select * from 表    where 条件   limit 20,10
        int pageCount =(currPage - 1) * pageNum;
        List<Teacher> list = teacherService.findTeacherService(tname,stuclass,pageCount,pageNum);
        String json= JSON.toJSONString(list);
        int count= teacherService.findTeacherCountService(tname,stuclass);
        String path = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"
                + json + "}";
        return path;
    }
    //展示添加页面
    @RequestMapping("showAddTeacher")
    public String showAddPaper(){
        return "teacher/addTeacher";
    }
    //添加
    @RequestMapping("addTeacher")
    @ResponseBody
    public int addPaper(Teacher teacher){
        int count=0;
        if(teacher!=null){
            count= teacherService.addTeacherService(teacher);
        }
        System.out.println(count);
        return count;
    }
    //显示修改页面
    //根据id查询
    @RequestMapping("/showUpdTeacher")
    public String showUpdSort(Model model, @RequestParam(value = "tid", required = false)Integer tid) {
        model.addAttribute("tid",tid);
        return "teacher/updTeacher";
    }

    //根据id查询显示数据
    @RequestMapping("/findTeacherById")
    @ResponseBody
    public String findPaperById(@RequestParam(value = "tid", required = false) Integer tid) {
        Teacher Teacher= teacherService.findTeacherByIdService(tid);
        String json= JSON.toJSONString(Teacher);
        return json;
    }

    //修改
    @RequestMapping("updTeacher")
    @ResponseBody
    public int updPaper(Teacher teacher){
        int count=0;
        if(teacher!=null){
            count= teacherService.updTeacherService(teacher);
        }
        return count;
    }

    //删除
    @RequestMapping("delTeacher")
    @ResponseBody
    public int delPaper(@RequestParam(value = "tid", required = false)Integer tid){
        int count = teacherService.delTeacherService(tid);
        return count;
    }
}
