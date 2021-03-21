package juc.t_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不保证原子性
 *
 */
public class Demo2 {
//    private volatile static int number=0;
    private volatile static AtomicInteger number=new AtomicInteger();

    public static void add(){
        //number++;   //这个方法不是一个原子性操作  内部 先取值 然后+1 最后赋值\
        number.getAndIncrement();   //number的+1操作   底层是CAS  这些类的底层都是和操作系统挂钩  实际是在内存中修改值
    }

    public static void main(String[] args) {
        //todo 如果保证原子性  此结果应该为20000   解决方案 1.加锁  2.使用原子类解决
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    add();
                }
            }).start();
        }
        System.out.println(number);
    }
}
