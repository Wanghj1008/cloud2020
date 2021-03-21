package juc.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉式   1.私有构造器   2.给自己对象赋null值   3.提供外部获取实例接口。如果为空new自己
 * 问题  多线程下实例不止出现一个
 */
public class LazyMan {
    private boolean dsadans = false;

    private LazyMan() throws Exception {
        synchronized (LazyMan.class) {
            if (dsadans==false) {
//                if (lazyMan != null) {
                    throw new RuntimeException("不要用反射破坏");
//                }
            }
        }
        dsadans=false;
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    private volatile static LazyMan lazyMan = null;

    //双检锁懒汉 == DCL模式懒汉
    public static LazyMan getLazyMan() throws Exception {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                    /*
                    不是一个原子操作：   可能会有指令重排现象
                            1.开辟内存空间
                            2.执行构造方法，创建懒汉对象
                            3.把对象指向内存空间
                     */
                }
            }
        }
        return lazyMan;
    }

}

class test {
    /**普通
     *  public static void main(String[] args) {
     for (int i = 0; i < 10; i++) {
     new Thread(() -> {
     LazyMan.getLazyMan();
     }).start();
     }

     }*/
    /**
     * 通过反射破坏
     */
    public static void main(String[] args) throws Exception {
//        LazyMan instance = LazyMan.getLazyMan();
        //todo  1.利用无参构造器可以创建破坏单例  解决：在无参构建加锁。如果对象存在抛错
       /* Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan lazyMan = declaredConstructor.newInstance();*/
        //todo 2.不用56行创建对象 两个都用无参构造创建  解决：加一个密钥设置 ture false  加一层判断
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan lazyMan = declaredConstructor.newInstance();
        LazyMan instance = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(lazyMan);

    }
}
