package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package spring
 * @Email: 1624302283@qq.com
 * @date 2022/9/3 16:08
 * @Copyright
 */
@Configuration
public class MyConf {
    @Bean
    public UserController userController(){
        return  new UserController();
    }
}
