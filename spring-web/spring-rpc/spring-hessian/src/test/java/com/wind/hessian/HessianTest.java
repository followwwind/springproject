package com.wind.hessian;

import com.caucho.hessian.client.HessianProxyFactory;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * @author com.wind
 */
public class HessianTest {

    @Test
    public void testHessian(){
        try {
            String url = "http://192.168.1.44:8080/test/hessian/helloService";
            HessianProxyFactory factory = new HessianProxyFactory();
            HelloService helloService = (HelloService) factory.create(HelloService.class, url);
            helloService.sayHello("张三");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
