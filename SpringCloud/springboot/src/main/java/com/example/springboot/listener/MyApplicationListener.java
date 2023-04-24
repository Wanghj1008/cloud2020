package com.example.springboot.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MyApplicationListener implements SpringApplicationRunListener {

	@Override
	public void starting(ConfigurableBootstrapContext bootstrapContext) {
		System.out.println("正在执行初始方法哦");
	}

	@Override
	public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
		System.out.println("正在执行环境方法");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("正在执行与准备上下文方法");
	}
}
