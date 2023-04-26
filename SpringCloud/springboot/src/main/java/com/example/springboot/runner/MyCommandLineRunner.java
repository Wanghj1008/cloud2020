package com.example.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("dsaad");
	}
}
