package juc;

import java.util.concurrent.CountDownLatch;

/**
 * 计数器   减法计数器
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6 刚好6个线程执行完 如果减不到0 下面await方法会卡死

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "go out");
                countDownLatch.countDown();//减一操作
            },String.valueOf(i)).start();
        }
        //等待计数器归零在往下执行
        countDownLatch.await();

        System.out.println("关门");
    }
}
