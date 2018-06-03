package com.wind.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package com.wind.controller
 * @className HiController
 * @note TODO
 * @author wind
 * @date 2018/6/4 0:15
 */
@RestController
@RequestMapping(value = "hi")
public class HiController {

    @GetMapping(value = "sayHi")
    public String sayHi(){
        return "say hi";
    }
}
