package spring.生命周期;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitPropertySourceTest extends ClassPathXmlApplicationContext {
    InitPropertySourceTest(String lo){
        super(lo);
    }

    @Override
    protected void initPropertySources() {
        getEnvironment().getSystemProperties().put("os.test","1");
        getEnvironment().setRequiredProperties("os.test");
    }

    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        super.setAllowBeanDefinitionOverriding(true);
        super.setAllowCircularReferences(true);
        super.customizeBeanFactory(beanFactory);
    }
}
