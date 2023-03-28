package com.example.consumer;

import com.example.consumer.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "",configuration = MySelfRule.class)
public class Consumer80 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer80.class, args);
    }

}
