package juc.streamDemo;

import java.util.Arrays;
import java.util.List;

/**
 * 题目要求 1分钟完成此题  只能用一行代码
 * 现在又五个用户 ！筛选
 * 1.ID必须全是偶数
 * 2.年龄必须大于23
 * 3.用户名转为大写字母
 * 4.用户名字母倒着排序
 * 5.只输出一个用户
 */
public class Test {
    public static void main(String[] args) {
        User user1 = new User(1,"a",21);
        User user2 = new User(2,"b",22);
        User user3 = new User(3,"c",23);
        User user4 = new User(4,"d",24);
        User user5 = new User(6,"e",25);

        //1.首先将数据转成集合
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

        users.stream()
                .filter(user -> { return   user.getId()%2==0 &&user.getAge()>23; })
                .map((user )-> { return user.getName().toUpperCase(); })
                //倒叙
                .sorted((u1,u2)->{return u2.compareTo(u1);})
                .limit(1)
   /*             .filter(user -> {return user.getId()%2==0;})
                .filter(user -> {return user.getAge()>23;})*/
                .forEach(System.out::println);

    }
}
