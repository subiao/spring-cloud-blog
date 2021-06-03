package com.sub.controller;

import com.sub.entity.CommonResult;
import com.sub.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author sub
 * @Date 2021/5/30 16:48
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    public  static final String  PAYMENT_URL="http://cloud-zookeeper8004";
    @Resource
    RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/zk")
    public String getPaymentInfo() {
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }


}
