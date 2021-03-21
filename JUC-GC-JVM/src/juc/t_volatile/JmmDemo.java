package juc.t_volatile;

import java.util.concurrent.TimeUnit;

/**
 */
public class JmmDemo {
    //todo  下述问题的解决方案  在变量前面加 volatile  不加线程A感知不到number被修改  所以陷入死循环
    private volatile static int number=0;
    public static void main(String[] args) {
        //todo 当两个线程都读取主内存值后   一个线程将主内存值修改 另一个线程没有更新到主内存的值 所以线程A的while还在死循环
        new Thread(()->{
            while (number==0){

            }
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number=1;
        System.out.println(number);
    }
}
