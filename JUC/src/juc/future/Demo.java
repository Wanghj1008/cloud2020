package juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用   ajax
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**没有返回值的异步回调
        CompletableFuture<Void> objectCompletableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
         System.out.println(Thread.currentThread().getName()+"\t"+"没有参数");
         } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //get会阻塞方法  当异步调用返回结果才会继续往下执行
        System.out.println(objectCompletableFuture.get());
        System.out.println("111");*/

        CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"有参数");
                int i=1/0;
                return 1024;
        });
        System.out.println("111111111111111111");

        System.out.println(future.whenComplete((t, u) -> {
            System.out.println(t);  //正确的返回结果
            System.out.println(u);  //错误的返回结果
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;             //可以获取到错误的返回结果
        }).get());
    }
}
