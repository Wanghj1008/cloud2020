package com.example.demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Wanghj
 * @Package com.example.demo.config
 * @date 2021/4/12 15:24
 */
@Configuration
public class configTest {

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws Exception {
        //为了开发方便直接使用Strig Object类型
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //默认携带  set连接工厂
        template.setConnectionFactory(redisConnectionFactory);

        //配置具体的序列化方式  1.String 2.Jackson 3.jdk  序列化java对象（被序列化的对象必须实现Serializable接口）,无法转义成对象。
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        //使用 ObjectMapper 进行转义
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(objectMapper);

        //String 序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //key 采用String类型序列化
        template.setKeySerializer(stringRedisSerializer);
        //hash key采用String类型序列化
        template.setHashKeySerializer(stringRedisSerializer);
        //value 采用Jackson类型序列化
        template.setValueSerializer(serializer);
        //hash value采用jackson类型序列化
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();

        return template;
    }
}
