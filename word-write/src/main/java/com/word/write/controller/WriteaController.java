package com.word.write.controller;//package com.word.write.controller;

import com.alibaba.fastjson.JSON;
import com.word.write.pojo.Mark;
import com.word.write.pojo.Paper;
import com.word.write.pojo.Writea;
import com.word.write.service.MarkService;
import com.word.write.service.WriteaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("writea")
public class WriteaController {
    @Resource
    private WriteaService writeaService;

    @Resource
    private MarkService markService;

    @RequestMapping("showExam")
    public String showExam(){
        return "writea/examStart";
    }
    @RequestMapping("examStart")
    @ResponseBody
    public String examStart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer classid = 1;
        String pnum="20191006175835";
        List<Paper> list = writeaService.showExam(pnum,classid);
        session.setAttribute("listp",list);
        String json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping("finshiWritea")
    @ResponseBody
    public double finshiWritea(@RequestParam(value = "writeword1", required = false) String[] writeword1,HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("listp"));
        List<Paper> list=(List<Paper>) session.getAttribute("listp");
        System.out.println(writeword1);
        String j=writeword1.toString();
        String word="";
        for (int i = 0; i <writeword1.length ; i++) {
            word=word+writeword1[i]+",";
        }
        System.out.println(word.substring(0,word.lastIndexOf(",")));
        word=word.substring(0,word.lastIndexOf(","));
        word=word.substring(word.indexOf("[")+1,word.lastIndexOf("]"));
        String[] array = word.split(",");
        String pnum=list.get(0).getPnum();
        Integer stuclass=list.get(0).getClassid();
        double mark1=0;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(new Date());
        String word1="";
        String word2="";
        Writea  writea=new Writea();
        System.out.println(list.size());
        int flag=1;
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k <list.size() ; k++) {
                    word1= list.get(i).getWord();
                    word2= array[i].substring(1,array[i].lastIndexOf('"'));
                    System.err.println(word1);
                    System.out.println(word2);
                    if(word1.equals(word2)){
                        writea.setIsyes(1);
                        writea.setPid(list.get(i).getPid());
                        writea.setWriteword(word2);
                        writea.setWritedate(date);
                        writea.setStuid("22");
                        writea.setStuclass(stuclass);
                        System.out.println(list.get(i).getClassid());
                        writea.setPnum(pnum);
                        mark1=mark1+4;
                        flag=flag+1;
                        System.out.println(mark1);
                        break;
                    }else{
                        writea.setIsyes(0);
                        writea.setPid(list.get(i).getPid());
                        writea.setWriteword(word2);
                        writea.setWritedate(date);
                        writea.setStuid("22");
                        writea.setStuclass(stuclass);
                        writea.setPnum(pnum);
                        System.out.println("---->"+list.get(i).getPnum());
                        flag=flag+1;
                        break;
                    }
            }
            if(flag==1){
                writeaService.addWritea(writea);
            }

            System.out.println(array[i].substring(1,array[i].lastIndexOf('"')));
        }
        Mark mark=new Mark();
        mark.setIsflag(0);
        mark.setMark(mark1);
        mark.setMarkdate(date);
        mark.setPnum(pnum);
        mark.setStuclass(stuclass);
        mark.setStuid("22");
        markService.addMarkService(mark);
        return mark1;
    }
    @RequestMapping("showQuestion")
    public String showQuestion(){
        return "writea/showQuestion";
    }

    @RequestMapping("question")
    @ResponseBody
    public String question(){
        Integer classid = 1;
        String pnum="20191006175835";
        List<Paper> list=writeaService.findPaperByPnum(pnum,classid);
        String json=JSON.toJSONString(list);
        return json;
    }

    @RequestMapping("historyWritea")
    public String historayWritea(){
        return "writea/historyWritea";
    }

    @RequestMapping("detailWritea")
    public String detailWritea(){
        return "writea/detailWritea";
    }

    @RequestMapping("detailQuestion")
    @ResponseBody
    public String detailQuestion(HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer classid = 1;
        String pnum="20191006175835";
        String stuid="22";
        List<Writea> list = writeaService.findWriteaByIsYes(null,pnum,classid,stuid);
        String json = JSON.toJSONString(list);
        return json;
    }

}

