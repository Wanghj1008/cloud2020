package com.i2f.springcloud.payment.service;

import com.i2f.springcloud.model.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/6 14:49
 */
public interface PaymentService {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
