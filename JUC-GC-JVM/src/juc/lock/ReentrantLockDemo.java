package juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        demo demo = new demo();
        new Thread(()->{
            demo.sms();
        },"A").start();
        new Thread(()->{
            demo.sms();
        },"B").start();
    }
}
class demo{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"sms");
        Phone();
    }
    public synchronized void Phone(){
        System.out.println(Thread.currentThread().getName()+"Phone");
    }
}
