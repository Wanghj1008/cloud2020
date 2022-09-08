package spring.生命周期;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		UserBean user = (UserBean) applicationContext.getBean("userBean");
//		user.setBeanName("das");
		((AbstractApplicationContext) applicationContext).close();
	}
}