package juc.cas;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicReference 原子引用 对应思想就是乐观锁
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        //  参数  一个是原子初始值   一个类似版本号
        // Integer 使用对象缓存机制 默认范围是 -128-127
        //      推荐使用静态工厂方法 ValueOf 获取对象实例，而不是new  因为 ValueOf 使用缓存  new一定会创建新对象分配新的内存空间
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp(); //获取版本号
            System.out.println(Thread.currentThread().getName()+"\t"+"A1====>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //todo 下面两个操作模拟将原子数修改  又将原子数变回本来操作
            System.out.println(atomicStampedReference.compareAndSet(
                    1,
                    2,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));
             stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t"+"A2====>"+stamp);
            System.out.println(atomicStampedReference.compareAndSet(
                    2,
                    1,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));
            stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t"+"A3====>"+stamp);
        },"A").start();

        new Thread(()->{
            //todo 自己期望的线程拿stamp 版本号去操作 acs  此时就能解决ABA问题 他修改不成功 因为版本号不一样
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t"+"B1====>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(
                    1,
                    2,
                    stamp,
                    stamp+ 1));
            stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t"+"B2====>"+stamp);

        },"B").start();



    }
}
