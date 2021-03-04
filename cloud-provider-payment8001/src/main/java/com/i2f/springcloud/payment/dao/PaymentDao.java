package com.i2f.springcloud.payment.dao;

import com.i2f.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.ZonedDateTime;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/6 13:33
 */
@Mapper
public interface PaymentDao {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
