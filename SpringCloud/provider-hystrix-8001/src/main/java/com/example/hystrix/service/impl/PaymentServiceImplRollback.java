package com.example.hystrix.service.impl;

import com.example.hystrix.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImplRollback implements PaymentService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "繁忙，稍后再试";
    }

    @Override
    public String paymentInfoError(Integer id) {
        return "繁忙，稍后再试";
    }
}
