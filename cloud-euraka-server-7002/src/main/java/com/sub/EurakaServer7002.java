package com.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author sub
 * @Date 2021/5/31 17:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurakaServer7002.class, args);
    }

}
