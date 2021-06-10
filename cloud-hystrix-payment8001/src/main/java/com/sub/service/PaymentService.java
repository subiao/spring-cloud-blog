package com.sub.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author sub
 * @Date 2021/6/4 10:15
 * @Version 1.0
 */
@Service
//@DefaultProperties(defaultFallback = "timeoutHandler" )
public class PaymentService {

    public String success(Integer id) {
        return  Thread.currentThread().getName()+"success"+id;
    }

//    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
//    })
//    @HystrixCommand
    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enable",value = "true"),//是否启用断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String failure(@PathVariable("id") Integer id) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if(id<0) {
            int a = 10 / 0;
        }
        return  Thread.currentThread().getName()+"failure"+id;
    }

    public String timeoutHandler(@PathVariable("id") Integer id) {
        return  Thread.currentThread().getName()+"请稍后重试";
    }
}
