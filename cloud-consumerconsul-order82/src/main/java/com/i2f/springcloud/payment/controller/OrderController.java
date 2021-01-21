package com.i2f.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/8 12:46
 */
@RestController
@Slf4j
public class OrderController {
    public static final String URL="http://consul-provider-payment";
    @Value("${server.port}")
    private String serverPort;
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/consumer/order")
    public String order(){
        return restTemplate.getForObject(URL+"/payment/consul",String.class);
    }
}
