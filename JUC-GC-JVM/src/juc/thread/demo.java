package juc.thread;

import jdk.jfr.events.ExceptionThrownEvent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class demo1 {
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition1 = lock.newCondition();

    public void test1() {
        lock.lock();
        try {
            while (number % 2 == 0) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number++;

            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void test2() {
        lock.lock();
        try {
            while ((number % 2 != 0)) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number++;

            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class demo {
    public static void main(String[] args) {
        demo1 demo1 = new demo1();
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                demo1.test1();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                demo1.test2();
            }
        }, "B").start();

    }
}
