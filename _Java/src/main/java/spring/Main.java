package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		UserController bean = context.getBean(UserController.class);
		System.out.println(bean.getName());
	}
}
