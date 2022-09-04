package spring.生命周期;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package spring.生命周期
 * @Email: 1624302283@qq.com
 * @date 2022/9/4 23:54
 * @Copyright
 */
public class User1Bean {
    private String name;

    public User1Bean() {
        System.out.println("执行无参构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Bean1 5.属性注入 name");

    }
}
