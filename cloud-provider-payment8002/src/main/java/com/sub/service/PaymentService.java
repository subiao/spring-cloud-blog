package com.sub.service;

import com.sub.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author sub
 * @Date 2021/5/30 16:46
 * @Version 1.0
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
