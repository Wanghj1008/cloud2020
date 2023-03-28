package com.example.consumer.payment.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBalancerImpl implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public int getAndIncrement() {
        int current = this.atomicInteger.get();
        if (current >= 2147483647) {
            atomicInteger.compareAndSet(current, 0);
            return 0;
        }
        return atomicInteger.incrementAndGet();
    }

    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();

        return serviceInstanceList.get(index);
    }
}
