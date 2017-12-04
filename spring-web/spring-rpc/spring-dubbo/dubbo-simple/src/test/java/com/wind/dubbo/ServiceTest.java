package com.wind.dubbo;

import com.wind.dubbo.service.HelloService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * dubbo服务测试
 * @author wind
 */
public class ServiceTest {

    @Test
    public void startServer() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"classpath:spring-dubbo-provider.xml"});
        context.start();
        // press any key to exit
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startClient(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring-dubbo-consumer.xml"});
        context.start();

        // obtain proxy object for remote invocation
        HelloService helloService = (HelloService) context.getBean("helloService");
        // execute remote invocation
        String hello = helloService.sayHello("world");
        // show the result
        System.out.println(hello);

    }
}
