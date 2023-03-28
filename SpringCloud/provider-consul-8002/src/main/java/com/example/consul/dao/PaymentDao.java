package com.example.consul.dao;

import com.example.common.model.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
