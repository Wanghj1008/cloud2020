package com.i2f.springcloud.payment.controller;

import com.i2f.springcloud.model.CommonResult;
import com.i2f.springcloud.model.Payment;
import com.i2f.springcloud.payment.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/11 17:57
 */
@RestController
@RequestMapping("/feign")
@Slf4j
public class PaymentFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return paymentFeignService.getPaymentById(id);
//       return paymentFeignService.paymentConsul();
    }

    @GetMapping("/payment/feign/timeOut")
    String timeOut(){
        //OpenFeign 底层Ribbon  客户端一般默认等待1s
        return paymentFeignService.timeOut();
    }
}
