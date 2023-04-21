package com.example.springboot;

import com.example.springboot.other.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.example.springboot")
public class SpringbootApplication {

	public static void main(String[] args) {
		String[] a = {"王昊杰","123"};
		args = a;
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);
		User bean = applicationContext.getBean(User.class);
		System.out.println(bean.getName() + "\t" + bean.getAge());
	}


}
