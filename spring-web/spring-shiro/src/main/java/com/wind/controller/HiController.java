package com.wind.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package com.wind.controller
 * @className HiController
 * @note hi 接口
 * @author wind
 * @date 2018/6/3 14:33
 */
@RestController
@RequestMapping(value = "hi")
public class HiController {

    @GetMapping(value = "sayHi")
    public String sayHi(){
        return "Hi, welcome";
    }

    @GetMapping(value = "sayHello")
    public String sayHello(){
        return "sayHello, welcome";
    }
}
