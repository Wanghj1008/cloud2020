package juc.lock;


import java.util.concurrent.TimeUnit;

public class SpinLockTest {
    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
            spinLockDemo.MyLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.MyUnLock();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            spinLockDemo.MyLock();
            try {

            }finally {
                spinLockDemo.MyUnLock();
            }
        },"B").start();
    }
}
