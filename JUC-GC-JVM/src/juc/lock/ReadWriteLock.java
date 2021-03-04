package juc.lock;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁  可以多线程读  但是只能一个线程写
 * 独占锁(排它锁)  写锁 一次只能被一个线程占有
 * 共享锁         读锁  多个线程可以同时占有
 * 为什么要加读锁不直接不加锁？因为读写是互斥的操作,写的时候不能读 如果不加锁 没写完读到的是脏数据 无法保证数据一致性
 */
public class ReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.set(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                 myCache.get(temp + "");
            }, String.valueOf(i)).start();
        }


    }
}

class MyCache {
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    volatile Map<String, String> map = new HashMap<>();

    public void get(String key) {
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "开始读取");
              map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public  void set(String key, String value) {
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "开始存");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "存OK");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }
}
