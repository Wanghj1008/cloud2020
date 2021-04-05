package juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021032021/3/31 15:39
 */
public class Test1 {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " come in");
        while (! atomicReference.compareAndSet(null, thread)) {

        }
    }
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + " invoke myUnLock");
    }

    public static void main(String[] args) {

        //线程操作资源类
        Test1 spinLockDemo = new Test1();

        new Thread(() -> {
            spinLockDemo.myLock();
//            try {TimeUnit.SECONDS.sleep(5);} catch (Exception e) {e.printStackTrace();}
//            spinLockDemo.myUnLock();
        }, "AAA").start();

        //保证A先启动、然后获得锁
        try {
            TimeUnit.SECONDS.sleep(1);} catch (Exception e) {e.printStackTrace();}

        new Thread(() -> {
            spinLockDemo.myLock();
//            try {TimeUnit.SECONDS.sleep(5);} catch (Exception e) {e.printStackTrace();}
//            spinLockDemo.myUnLock();
        }, "BBB").start();

    }
}
