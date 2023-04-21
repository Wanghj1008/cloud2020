package com.example.springboot.listener;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.env.ConfigurableEnvironment;

public class MyApplicationListener implements SpringApplicationRunListener {

	@Override
	public void starting() {
		System.out.println("正在执行初始方法哦");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		System.out.println("正在执行环境方法");
	}
}
