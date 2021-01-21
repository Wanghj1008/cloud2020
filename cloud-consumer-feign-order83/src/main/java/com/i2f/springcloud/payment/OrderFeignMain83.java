package com.i2f.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/11 17:39
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderFeignMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain83.class, args);
    }
}
