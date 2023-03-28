package com.example.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Dashboard9001 {

    public static void main(String[] args) {
        SpringApplication.run(Dashboard9001.class, args);
    }

}
