package Redis;

/**
 * @author Wanghj
 * @Package Redis
 * @date 2021/6/19 22:44
 */
public class Cpu_Demo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(1);
        Thread.sleep(30000);
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(2);
        Thread.sleep(20000);
        bytes=null;
        System.gc();
        System.out.println(3);
        Thread.sleep(100000);

    }
}
