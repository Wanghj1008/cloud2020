package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 老版本的synchronized

class Aircondition {
    public int number = 0;

    public synchronized void increment() throws Exception {
        //判断
        if(number !=0){
            this.wait();
        }
        //干活
        number++;
        System.out.println("线程" + Thread.currentThread().getName() + "加1后 number=" + number);
        //通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception{
        //判断
        if(number==0){
            this.wait();
        }
        //干活
        number--;
        System.out.println("线程" + Thread.currentThread().getName() + "减1后 number=" + number);
        //通知
        this.notifyAll();
    }
}
 */

/**
 * 新版lock   换成lock对应的线程等待和唤醒也不是wait和notifyllAll

class Aircondition {
    public int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition=lock.newCondition();


    public  void increment() throws Exception {
        lock.lock();
        try {
            //判断
            while(number !=0){
                condition.await();//this.wait();
            }
            //干活
            number++;
            System.out.println("线程" + Thread.currentThread().getName() + "加1后 number=" + number);
            //通知
            condition.signalAll();//this.notifyAll();   singleton单例
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }*/

/**
 * 新版lock   实现精准控制   多加了两个方法 测试上面需要修改main线程*/

class Aircondition {
    public int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition conditionA=lock.newCondition();
    private Condition conditionB=lock.newCondition();
    private Condition conditionC=lock.newCondition();
    private Condition conditionD=lock.newCondition();

    //A
    public  void increment() throws Exception {
        lock.lock();
        try {
            //判断
            while(number !=0){
                conditionA.await();//this.wait();
            }
            //干活
            System.out.println("线程" + Thread.currentThread().getName() + "AAAAAAAAAAAAAA");
            //通知
            number=1;
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    //B
    public  void decrement() throws Exception{
        lock.lock();
        try {
            //判断
            while (number!=1){
                conditionB.await();//this.wait();
            }
            //干活
            System.out.println("线程" + Thread.currentThread().getName() + "BBBBBBB");
            //通知
            number=2;
            conditionC.signal();//this.notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    //C
    public  void increment1() throws Exception {
        lock.lock();
        try {
            //判断
            while(number !=2){
                conditionC.await();//this.wait();
            }
            //干活
            System.out.println("线程" + Thread.currentThread().getName() + "CCCCCCCCCCC");
            //通知
            number=3;
            conditionD.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    //D
    public  void decrement1() throws Exception{
        lock.lock();
        try {
            //判断
            while (number!=3){
                conditionD.await();//this.wait();
            }
            //干活
            System.out.println("线程" + Thread.currentThread().getName() + "DDDDDDDDDD");
            //通知
            number=0;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 有两个线程  可以操作初始值为0的一个变量
 * 实现一个线程+1一个线程-1
 * 交替实现 来十轮 初始值为0
 * <p>
 * 1.   高内聚低耦合的前提下  线程操作资源类
 * <p>
 * 2.  判断/干活/通知
 * 3.   防止虚假唤醒   四个线程把if换成while
 */
public class ProdConsumerDemo {
    public static void main(String[] args) throws Exception {
        Aircondition aircondition = new Aircondition();
        new Thread().start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondition.increment1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondition.decrement1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
