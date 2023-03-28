package com.example.hystrix.service;

import com.example.hystrix.service.fallback.PaymentHystrixServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "PAYMENT-SERVICE", fallback = PaymentHystrixServiceFallback.class)
public interface PaymentHystrixService {

    @RequestMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id);

    @RequestMapping("/hystrix/error/{id}")
    public String error(@PathVariable("id") Integer id);

}
