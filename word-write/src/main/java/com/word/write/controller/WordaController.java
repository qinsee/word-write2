package com.word.write.controller;

import com.alibaba.fastjson.JSON;
import com.word.write.pojo.Worda;
import com.word.write.service.WordaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("worda")
public class WordaController {
    @Autowired
    private WordaService wordaService;

    @RequestMapping("/openFindWorda")
    public String openFind(){
        return "worda/findWorda";
    }

    @RequestMapping("/findByTwo")
    @ResponseBody
    public String findByTwo(@RequestParam(value = "wordmeaning", required = false) String wordmeaning,@RequestParam(value = "word", required = false) String word, HttpServletRequest request){
        System.out.println(wordmeaning+""+word);
        // 获取页面显示的条数
        int pageNum = Integer.parseInt(request.getParameter("limit")); //pageSize
        // 获取页面当前页
        int currPage = Integer.parseInt(request.getParameter("page")); //pageIndex
        // 计算数据库的分页从第几行开始取数
        int pageCount =(currPage - 1) * pageNum;
        List<Worda> list=wordaService.findWorda(wordmeaning,word,pageCount,pageNum);
        int count=wordaService.countWorda(wordmeaning,word);
        String json= JSON.toJSONString(list);
        String path = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":" + json + "}";
        return path;
    }

    @RequestMapping("openAddWorda")
    public String openAddWorda(){
        return "worda/addWorda";
    }

    @RequestMapping("addWorda")
    @ResponseBody
    public String addWorda(Worda ww){
        int count =wordaService.addWorda(ww);
        return JSON.toJSONString(count);
    }

    @RequestMapping("openUpdWorda")
    public String openUpdWorda(Model model,Integer id){
        Worda sc=wordaService.findOneWorda(id);
        model.addAttribute("sc",sc);
        return "worda/updWorda";
    }
    @RequestMapping("updWorda")
    @ResponseBody
    public String updWorda(Worda ww){
        int count =wordaService.updWorda(ww);
        return JSON.toJSONString(count);
    }

    @RequestMapping("delWorda")
    @ResponseBody
    public String delStuClass(Integer id){
        int count=wordaService.delWorda(id);
        return JSON.toJSONString(count);
    }
}
