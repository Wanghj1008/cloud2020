import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.mybatis.service.UserService;

import java.util.*;

/**
 * @author Wanghj
 * @Package PACKAGE_NAME
 * @date 2021/6/25 13:23
 */
public class Test {


    public static void main(String[] args) throws Exception {
        // 文件监听器
//        File configFile = new File("E:/a.txt");
//        WatchMonitor watchMonitor = WatchMonitor.create(configFile, WatchMonitor.ENTRY_MODIFY, WatchMonitor.ENTRY_CREATE);
//        watchMonitor.setWatcher(new DelayWatcher(new ServerConfigWatcher(), 200));
//        watchMonitor.start();

//        change(new int[]{1});
        // Mybatis执行
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
/*        DefaultSqlSessionFactory sessionFactory = (DefaultSqlSessionFactory) context.getBean("sqlSessionFactoryBean");
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.selectList().forEach((user) -> {
            System.out.println(user.toString());
        });*/

        // Spring封装Mybatis执行
        UserService userService = (UserService) context.getBean("userService");
        userService.getList().forEach((user) -> {
            System.out.println(user.toString());
        });
        userService.getList().forEach((user) -> {
            System.out.println(user.toString());
        });

    }

    private static void change(int[] a) {
        Hashtable<Object, Object> map = new Hashtable<>();
        map.put(null,1);
        map.put("name","whj");
        map.put("name",null);
        map.put(null,1);


    }
}
