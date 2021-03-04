package juc.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列四种API
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("B"));
        System.out.println(arrayBlockingQueue.add("C"));
        // java.lang.IllegalStateException:    Queue full   队列长度为3 插入第四个报错
//        System.out.println(arrayBlockingQueue.add("d"));
        System.out.println("-----------------------------------");
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        //java.util.NoSuchElementException        队列长度已经为零 继续删除报错
//        System.out.println(arrayBlockingQueue.remove());
    }

    /**
     * 不抛异常有返回值
     */
    public static void test2() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("B"));
        System.out.println(arrayBlockingQueue.offer("C"));
        //队列长度为3 插入第四个不报错  有返回值false
        System.out.println(arrayBlockingQueue.offer("D"));
        System.out.println("------------------------------");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // 队列长度已经为零 继续删除 返回null
        System.out.println(arrayBlockingQueue.poll());
    }

    /**
     * 阻塞等待
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("C");
        //队列长度为3 插入第四个会 阻塞等待 死等程序卡死
        //        arrayBlockingQueue.put("D");
        System.out.println("----------------------");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        // 队列长度已经为零 继续删除  阻塞等待 死等程序卡死
        //System.out.println(arrayBlockingQueue.take());
    }

    /**
     * 超时等待
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("B"));
        System.out.println(arrayBlockingQueue.offer("C"));
        //队列长度为3 插入第四个不报错  有返回值false
        System.out.println(arrayBlockingQueue.offer("D",2, TimeUnit.SECONDS));
        System.out.println("------------------------------");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // 队列长度已经为零 继续删除 返回null
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
    }
}

