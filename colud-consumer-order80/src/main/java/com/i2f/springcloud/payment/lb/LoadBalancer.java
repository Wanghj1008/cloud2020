package com.i2f.springcloud.payment.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/11 15:26
 */
public interface LoadBalancer {

    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstanceList);
}
