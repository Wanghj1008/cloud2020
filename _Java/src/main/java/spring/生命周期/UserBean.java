package spring.生命周期;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class UserBean implements InitializingBean, BeanNameAware, DisposableBean, ApplicationContextAware {
	private int id;

	private String name;

	public UserBean() {
	}

	public UserBean(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("2. 调用构造函数");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println("5. 属性注入 id");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("5. 属性注入 name");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("6. 调用 BeanNameAware.setBeanName() 方法");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		UserBean userBean = (UserBean) applicationContext.getBean("userBean");
		System.out.println(userBean);
		System.out.println("7. 调用 BeanNameAware.setBeanName() 方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("9. 调用 InitializingBean.afterPropertiesSet() 方法");
	}

	public void myInit() {
		System.out.println("10. 调用 init-method 方法");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("12. 调用 DisposableBean.destroy() 方法");
	}

	public void myDestroy() {
		System.out.println("13. 调用 destroy-method 方法");
	}

	@Override
	public String toString() {
		return "UserBean{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}