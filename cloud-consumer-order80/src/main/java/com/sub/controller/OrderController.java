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

    public  static final String  PAYMENT_URL="http://localhost:8001";
    @Resource
    RestTemplate restTemplate;


    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
