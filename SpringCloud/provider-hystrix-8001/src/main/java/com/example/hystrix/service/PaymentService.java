package com.example.hystrix.service;

import com.example.hystrix.service.impl.PaymentServiceImplRollback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(fallbackFactory = PaymentServiceImplRollback.class)
public interface PaymentService {

    public String paymentInfoOk(Integer id);

    public String paymentInfoError(Integer id);
}
