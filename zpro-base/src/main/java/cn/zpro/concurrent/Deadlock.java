package cn.zpro.concurrent;

/**
 * 死锁
 * @author zhanggl
 */
public class Deadlock {

    public static void main(String[] args) throws Exception {
        Deadlock deadlock1 = new Deadlock();
        Deadlock deadlock2 = new Deadlock();

        new Thread(()->{
            synchronized (deadlock1){
                try {
                    Thread.sleep(2000);
                    System.out.println("deadlock1 do action");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (deadlock2){
                    try {
                        Thread.sleep(2000);
                        System.out.println("deadlock2 do action");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();

        new Thread(()->{
            synchronized (deadlock2){
                try {
                    Thread.sleep(2000);
                    System.out.println("deadlock1 do action");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (deadlock1){
                    try {
                        Thread.sleep(2000);
                        System.out.println("deadlock2 do action");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();
    }
}
