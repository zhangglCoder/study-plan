package cn.zpro.concurrent.join;


/**
 * join方法
 */
public class RunMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "计数器报数 " + i);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "计数器报数 " + i);
                }
            }
        });
        thread1.start();
        thread1.join(); //等待该线程终止（可以达到同步的效果）
        thread2.start();
    }
}
