package cn.zpro.concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程之间数据交换
 */
public class RunMain {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        Exchanger<String> exchanger = new Exchanger<>();

        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    String data = "李四";
                    System.out.println(Thread.currentThread().getName()+ " 传递="+data);
                    Thread.sleep((long) (Math.random() * 10000));
                    String exchange = exchanger.exchange(data);
                    System.out.println(Thread.currentThread().getName()+ " 返回="+exchange);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String data = "张三";
                    System.out.println(Thread.currentThread().getName()+ " 传递=" +data);
                    Thread.sleep((long) (Math.random() * 10000));
                    String exchange = exchanger.exchange(data);
                    System.out.println(Thread.currentThread().getName() + " 返回=" + exchange);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
