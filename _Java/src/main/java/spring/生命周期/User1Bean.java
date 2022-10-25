package spring.生命周期;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package spring.生命周期
 * @Email: 1624302283@qq.com
 * @date 2022/9/4 23:54
 * @Copyright
 */
public class User1Bean implements BeanNameAware, SmartInitializingSingleton {
    private String name;

    public User1Bean() {
        System.out.println("执行无参构造函数");
    }

    public User1Bean(String name) {
        this.name = name;
        System.out.println("执行有参构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("5. Bean1 属性注入 name");

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("6. 调用 BeanNameAware.setBeanName() 方法");
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("执行User1Bean SmartInitializingSingleton 的回调函数");
    }
}
