package com.i2f.springcloud.payment.service.impl;

import com.i2f.springcloud.model.Payment;
import com.i2f.springcloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/6 14:50
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfoOk,id:   "+id+"\t "+"O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfoError(Integer id) {
        int timout=3;
        try {
            TimeUnit.SECONDS.sleep(timout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfoError,id:   "+id+"\t "+"O(∩_∩)O8001嘿嘿~"+"   耗时"+timout+"S";
    }
}
