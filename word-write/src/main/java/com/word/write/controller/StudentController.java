package com.word.write.controller;

import com.alibaba.fastjson.JSON;
import com.word.write.pojo.Student;
import com.word.write.pojo.StuClass;
import com.word.write.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentService studentService;

    //展示查询页面
    @RequestMapping("showFindStudent")
    public String showFindPaper(){
        return "student/findStudent";
    }
    //查询数据
    @RequestMapping("findStudent")
    @ResponseBody
    public String findPaper(HttpServletRequest request,@RequestParam(value = "stuname"
            , required = false) String stuname
            ,@RequestParam(value = "stuclass", required = false) Integer stuclass
    ){
        // 获取页面显示的条数
        int pageNum = Integer.parseInt(request.getParameter("limit")); //pageSize
        // 获取页面当前页
        int currPage = Integer.parseInt(request.getParameter("page")); //pageIndex
        // 计算数据库的分页从第几行开始取数
        // 假设每页显示条数为pageNum10条　当前页为第currPage3页　则(3-1)*10=20
        // sql 语句为　　select * from 表    where 条件   limit 20,10
        int pageCount =(currPage - 1) * pageNum;
        List<Student> list = studentService.findStudentService(stuname,stuclass,pageCount,pageNum);
        String json= JSON.toJSONString(list);
        int count= studentService.findStudentCountService(stuname,stuclass);
        String path = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"
                + json + "}";
        return path;
    }
    //展示添加页面
    @RequestMapping("showAddStudent")
    public String showAddPaper(){
            return "student/addStudent";
    }
    //添加
    @RequestMapping("addStudent")
    @ResponseBody
    public int addPaper(Student student){
        int count=0;
        if(student!=null){
             count= studentService.addStudentService(student);
        }
        System.out.println(count);
        return count;
    }
    //显示修改页面
    //根据id查询
    @RequestMapping("/showUpdStudent")
    public String showUpdSort(Model model,@RequestParam(value = "stuid", required = false)String stuid) {
        model.addAttribute("stuid",stuid);
        return "student/updStudent";
    }

    //根据id查询显示数据
    @RequestMapping("/findStudentById")
    @ResponseBody
    public String findPaperById(@RequestParam(value = "stuid", required = false) String stuid) {
        Student student= studentService.findStudentByIdService(stuid);
        String json= JSON.toJSONString(student);
        return json;
    }

    //修改
    @RequestMapping("updStudent")
    @ResponseBody
    public int updPaper(Student student){
        int count=0;
        if(student!=null){
            count= studentService.updStudentService(student);
        }
        return count;
    }

    //删除
    @RequestMapping("delStudent")
    @ResponseBody
    public int delPaper(@RequestParam(value = "stuid", required = false)String stuid){
        int count = studentService.delStudentService(stuid);
        return count;
    }
}
