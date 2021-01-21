package com.i2f.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/8 12:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain82 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain82.class,args);
    }
}
