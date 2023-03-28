package com.example.hystrix.service.impl;

import com.example.hystrix.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：   " + Thread.currentThread().getName() + "   paymentInfoOk,id:   " + id + "\t " + "O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfoError(Integer id) {
        int timout = 3;
        try {
            TimeUnit.SECONDS.sleep(timout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：   " + Thread.currentThread().getName() + "   paymentInfoError,id:   " + id + "\t " + "O(∩_∩)O8001嘿嘿~" + "   耗时" + timout + "S";
    }
}
