package cn.zpro.concurrent.jdk;

import cn.zpro.concurrent.TaskCalculation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * JDK自带的线程池
 */
public class JdkPool {


    //Executor
    public static void main(String[] args) throws Exception {
//        ExecutorService executorPool = Executors.newFixedThreadPool(5);
//        executorPool.execute(new TaskService());
//        executorPool.execute(new TaskService());
//        executorPool.execute(new TaskService());
//        executorPool.execute(new TaskService());
//        executorPool.execute(new TaskService());
//        executorPool.shutdown();

        ExecutorService executorPool = Executors.newCachedThreadPool();
        Future<Integer> future1 = executorPool.submit(new TaskCalculation(1, 2));
        Future<Integer> future2 = executorPool.submit(new TaskCalculation(9, 1));
        System.out.println(Thread.currentThread().getName()+"主线程计算总和:"+(future1.get() + future2.get()));
        executorPool.shutdown();
    }
}
