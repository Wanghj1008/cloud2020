package juc.cas;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Test {
    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();
    private int num = 0;

    public void lock() {
        Thread thread = Thread.currentThread();
        if (thread.equals(atomicReference.get())) {
            System.out.println(Thread.currentThread().getName() + " 再次加锁");
            num++;
            return;
        }
        while (!atomicReference.compareAndSet(null, thread)) {
        }
        System.out.println(Thread.currentThread().getName() + " 加锁");
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "解锁");
        if (thread.equals(atomicReference.get())) {
            if (num == 0) {
                atomicReference.compareAndSet(thread, null);
            } else {
                num--;
            }
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        new Thread(()->{
            test.lock();
            test.lock();
            test.unLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.unLock();
        },"A").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                test.lock();
                test.unLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }

    /**
     * 自旋实现加锁解锁

    public void lock1() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {
        }
        System.out.println(thread.getName() + "获取锁");
    }
     public void unlock1() {
     Thread thread = Thread.currentThread();
     System.out.println(thread.getName() + "释放锁");
     atomicReference.compareAndSet(thread, null);
     }
    public static void main(String[] args) {
        Test test = new Test();
        new Thread(() -> {
            try {
                test.lock1();

                TimeUnit.SECONDS.sleep(5);
                test.unlock1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                test.lock1();
                test.unlock1();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }*/
}


