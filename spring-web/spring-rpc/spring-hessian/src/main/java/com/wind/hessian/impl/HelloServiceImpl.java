package com.wind.hessian.impl;

import com.wind.hessian.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author com.wind
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }
}
