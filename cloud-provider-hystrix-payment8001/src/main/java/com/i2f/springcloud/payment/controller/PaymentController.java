package com.i2f.springcloud.payment.controller;


import cn.hutool.core.util.IdUtil;
import com.i2f.springcloud.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import javafx.beans.DefaultProperty;
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
 * @date 2021012021/1/6 14:52
 */
@RestController
@Slf4j
@RequestMapping("/hystrix")
/**
 * 本Controller中所有方法全局服务降级调用的方法
 * @DefaultProperties(defaultFallback = "fallbackController")
  */
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        int i=1/0;
        String result = paymentService.paymentInfoOk(id);
        log.info("*********result**********"+result);
        return result;
    }

    @HystrixCommand(fallbackMethod = "fallbackController",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")//超时时间
    })
    @RequestMapping("/error/{id}")
    public String error(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoError(id);
        log.info("*********result**********"+result);
        return result;
    }

    public String fallbackController(Integer id){
        return "服务繁忙 请稍后再试";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少熔断
    })
    @RequestMapping("/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") int id){
        if(id <0){
            throw new RuntimeException("id不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功 ，流水号"+simpleUUID;
    }
    public String paymentCircuitBreakerFallback( int id){
        return "服务熔断 降级处理";
    }
}
