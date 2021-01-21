package com.i2f.springcloud.payment.service.fallback;

import com.i2f.springcloud.payment.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/13 14:24
 */
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
