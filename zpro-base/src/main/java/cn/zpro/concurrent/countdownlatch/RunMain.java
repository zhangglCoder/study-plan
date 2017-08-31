package cn.zpro.concurrent.countdownlatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程计数器
 */
public class RunMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(2);//执行计数器

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //
                try{
                    System.out.println(Thread.currentThread().getName() + "do任务");
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    latch.countDown(); //计数器-1
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //
                try{
                    System.out.println(Thread.currentThread().getName() + "do任务");
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    latch.countDown(); //计数器-1
                }
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("任务完成");

    }


}
