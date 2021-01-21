package com.i2f.springcloud.payment.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/6 16:27
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //开启负载均衡注解
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
