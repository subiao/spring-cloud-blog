package com.sub.controller;

import com.sub.entity.CommonResult;
import com.sub.entity.Payment;
import com.sub.service.PaymentService;
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
@RequestMapping("consumer")
public class OrderController {

    @Resource
    PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return  paymentService.getPaymentById(id);
    }

}
