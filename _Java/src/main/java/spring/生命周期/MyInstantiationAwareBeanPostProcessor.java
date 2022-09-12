package spring.生命周期;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;
import proxy.CglibProxyFactory;
import proxy.FoodService;
import proxy.FoodServiceImpl;
import proxy.JDKProxyFactory;

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        if ("userBean".equals(beanName) || "user1Bean".equals(beanName)) {
            System.out.println("1. 调用 InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation() 方法");
//			return new UserBean(); //Bean生命周期只执行一次 任何一个代理对象都会导致生命周期缩短
        }
        if ("foodService".equals(beanName)) {
            CglibProxyFactory proxy = new CglibProxyFactory(new FoodServiceImpl());
            FoodService createProxy = (FoodService) proxy.createProxy();
            return createProxy;
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("userBean".equals(beanName) || "user1Bean".equals(beanName)) {
//            UserBean userBean = (UserBean) bean;
            System.out.println("3. 调用 InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation() 方法");
//            System.out.println(userBean);
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("userBean".equals(beanName) || "user1Bean".equals(beanName)) {
            System.out.println("4. 调用 InstantiationAwareBeanPostProcessor.postProcessProperties() 方法");
        }
        return null;
    }
}