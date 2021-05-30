package com.sub.controller;

import com.sub.entity.CommonResult;
import com.sub.entity.Payment;
import com.sub.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author sub
 * @Date 2021/5/30 16:48
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果{0}", payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功！",payment);
        } else {
            return new CommonResult(444, "插入数据失败！", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果{0}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功！", payment);
        } else {
            return new CommonResult(444, "查询失败！" + id, null);
        }
    }
}
