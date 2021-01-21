package com.i2f.springcloud.payment.controller;


import com.i2f.springcloud.model.CommonResult;
import com.i2f.springcloud.model.Payment;
import com.i2f.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/6 14:52
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment){
        int save = paymentService.save(payment);
        log.info("插入结果"+save);
        if(save>0){
            return new CommonResult(200,"插入数据库成功 serverPort:"+serverPort,save);
        }else {
            return new CommonResult(404,"插入数据库失败",null);

        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("插入结果"+paymentById);
        if(paymentById != null){
            return new CommonResult(200,"查询数据库成功 serverPort:"+serverPort,paymentById);
        }else {
            return new CommonResult(404,"没有对应ID="+id+"的记录",null);
        }
    }

    @GetMapping("/discovery")
    public DiscoveryClient discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("****element******"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            //yml主机名 payment8001   ip地址 127.20.10.13   端口 8001
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentIb(){
        return serverPort;
    }

    @GetMapping("/feign/timeOut")
    public String timeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
