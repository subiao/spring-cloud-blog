package com.sub.service;

import com.sub.entity.CommonResult;
import com.sub.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author sub
 * @Date 2021/6/3 20:14
 * @Version 1.0
 */
@FeignClient(value="http://CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
