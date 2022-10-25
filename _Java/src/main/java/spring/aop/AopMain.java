package spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import proxy.CglibProxyFactory;
import proxy.FoodService;
import proxy.FoodServiceImpl;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package proxy
 * @Email: 1624302283@qq.com
 * @date 2022/9/3 21:45
 * @Copyright
 */
public class AopMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        FoodService text = (FoodService) context.getBean("foodService");
        text.makeChicken();
    }

    public void test(){
        // 1.创建对象
        FoodServiceImpl foodService = new FoodServiceImpl();
        // 2.创建代理对象
        CglibProxyFactory proxy = new CglibProxyFactory(foodService);
        // 3.调用代理对象的增强方法,得到增强后的对象
        FoodService createProxy = (FoodService) proxy.createProxy();
        createProxy.makeChicken();
    }
}
