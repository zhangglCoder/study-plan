package cn.zpro.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 栅栏
 */
public class RunMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("数据库写入完毕,每个子线程自己想干嘛就去干嘛");
            }
        });

        for (int i = 0; i < 4; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " = 写入数据完毕，等待其他线程写入完毕");
                        Thread.sleep(2000);      //以睡眠来模拟写入数据操作
                        barrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " = 做自己的事情去咯...");
                }
            });
        }

        executorService.shutdown();

    }
}
