package juc.listSetMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *  四大函数接口
 * 1  当new ArrayList底层实际上new了一个什么？     数组
 * 2. 是什么类型的数组？                           Object
 * 3  数组的初始值是多少？                         默认空引用,第一个add扩容为10之后为1.5倍    HasMap 初始值为16
 * 4. 扩容扩到多少                                 使用copyOf扩容  10-》15-》22-》       扩容为一倍  32
 * 5.ArrayList 线程不安全，所有的方法都未加锁，效率最高
 *    故障现象
 *    java.util.ConcurrentModificationException   并发修改异常
 *    导致原因
 *    多线程并发访问一个资源类  而且资源类没有加锁
 *    解决方案
 *      3.1   new Vector<>()
 *            线程安全，所有的方法加锁，且加锁在方法上，效率最低
 *      3.2   Collections.synchronizedList(new ArrayList<>())
 *           读写删除加锁，且加锁在代码块上，效率较好，遍历未加锁，可以根据实际业务需求，自行决定是否加锁
 *      3.3   new CopyOnWriteArrayList<>()
 *      读未加锁，写使用CAS自旋锁，先复制原数组，修改复制的数组，之后把复制数组重新复制给原地址（当数组过大时，复制效率极低），并发过多，CAS碰撞过多，也会影响性能，读取数据是原数组，所以如果add方法还未执行到setArray方法，读取的数据就是原来的数据。
 *    优化建议
 *    高并发的情况下使用高并发工具类里的  写时复制 new CopyOnWriteArrayList<>()
 *
 * 6.Collection和Collections区别？Collection是List的父接口  Collections是一个集合接口的工具类   ctrl+alt+m  抽取方法快捷键
 * 7.HasSet的底层数据结构？   HasMap  hasSet的add方法存的value时Object类型的常量
 */
public class NotSafeDemo {
    public static void main(String[] args) {
//        listNotSafe();
//        setNotSafe();
        mapNotSafe();
    }

    private static void mapNotSafe() {
        //HashMap 线程不安全   ConcurrentHashMap解决线程不安全
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        //hasSet 线程不安全   CopyOnWriteArraySet解决线程不安全
        Set<String> set = new CopyOnWriteArraySet<>(); // new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        //1.Collections.synchronizedList(new ArrayList<>());
        // 2.new Vector<>();
        // 3.new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
    /*    list.add("a");
        list.add("a");
        list.add("a");
        list.forEach(System.out::println);*/
        //上述单线程不会出问题
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
