package com.example.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//开启 Eureka 配置
@EnableEurekaClient
//开启服务发现
@EnableDiscoveryClient
public class Payment8002 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class, args);
    }

}
