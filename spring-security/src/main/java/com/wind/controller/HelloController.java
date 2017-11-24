package com.wind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wind
 */

@RestController
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "admin")
    public String admin(){
        return "hello admin";
    }

}
