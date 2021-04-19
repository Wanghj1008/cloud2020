package com.example.demo.controller;

import com.example.demo.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.List;

/**
 * @author Wanghj
 * @Package com.example.demo.controller
 * @date 2021/4/16 13:56
 */
public class Consumer {
    private static final String CHANNEL = "WHJ";
    private volatile  int count = 1;

    private MyJedisPubSub myJedisPubSub = new MyJedisPubSub();

    public synchronized void supplier(String message){
        Jedis jedis = JedisPoolUtils.getJedis();
       jedis.lpush(CHANNEL,message.concat(String.valueOf(count)));
       jedis.lpush("WYQ",message.concat(String.valueOf(count)));
        System.out.println(Thread.currentThread().getName() + "往whj频道生产消息,count=" + count);
        count++;
    }
    /**
    while(true)可以一直消费消息。但是当消息消费完还会不停创建连接造成浪费
     */
    public synchronized void consumer(){
        Jedis jedis = JedisPoolUtils.getJedis();
        List<String> brpop = jedis.brpop(0, CHANNEL,"WYQ");
        count--;
        System.out.println(Thread.currentThread().getName() + "--消费whj消息--,count=" + brpop);
    }

    public void putMessage(String message) {
        Jedis jedis = JedisPoolUtils.getJedis();
        Long publish = jedis.publish(CHANNEL, message);//返回订阅者数量
        System.out.println(Thread.currentThread().getName() + " put message,count=" + count+",subscriberNum="+publish);
        count++;
    }

    public void consumerMessage() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.subscribe(myJedisPubSub, CHANNEL);//第一个参数是处理接收消息，第二个参数是订阅的消息频道
    }

    class MyJedisPubSub extends JedisPubSub {
        @Override
        /** JedisPubSub类是一个没有抽象方法的抽象类,里面方法都是一些空实现
         * 所以可以选择需要的方法覆盖,这儿使用的是SUBSCRIBE指令，所以覆盖了onMessage
         * 如果使用PSUBSCRIBE指令，则覆盖onPMessage方法
         * 当然也可以选择BinaryJedisPubSub,同样是抽象类，但方法参数为byte[]
         **/
        public void onMessage(String channel, String message) {
            System.out.println(Thread.currentThread().getName()+"-接收到消息:channel=" + channel + ",message=" + message);
        }
    }

}
