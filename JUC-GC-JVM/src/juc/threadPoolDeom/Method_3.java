package juc.threadPoolDeom;

import java.util.concurrent.*;

/**
 * Executors 相当于一个工具类
 *          四大方法
 *         ExecutorService ThreadPoll = Executors.newSingleThreadExecutor();//单个线程
 *         ExecutorService ThreadPoll1 = Executors.newFixedThreadPool(5);//创建一个固定大小的线程池
 *         ExecutorService ThreadPoll2 = Executors.newCachedThreadPool();//可伸缩的，遇强则强
 *         ScheduledExecutorService ThreadPoll3 = Executors.newScheduledThreadPool(3);//定时线程 延时3s处理
 *         四大拒绝策略
 *         new ThreadPoolExecutor.AbortPolicy()  //丢弃任务并抛出RejectedExecutionException异常。
 *         new ThreadPoolExecutor.CallerRunsPolicy() //由调用线程处理该任务 【谁调用，谁处理】
 *         new ThreadPoolExecutor.DiscardPolicy()   //也是丢弃任务，但是不抛出异常。
 *         new ThreadPoolExecutor.DiscardOldestPolicy()  //丢弃线称队列的旧的任务，将新的任务添加,不抛出异常
 */
public class Method_3 {
    public static void main(String[] args) {
/*        ExecutorService ThreadPoll = Executors.newSingleThreadExecutor();//单个线程
        ExecutorService ThreadPoll1 = Executors.newFixedThreadPool(5);//创建一个固定大小的线程池
        ExecutorService ThreadPoll2 = Executors.newCachedThreadPool();//可伸缩的，遇强则强
        ScheduledExecutorService ThreadPoll3 = Executors.newScheduledThreadPool(3);//定时线程 延时3s处理*/
        ExecutorService ThreadPoll=new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy()  //丢弃任务并抛出RejectedExecutionException异常。
                //new ThreadPoolExecutor.CallerRunsPolicy() //由调用线程处理该任务 【谁调用，谁处理】
                //new ThreadPoolExecutor.DiscardPolicy()   //也是丢弃任务，但是不抛出异常。
                new ThreadPoolExecutor.DiscardOldestPolicy()  //丢弃线称队列的旧的任务，将新的任务添加,不抛出异常


        );

        try {
            for (int i = 1; i <=9 ; i++) {
                ThreadPoll.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t"+"OK");
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ThreadPoll.shutdown();
        }

    }
}
