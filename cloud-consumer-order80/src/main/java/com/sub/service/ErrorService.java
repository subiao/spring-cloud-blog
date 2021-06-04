package com.sub.service;

import org.springframework.stereotype.Component;

/**
 * @Author sub
 * @Date 2021/6/4 17:53
 * @Version 1.0
 */
@Component
public class ErrorService implements HsytrixPaymentService {
    @Override
    public String success(Integer id) {
        return "┭┮﹏┭┮";
    }

    @Override
    public String failure(Integer id) {
        return "┭┮﹏┭┮";
    }
}
