package com.i2f.springcloud.payment.controller;

import com.i2f.springcloud.model.CommonResult;
import com.i2f.springcloud.model.Payment;
import com.i2f.springcloud.payment.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/6 16:22
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
//    public static final String PAYMENT_URL="http://localhost:8001";  没有负载均衡 写死地址
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
//    public static final String GET_PAYMENT_URL="http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/payment/save")
    public CommonResult<Payment> save(Payment payment){
        log.info("测试--------------"+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment,CommonResult.class);
    }

    @GetMapping("/payment/entity/save")
    public CommonResult<Payment> entitySave(Payment payment){
        log.info("测试--------------"+payment);
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/save",payment,CommonResult.class).getBody();
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("测试--------------"+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/get/entity/{id}")
    public CommonResult<Payment> getEntityPayment(@PathVariable("id") Long id){
        log.info("测试--------------"+id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }
        return new CommonResult<>(444,"调用失败");
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentIb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.serviceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/payment/lb",String.class);
    }

}
