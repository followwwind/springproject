package com.wind.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hi")
public class HiController {

    @GetMapping("sayHi")
    public String sayHi(){
        return  "sayHi";
    }


    @GetMapping("sayHello")
    public String sayHello(){
        return  "hello world";
    }
}
