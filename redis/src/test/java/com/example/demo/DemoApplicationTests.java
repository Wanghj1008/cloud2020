package com.example.demo;

import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("name", "whj");
		System.out.println(redisTemplate.opsForValue().get("name"));
		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		connection.flushDb();
		System.out.println(redisTemplate.opsForValue().get("name"));

	}

	@Test
	void test(){
		User user = new User("whj", 20);
		redisTemplate.opsForValue().set("user", user);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

}
