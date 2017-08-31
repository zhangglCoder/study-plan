package cn.zpro.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 栅栏
 */
public class RunMain2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("集合出发");
            }
        });

        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(Thread.currentThread().getName() + " = 抵达集合地点1，当前已有" + barrier.getNumberWaiting() + "已经到达，正在等候");
                        barrier.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(Thread.currentThread().getName() + " = 抵达集合地点2，当前已有" + barrier.getNumberWaiting() + "已经到达，正在等候");
                        barrier.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(Thread.currentThread().getName() + " = 抵达集合地点3，当前已有" + barrier.getNumberWaiting() + "已经到达，正在等候");
                        barrier.await();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();

    }
}
