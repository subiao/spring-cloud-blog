package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author sub
 * @Date 2021/6/3 15:25
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperOrder80.class, args);
    }

}
