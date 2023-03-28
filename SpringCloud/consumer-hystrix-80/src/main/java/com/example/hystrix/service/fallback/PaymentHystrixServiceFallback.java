package com.example.hystrix.service.fallback;

import com.example.hystrix.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

@Service
public class PaymentHystrixServiceFallback implements PaymentHystrixService {

    @Override
    public String ok(Integer id) {
        return "服务调用失败";
    }

    @Override
    public String error(Integer id) {
        return "服务调用失败";
    }
}
