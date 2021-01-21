package com.i2f.springcloud.payment.service;

import com.i2f.springcloud.payment.service.fallback.PaymentHystrixServiceFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/12 15:18
 */
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentHystrixServiceFallback.class)
public interface PaymentHystrixService {

    @RequestMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id);


    @RequestMapping("/hystrix/error/{id}")
    public String error(@PathVariable("id") Integer id);


}
