package com.example.consumer.controller;

import com.example.common.model.CommonResult;
import com.example.common.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    // 没有负载均衡 写死地址
//  public static final String PAYMENT_URL="http://localhost:8001";
    //获取 Consul 注册中心的对应服务,实现负载均衡  注意：需要在 restTemplate 上增加 @LoadBalanced
    public static final String PAYMENT_URL = "http://payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/save")
    public CommonResult<Payment> save(@RequestBody Payment payment) {
        log.info("测试--------------" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("测试--------------" + id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


}
