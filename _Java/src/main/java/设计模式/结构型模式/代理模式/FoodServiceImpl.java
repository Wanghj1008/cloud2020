package 设计模式.结构型模式.代理模式;

//实现接口
public class FoodServiceImpl implements FoodService {
    @Override
    public void makeNoodle() {
        System.out.println("make noodle");
    }

    @Override
    public void makeChicken() {
        try {
            System.out.println("make Chicken");
            int a=1 / 0;
        } catch (Exception e) {
            System.out.println("exception");
            throw e;
        } finally {
            System.out.println("finally");
        }
    }

    public static void test() {

    }
}