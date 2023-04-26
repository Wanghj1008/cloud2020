package com.example.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


public class MyApplicationListener implements SpringApplicationRunListener {
	private final SpringApplication application;
	private final String[] args;

	public MyApplicationListener(SpringApplication application, String[] args) {
		this.application = application;
		this.args = args;

	}

	@Override
	public void starting() {
		System.out.println("正在执行初始方法哦");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		System.out.println("正在执行环境方法");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("正在执行与准备上下文方法");
	}
}
