package com.example.hystrix.controller;

import com.example.hystrix.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/hystrix")
public class PaymentHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @RequestMapping("/payment/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        return paymentHystrixService.ok(id);
    }

    @RequestMapping("/payment/error/{id}")
    public String error(@PathVariable("id") Integer id) {
        return paymentHystrixService.error(id);
    }


}
