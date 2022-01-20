package com.example.springboot1study01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //interface:http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){
        //call business
        return "hello,world";
    }
}
