package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import proxy.FoodServiceImpl;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package proxy
 * @Email: 1624302283@qq.com
 * @date 2022/9/3 23:17
 * @Copyright
 */
@EnableAspectJAutoProxy
@ComponentScan
@Configuration
@Import({MyAspect.class, FoodServiceImpl.class})
public class JavaConfig {


}
