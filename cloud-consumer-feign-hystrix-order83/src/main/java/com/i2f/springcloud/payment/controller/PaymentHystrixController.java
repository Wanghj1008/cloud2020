package com.i2f.springcloud.payment.controller;

import com.i2f.springcloud.payment.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/12 15:21
 */
@RestController
@Slf4j
@RequestMapping("/hystrix")
@DefaultProperties(defaultFallback = "fallbackController")
public class PaymentHystrixController {

    @Value("${server.port}")
    private String port;
    @Resource
    PaymentHystrixService paymentHystrixService;

    @RequestMapping("/payment/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentHystrixService.ok(id);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")//超时时间
    })
    @RequestMapping("/payment/error/{id}")
    public String error(@PathVariable("id") Integer id){
        return paymentHystrixService.error(id);
    }

    public String fallbackController(){
        return "自己客户端繁忙";
    }

}
