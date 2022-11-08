package spring.transaction.传播属性;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package spring.transaction.传播属性
 * @Email: 1624302283@qq.com
 * @date 2022/9/12 22:13
 * @Copyright
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserInfoServiceImpl bean = (UserInfoServiceImpl) context.getBean("userInfoServiceImpl");
        bean.service();
    }
}
