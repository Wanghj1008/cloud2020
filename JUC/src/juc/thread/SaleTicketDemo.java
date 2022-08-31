package juc.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//OOP  资源类
class Ticket {
    private int number = 30;
    //List list = new ArrayList();   接口=new  实现类
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (number--) + "张票,还剩" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

/**
 * 题目：三个销售员   卖出  30张票
 * 如何编写企业化多线程代码
 * 固定的编程套路+模板是什么？
 * <p>
 * 1.在  高内聚低耦合的前提下， 线程   操作   资源类
 * <p>
 * 1.1先创建一个资源类Ticket
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        //获取CPU的核数     CPU密集型  IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());


        Ticket ticket = new Ticket();

        new Thread(() -> {for (int i = 1; i <= 40; i++) {ticket.sale();}},"A").start();
        new Thread(() -> {for (int i = 1; i <= 40; i++) {ticket.sale();}},"B").start();
        new Thread(() -> {for (int i = 1; i <= 40; i++) {ticket.sale();}},"C").start();

        //Thread t1 = new Thread();  无参构造
        //Thread t1 = new Thread(Runnable target,String name);  有参构造  new接口(匿名内部类)
    /*    new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        }, "A").start();//不是马上启动这个线程  只是就绪了
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        }, "C").start();*/

    }
}
