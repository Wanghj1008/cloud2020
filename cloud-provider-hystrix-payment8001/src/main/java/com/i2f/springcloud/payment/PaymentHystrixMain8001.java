package com.i2f.springcloud.payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/12 14:28
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//@SpringCloudApplication    代替上面三个
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
    /**
     * 此配置是为了服务监控配置。与服务容错本身无关，Springcloud升级后的坑
     * ServletRegistrationBean因为Springboot的默认路劲不是/hystrix.stream
     * 只要在自己的项目里配置上下面的Servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet=new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
