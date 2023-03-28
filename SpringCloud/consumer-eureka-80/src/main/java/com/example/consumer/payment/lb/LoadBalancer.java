package com.example.consumer.payment.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;


public interface LoadBalancer {

    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstanceList);
}
