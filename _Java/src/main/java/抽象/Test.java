package 抽象;

/**
 * @author Wanghj
 * @Package 抽象
 * @date 2021/4/30 16:22
 */
public class Test extends Abstract {
    @Override
    public void _Abstract() {
        System.out.println("抽象方法");

    }

    public static void main(String[] args) {
        Test test = new Test();
        test._Abstract();
    }
}
