package com.springBootCode.springbootcode.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloFirstMethod(){
        return "First Method Called !!";
    }
}
