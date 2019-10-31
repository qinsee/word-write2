package com.word.write.controller;

import com.alibaba.fastjson.JSON;
import com.word.write.pojo.Paper;
import com.word.write.pojo.StuClass;
import com.word.write.service.PaperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("paper")
public class PaperController {
    @Resource
    private PaperService paperService;
    //展示查询页面
    @RequestMapping("showFindPaper")
    public String showFindPaper(){
        return "paper/findPaper";
    }
    //查询数据
    @RequestMapping("findPaper")
    @ResponseBody
    public String findPaper(HttpServletRequest request,@RequestParam(value = "typeCode", required = false) Integer typeCode
            ,@RequestParam(value = "pnum", required = false) String pnum
            ,@RequestParam(value = "pdateStart", required = false) String pdateStart
            ,@RequestParam(value = "pdateEnd", required = false) String pdateEnd
            ,@RequestParam(value = "classid", required = false) Integer classid
            ,@RequestParam(value = "username", required = false) String username){
        // 获取页面显示的条数
        int pageNum = Integer.parseInt(request.getParameter("limit")); //pageSize
        // 获取页面当前页
        int currPage = Integer.parseInt(request.getParameter("page")); //pageIndex
        // 计算数据库的分页从第几行开始取数
        // 假设每页显示条数为pageNum10条　当前页为第currPage3页　则(3-1)*10=20
        // sql 语句为　　select * from 表    where 条件   limit 20,10
        int pageCount =(currPage - 1) * pageNum;
        List<Paper> list = paperService.findPaperService(pnum,pdateStart,pdateEnd,classid,username,pageCount,pageNum);
        String json= JSON.toJSONStringWithDateFormat(list,"YYYY-MM-DD");
        int count=paperService.findPaperCountService(pnum,pdateStart,pdateEnd,classid,username);

        String path = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"
                + json + "}";
        return path;
    }
    //绑定班级数据
    @RequestMapping("findStuClass")
    @ResponseBody
    public String findStuClass(){
        StuClass stuClass = new StuClass();
        List<StuClass> list=paperService.findStuClassService();
        String json = JSON.toJSONString(list);
        // 运用"{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":"+ json +
        // "}"转换成layui数据表格的值格式
        String layuiJson = "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":"
                + json + "}";
        System.out.println(layuiJson);
        return layuiJson;
    }
    //展示添加页面
    @RequestMapping("showAddPaper")
    public String showAddPaper(){
        return "paper/addPaper";
    }
    //添加
    @RequestMapping("addPaper")
    @ResponseBody
    public int addPaper(Paper paper,@RequestParam(value = "wordCount", required = false) int wordCount){
        int count2=0;
        System.out.println(count2);
        if(paper!=null){
            //int[] a = new int[]{-1,-1,-1,-1};//初始化数组
            Random random = new Random();
            int count1 = 0;//记录有效的随机数个数
            int num=paperService.findWordaCountService();
            int [] array = new int[wordCount];
            int count = 0;              //记录数字存储到那个位置的下标
            boolean flag = true;       // 总循环标记
            boolean ifFlag = false;     //数是否已经在数组中的标记
            int number = new Random().nextInt(num)+1;   //这是产生1-1000的随机数
            System.out.println(array[0]);
            while(flag){
                //判断这个数是否在数组中
                    for(int i=0;i<wordCount;i++){
                        if(array[i]==number){
                            ifFlag =false;
                            break;
                        }
                }

                //如果不在就将这个数存入相应位置
                if(!ifFlag){
                    System.out.println("33333333333333333333333");
                    //判断数组是否满了
                    if(count==wordCount){
                        flag = false;
                    }else{
                        array[count] = number;
                        count++;
                        number = new Random().nextInt(num)+1;
                    }
                }else{   //如果存在，继续产生新的数
                    number = new Random().nextInt(num)+1;    //这里的1000可以自己决定
                }

            }
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+",");
                paper.setWordid(array[i]);
                System.out.println("444444444444444444444444");
                count2=paperService.addPaperService(paper);
            }
            System.out.println();
        }
        System.out.println(count2);
        return count2;
    }
    //显示修改页面
    //根据id查询
    @RequestMapping("/showUpdPaper")
    public String showUpdSort(Model model,@RequestParam(value = "id", required = false) int id) {
        model.addAttribute("id",id);
        return "paper/updPaper";
    }

    //根据id查询显示数据
    @RequestMapping("/findPaperById")
    @ResponseBody
    public String findPaperById(@RequestParam(value = "id", required = false) int id) {
        Paper paper=paperService.findPaperByIdService(id);
        String json= JSON.toJSONStringWithDateFormat(paper,"YYYY-MM-DD");
        return json;
    }

    //修改
    @RequestMapping("updPaper")
    @ResponseBody
    public int updPaper(Paper paper){
        int count=0;
        if(paper!=null){
            count=paperService.updPaperService(paper);
        }
        return count;
    }

    //删除
    @RequestMapping("delPaper")
    @ResponseBody
    public int delPaper(@RequestParam(value = "pnum", required = false) String pnum){
        int count = paperService.delPaperService(pnum);
        return count;
    }
    //展示查询页面
    @RequestMapping("showFind")
    public String showFind(){
        return "writea/examStart";
    }
}
