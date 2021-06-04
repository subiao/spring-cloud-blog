package com.sub.controller;

import com.sub.entity.CommonResult;
import com.sub.entity.Payment;
import com.sub.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private  String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody  Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果{}", payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功！"+serverPort,payment);
        } else {
            return new CommonResult(444, "插入数据失败！", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功！"+serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败！" + id, null);
        }
    }

    @GetMapping(value = "getDiscovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for(String serviceName:services){
            log.info("服务名称{}",serviceName);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance serviceInstance:instances){
            log.info("instanceId{}",serviceInstance.getInstanceId());
            log.info("服务名称{},host名称{},端口号{},uri地址{}\n",
                    serviceInstance.getServiceId(),
                    serviceInstance.getHost(),
                    serviceInstance.getPort(),
                    serviceInstance.getUri()
                    );
        }
        return  discoveryClient;
    }

    @GetMapping(value = "feginTimeOut")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  serverPort;
    }

}
