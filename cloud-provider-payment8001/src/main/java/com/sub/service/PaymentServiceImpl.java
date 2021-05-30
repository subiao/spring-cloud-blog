package com.sub.service;

import com.sub.dao.PaymentDao;
import com.sub.entity.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author sub
 * @Date 2021/5/30 16:44
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
