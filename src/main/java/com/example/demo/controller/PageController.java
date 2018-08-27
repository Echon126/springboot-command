package com.example.demo.controller;

import com.example.demo.dao.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    String name="info message name zhangsan end";
//    @RequestMapping("/welcome")
//    public String index() {
//        return "welcome";
//    }
//
//    @RequestMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }

    public String getInfo(){
        return name;
    }
    public void getInfos(){

    }
}
