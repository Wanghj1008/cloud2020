package com.i2f.springcloud.payment.service;

import com.i2f.springcloud.model.Payment;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/6 14:49
 */
public interface PaymentService {
    public String paymentInfoOk(Integer id);
    public String paymentInfoError(Integer id);
}
