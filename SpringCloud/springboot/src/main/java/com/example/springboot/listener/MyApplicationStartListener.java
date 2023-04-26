package com.example.springboot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Description:
 * @ClassName: MyApplicationStartListener
 * @Author: WHJ
 * @Date: 2023/4/25 16:29
 * @Version: 6.0.18.0
 */
public class MyApplicationStartListener implements ApplicationListener<ApplicationStartingEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
		System.out.println("容器启动完毕");
	}
}
