package com.sub.controller;

import com.sub.entity.CommonResult;
import com.sub.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author sub
 * @Date 2021/6/3 15:33
 * @Version 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private  String serverPort;
    @GetMapping(value = "/payment/zk")
    public String paymentZk() {
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
