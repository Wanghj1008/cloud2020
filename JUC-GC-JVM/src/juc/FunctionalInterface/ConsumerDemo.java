package juc.FunctionalInterface;

import java.util.function.Consumer;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021032021/3/4 23:09
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> objectConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        objectConsumer.accept("jjj");
    }
}
