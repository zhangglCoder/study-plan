package cn.zpro.concurrent.training;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * 启动2个线程，分别打印1-100的奇数和1-100的偶数
 */
public class question1 {


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=100;i++){
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=100;i++){
                    if(i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);

                    }
                }
            }
        }).start();
    }

}
