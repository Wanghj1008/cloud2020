package com.i2f.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/19 16:49
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMain9527.class,args);
    }
}
