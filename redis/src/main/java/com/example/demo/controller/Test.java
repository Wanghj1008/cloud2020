package com.example.demo.controller;

/**
 * @author Wanghj
 * @Package com.example.demo.controller
 * @date 2021/4/16 14:04
 */
public class Test {
    public static void main(String[] args) {

        Consumer consumer = new Consumer();
    /*    new Thread(() -> {
            for (int i = 1; i <5 ; i++) {
                consumer.supplier("--消息--");
            }
        }, "A").start();

            new Thread(()->{
                for (int i = 1; i <20 ; i++) {
                    consumer.consumer();
                }
              },"B").start();*/

        new Thread(() -> {
            for (int i = 1; i <5 ; i++) {
                consumer.putMessage("--消息--");
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 1; i <20 ; i++) {
                consumer.consumerMessage();
            }
        },"B").start();
    }
}
