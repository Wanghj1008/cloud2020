package juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 特点：缓存  返回值 和异常处理
 * 1.有缓存  当线程执行的是一个futureTask对象会触发缓存  当都是new FutureTask不触发
 * 2.get返回值有时候会阻塞。    一般都是放在最后一行或者使用异步通讯来处理
 */
public class CallableTest  {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<String> stringFutureTask = new FutureTask<>(myThread);
        //只和Runnable接口有关联  没办法直接写入Callable接口
        //使用适配器模式
        new Thread(stringFutureTask,"A").start();
        new Thread(stringFutureTask,"B").start();
        System.out.println(stringFutureTask.get());

    }
}
//泛型思想  为返回值
class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("Call");
        return "hhhhhh";
    }
}
class MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        super.run();
    }
}
