package com.example.springboot.配置文件加载顺序;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "main")
@Data
// @ConfigurationPropertiesScan("com.xxx.configurationproperties")  启动类指定路径
public class $1_configurationProperties {
	private String hostName;
	private int port;
	private String from;

}
