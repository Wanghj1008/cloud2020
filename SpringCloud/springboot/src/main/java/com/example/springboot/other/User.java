package com.example.springboot.other;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class User {

	@Value("${user.name:}")
	private String name;

	@Value("${user.age:}")
	private Integer age;

}
