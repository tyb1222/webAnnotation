package com.tyb1222.controller;

import com.tyb1222.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(String name) {
        userService.getUserName("123");
        return "index";

    }
}
