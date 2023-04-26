package com.example.springboot.配置文件加载顺序;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
		@PropertySource("classpath:config.properties")
})
@Data
@ConfigurationProperties(prefix = "config")
public class $6_propertySource {
	private String name;
	private String port;
}
