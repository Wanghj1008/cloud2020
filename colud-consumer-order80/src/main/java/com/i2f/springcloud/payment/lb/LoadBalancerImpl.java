package com.i2f.springcloud.payment.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/11 15:28
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current,next));
        System.out.println("**************next"+next);
        return next;
    }

    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() %serviceInstanceList.size();

        return serviceInstanceList.get(index);
    }
}
