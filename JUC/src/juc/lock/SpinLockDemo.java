package juc.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {
    //int   0
    //Thread  null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁
    public void MyLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "====>MyLock");

        while (!atomicReference.compareAndSet(null, thread)) {
        }
    }

    //解锁
    public void MyUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "====>MyUnLock");

       atomicReference.compareAndSet(thread,null);
    }

}
