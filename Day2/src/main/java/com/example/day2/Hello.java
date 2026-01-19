package com.example.day2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// controller is for html file and restcontroller for json data
@Controller
//@ResponseBody
// response body is to send simple text
public class Hello {
    @GetMapping("/")
    static String hello(){
        return "index";
    }
    @GetMapping("/user")
    static String user(){
        return "user";
    }
    @GetMapping("/home")
    static String home(){
        return "home";
    }
}
