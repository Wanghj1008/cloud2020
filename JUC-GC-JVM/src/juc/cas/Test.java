package juc.cas;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();
    private int num=0;

    public void lock(){
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " come in");
        if(thread.equals(atomicReference.get())){
            num++;
            return;
        }
        while (! atomicReference.compareAndSet(null, thread)) {
            System.out.println("11111111");
        }
    }

    public void unLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"解锁");
        if(thread.equals(atomicReference.get())) {
            if(num == 0){
                atomicReference.compareAndSet(thread,null);
            }else {
                num--;

            }
        }


    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        new Thread(()->{
            test.lock();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.lock();

        },"A").start();




    }
}


