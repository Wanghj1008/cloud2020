package com.example.payment.service;

import com.example.common.model.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
