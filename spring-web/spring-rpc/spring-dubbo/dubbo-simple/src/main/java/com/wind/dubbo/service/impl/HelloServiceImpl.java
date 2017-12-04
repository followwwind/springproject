package com.wind.dubbo.service.impl;

import com.wind.dubbo.service.HelloService;

/**
 * @author wind
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
