package com.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author sub
 * @Date 2021/6/4 10:01
 * @Version 1.0
 */
@SpringCloudApplication
public class Hystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001.class, args);
    }
}
