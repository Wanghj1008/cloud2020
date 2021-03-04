package juc.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 同步队列
 */
public class SynchronousQueueTest  {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"PUT A");
                synchronousQueue.put("A");
                System.out.println(Thread.currentThread().getName()+"PUT B");
                synchronousQueue.put("B");
                System.out.println(Thread.currentThread().getName()+"PUT C");
                synchronousQueue.put("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+">>>>>"+synchronousQueue.take());
                System.out.println(Thread.currentThread().getName()+">>>>>"+synchronousQueue.take());
                System.out.println(Thread.currentThread().getName()+">>>>>"+synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
