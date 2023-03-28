package com.example.feign80.controller;

import com.example.common.model.CommonResult;
import com.example.common.model.Payment;
import com.example.feign80.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/feign")
@Slf4j
public class PaymentFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/feign/timeOut")
    String timeOut(){
        return paymentFeignService.timeOut();
    }
}
