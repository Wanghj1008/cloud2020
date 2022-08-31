package juc.forkJoinDemo;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

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
public class ForkJoinDemo extends RecursiveTask<Long> {
    Long start;
    Long end;

    //临界值
    private Long temp = 1_00L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    /**计算方法*/
    @Override
    protected Long compute() {
        if ((end - start) > temp) {
            //分支合并计算  先取中间值
            Long middle=start+(end + start)/2;

            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();               // fork 其实就是右回来调compute  进行递归

            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task1.fork();               // fork 其实就是右回来调compute  进行递归

            // join  获取 compute 结果
            Long sum = task1.join() + task2.join();
            return sum;
        } else {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
