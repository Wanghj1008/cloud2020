package proxy;

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
        } catch (Exception e) {
            System.out.println("exception");
        } finally {
            System.out.println("finally");
        }
    }

    public static void test() {

    }
}