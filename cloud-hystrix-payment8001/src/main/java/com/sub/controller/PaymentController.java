package com.sub.controller;

import com.sub.entity.CommonResult;
import com.sub.entity.Payment;
import com.sub.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author sub
 * @Date 2021/5/30 16:48
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("hsytrix")
public class PaymentController{

    @Resource
    PaymentService paymentService;


    @GetMapping(value = "/success/{id}")
    public String success(@PathVariable("id") Integer id) {
        return paymentService.success(id);
    }


    @GetMapping(value = "/failure/{id}")
    public String failure(@PathVariable("id") Integer id) {
        return  paymentService.failure(id);
    }



}
