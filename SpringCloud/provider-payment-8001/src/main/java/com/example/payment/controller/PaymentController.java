package com.example.payment.controller;

import com.example.common.model.CommonResult;
import com.example.common.model.Payment;
import com.example.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {


//----------------------------------普通调用start-------------------------------------------------------------
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment) {
        log.info("插入实体" + payment);
        int save = paymentService.save(payment);
        log.info("插入结果" + payment.getId());
        if (save > 0) {
            return new CommonResult(200, "插入成功 serverPort:" + serverPort, payment.getId());
        }
        return new CommonResult(404, "插入失败", null);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("查询ID" + id);
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("插入结果" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功 serverPort:" + serverPort, paymentById);
        }
        return new CommonResult(404, "没有对应ID=" + id + "的记录", null);
    }
//----------------------------------普通调用end-------------------------------------------------------------
//----------------------------------服务发现start-----------------------------------------------------------
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public List<ServiceInstance> discovery(){
        // 获取 Eureka上注册的所有服务名
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("****element******"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"
                    +instance.getHost()+"\t"
                    +instance.getPort()+"\t"
                    +instance.getUri());
        }
        return instances;
    }
//----------------------------------服务发现end-------------------------------------------------------------

/*    @GetMapping("/payment/lb")
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
    }*/
}
