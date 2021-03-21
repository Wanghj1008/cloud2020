package juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS  compareAndSet  比较并交换
 *     unsafe类  ： java无法操作内存  但是可以调用C++ 操作内存
 *     native类可以操作      unsafe类可以操作内存
 *     缺点：  自旋锁 会浪费时间
 *            2.ABA问题   解决方案： 原子引用
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //                                          期望      更新
        //    public final boolean compareAndSet(int expect, int update) {
        //如果期望达到了 就更新否则不更新  CAS是CPU的指令
        //因为是自旋锁 如果期望不是就会一直循环


        //todo  aba问题
        // =================       捣乱的线程=============================
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        // todo=======================预期的线程拿到的2020  其实是捣乱线程修改过后的
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
    }
}
