package juc.forkJoinDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 去博客先看 Future +executor弄清楚 怎么继承实现  再IDEA ctrl+n
 * 求和计算：  1 + 10000 求和
 * 1.直接for循环
 * 2.如何forkJoin
 *     1.需要有一个 forkJoinPool 通过他来执行
 *     2.计算任务 forkJoinPool.execute(forkJoinTask())
 *          3. forkJoinTask() 两个常用实现
 *              1.RecursiveAction  递归事件  没有返回值
 *              2.RecursiveTask    递归任务   有返回值    会调用 compute()  方法计算
 *     3.计算类要继承forkJoinTask
 * 3.Stream并行流
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1(1L, 10_0000_0000L);     //          1亿       结果=5000000050000000  ,所用时间====>1388
        //将封装类Long改成long后
       // test1(1L, 10_0000_0000L);     //          10亿       结果=500000000500000000  ,所用时间====>476
        test2();                     //forkJoin  结果=500000000500000000  ,所用时间====>479  todo 注意中间值后面的+1
       // test3();                       //并行流      10亿     结果=500000000500000000  ,所用时间====>277
        //test3();                     //不并行流    10亿     结果=50000000050000不然c 0000  ,所用时间====>724


    }

    //   * 1.直接for循环
    public static void test1(long start, long end) {
        long startTime = System.currentTimeMillis();
        long sum = 0L;
        for (long i = start; i <= end; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("结果=" + sum + "  ,所用时间====>" + (endTime - startTime));
    }

    // * 2.如何forkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
//        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1L,1_0000_0000L);
        ForkJoinTask<Long> task = new ForkJoinDemo(1L, 10_0000_0000L);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //todo          //需要用 ForkJoinPool.execute 来执行任务  没有直接返回结果  可以 task.get()获取
        forkJoinPool.execute(task);
        //获取结果
        Long sum = task.get();
      /*  //todo 需要用 ForkJoinPool.submit  来提交任务  有返回结果
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();*/
        long endTime = System.currentTimeMillis();
        forkJoinPool.shutdown();
        System.out.println("结果=" + sum + "  ,所用时间====>" + (endTime - startTime));
    }

    public static void test3(){
        long startTime = System.currentTimeMillis();

//        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().sum();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0,Long::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("结果=" + sum + "  ,所用时间====>" + (endTime - startTime));
    }
}
