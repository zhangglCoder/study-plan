package cn.zpro.concurrent.cyclicbarrier;


import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏
 */
public class RunMain3 {

    static CyclicBarrier c = new CyclicBarrier(5);

    public static void main(String[] args) {
        System.out.println("主线程开始");
        System.out.println("CyclicBarrier:"+c.getNumberWaiting());
        for (int i=0;i<4;i++){
            new Thread(()->{
                try {
                    c.await();
                    System.out.println("do aciton");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }



    }
}
