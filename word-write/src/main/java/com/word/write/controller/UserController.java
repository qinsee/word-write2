package com.word.write.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("sysMenu")
    public String sysMenu(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Integer role=(Integer) session.getAttribute("role");
        model.addAttribute("role",role);
        return "sys/sysMenu";
    }



    @RequestMapping("showLogin")
    public String showLogin(){
        return "sys/login";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request
            , @RequestParam(value = "login", required = false) String login
            , @RequestParam(value = "pwd", required = false) String pwd
            , @RequestParam(value = "role", required = false) Integer role){
        return "sys/login";
    }
}
