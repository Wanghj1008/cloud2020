package spring.生命周期;

import org.springframework.context.support.AbstractApplicationContext;
import spring.LTW.LtwBean;
import spring.事件广播.TestEvent;
import spring.合并Bean定义.ChildBean;

public class BeanLifeCycleTest {
	public static void main(String[] args) {
		InitPropertySourceTest applicationContext = new InitPropertySourceTest("application.xml");

		// 事件广播
		applicationContext.publishEvent(new TestEvent("hello", "whj"));
		//LTW加载阶段代理
		LtwBean ltwBean = (LtwBean) applicationContext.getBean("ltwBean");
		ltwBean.test();
		//普通生命周期流程
		UserBean user = (UserBean) applicationContext.getBean("userBean");
		user.setBeanName("das");
		//合并Bean定义  getMergedLocalBeanDefinition
		ChildBean childBean = (ChildBean) applicationContext.getBean("childBean");
		System.out.println(childBean);
		((AbstractApplicationContext) applicationContext).close();

	}
}