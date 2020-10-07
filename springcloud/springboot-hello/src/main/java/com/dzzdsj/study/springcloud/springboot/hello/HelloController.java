package com.dzzdsj.study.springcloud.springboot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient discoveryClient; // 服务发现客户端


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ServiceInstance testWeb(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        try {
            //hystrix 默认超时时间是2000ms，指定3000内随机数，概率性触发熔断
            int sleepTime = new Random().nextInt(3000);
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            System.out.println("sleepTime=" + sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serviceInstance;
    }
}
