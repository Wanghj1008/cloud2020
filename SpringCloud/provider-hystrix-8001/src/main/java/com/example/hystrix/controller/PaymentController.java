package com.example.hystrix.controller;

import cn.hutool.core.util.IdUtil;
import com.example.hystrix.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/hystrix")
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @RequestMapping("/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info("result:" + result);
        return result;
    }

    @RequestMapping("/error/{id}")
    public String error(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoError(id);
        log.info("result:" + result);
        return result;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少熔断
    })
    @RequestMapping("/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") int id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功 ，流水号" + simpleUUID;
    }

    public String paymentCircuitBreakerFallback(int id) {
        return "服务熔断 降级处理";
    }
}
