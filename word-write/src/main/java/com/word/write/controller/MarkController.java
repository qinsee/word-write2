package com.word.write.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;
import com.word.write.pojo.Mark;
import com.word.write.service.MarkService;
import com.word.write.service.MarkService;
import com.word.write.util.SendMsg_webchinese;
import com.word.write.util.Sendmss;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("mark")
public class MarkController {
    @Resource
    private MarkService markService;

    //展示查询页面
    @RequestMapping("showFindMark")
    public String showFindMark(){
        return "mark/findMark";
    }
    //查询数据
    @RequestMapping("findMark")
    @ResponseBody
    public String findMark(HttpServletRequest request
            ,@RequestParam(value = "markDateStart", required = false) String markDateStart
            ,@RequestParam(value = "markDateEnd", required = false) String markDateEnd
            ,@RequestParam(value = "isflag", required = false) Integer isflag
            ,@RequestParam(value = "stuclass", required = false) Integer stuclass
            ,@RequestParam(value = "pnum", required = false) String pnum){
        // 获取页面显示的条数
        int pageNum = Integer.parseInt(request.getParameter("limit")); //pageSize
        // 获取页面当前页
        int currPage = Integer.parseInt(request.getParameter("page")); //pageIndex
        // 计算数据库的分页从第几行开始取数
        // 假设每页显示条数为pageNum10条　当前页为第currPage3页　则(3-1)*10=20
        // sql 语句为　　select * from 表    where 条件   limit 20,10
        int pageCount =(currPage - 1) * pageNum;
        List<Mark> list = markService.findMarkService(isflag,markDateStart,markDateEnd,pnum,stuclass,pageCount,pageNum);
        String json= JSON.toJSONString(list);
        int count= markService.findMarkCountService(isflag,markDateStart,markDateEnd,pnum,stuclass);
        String path = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"
                + json + "}";
        return path;
    }
    //显示修改页面
    //根据id查询
    @RequestMapping("/showUpdMark")
    public String showUpdSort(Model model,@RequestParam(value = "mid", required = false)Integer mid) {
        model.addAttribute("mid",mid);
        return "mark/updMark";
    }

    //根据id查询显示数据
    @RequestMapping("/findMarkById")
    @ResponseBody
    public String findPaperById(@RequestParam(value = "mid", required = false) Integer mid) {
        Mark Mark= markService.findMarkByIdService(mid);
        String json= JSON.toJSONString(Mark);
        return json;
    }

    //修改
    @RequestMapping("updMark")
    @ResponseBody
    public int updPaper(Mark mark){
        int count=0;
        if(mark!=null){
            count= markService.updMarkService(mark);
        }
        return count;
    }

    //删除
    @RequestMapping("delMark")
    @ResponseBody
    public int delPaper(@RequestParam(value = "mid", required = false)Integer mid){
        int count = markService.delMarkService(mid);
        return count;
    }

    //显示发送页面
    @RequestMapping("/showSendMss")
    public String showSendMss(Model model) {
        return "mark/sendMss";
    }
    //发送短信
    @RequestMapping("sendMss")
    @ResponseBody
    public int sendMss(@RequestParam(value = "phone", required = false)String phone
    ,@RequestParam(value = "mark", required = false)String mark){
        int count=0;
        Sendmss s = new Sendmss();
        try {
            s.sendSms(phone, mark);
            count=1;
        } catch (ClientException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("发送成功！");
        return count;
    }

    //显示发送页面
    @RequestMapping("/showSendMss1")
    public String showSendMss1(Model model) {
        return "mark/sendMss1";
    }
    //发送短信
    @RequestMapping("sendMss1")
    @ResponseBody
    public int sendMss1(@RequestParam(value = "phone", required = false)String phone
            ,@RequestParam(value = "text", required = false)String text){
        int count=0;
        SendMsg_webchinese sendMsg_webchinese=new SendMsg_webchinese();
        try {
            sendMsg_webchinese.sendMsg(phone,text);
            count=1;
        } catch (ClientException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("发送成功！");
        return count;
    }

    //发送短信
    @RequestMapping("sendMss2")
    @ResponseBody
    public int sendMss2(@RequestParam(value = "phone", required = false)String phone
            ,@RequestParam(value = "mark", required = false)String mark){
        int count=0;
        Sendmss s = new Sendmss();
        try {
            s.sendSms1(phone, mark);
            count=1;
        } catch (ClientException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("发送成功！");
        return count;
    }
}
