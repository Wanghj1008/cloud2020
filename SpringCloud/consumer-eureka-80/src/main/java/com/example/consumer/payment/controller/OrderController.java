package com.example.consumer.payment.controller;

import com.example.common.model.CommonResult;
import com.example.common.model.Payment;
import com.example.consumer.payment.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

//----------------------------------普通调用start-------------------------------------------------------------
    // 没有负载均衡 写死地址
//  public static final String PAYMENT_URL="http://localhost:8001";
    //获取 Eureka注册中心的对应服务,实现负载均衡  注意：需要在 restTemplate 上增加 @LoadBalanced
    public static final String PAYMENT_URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/save")
    public CommonResult<Payment> save(@RequestBody Payment payment){
        log.info("测试--------------"+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("测试--------------"+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
//----------------------------------普通调用end-------------------------------------------------------------

//----------------------------------手写负载算法调用Start-------------------------------------------------------------
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/lb")
    public String getPaymentIb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.serviceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/payment/lb", String.class);
    }
//----------------------------------手写负载算法调用End-------------------------------------------------------------

}
