package com.sub.service;

import com.sub.entity.CommonResult;
import com.sub.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author sub
 * @Date 2021/6/3 20:14
 * @Version 1.0
 */
@Component
@FeignClient(value="cloud-hsytrix-payment",fallback = ErrorService.class)
public interface HsytrixPaymentService {

    @GetMapping(value = "hsytrix/success/{id}")
    public String success(@PathVariable("id") Integer id);

    @GetMapping(value = "hsytrix/failure/{id}")
    public String failure(@PathVariable("id") Integer id);
}
