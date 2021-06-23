package com.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author sub
 * @Date 2021/6/15 20:44
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider9001 {
    public static void main(String[] args) {
        SpringApplication.run(Provider9001.class, args);
    }

}
