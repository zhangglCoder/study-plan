package cn.zpro.concurrent;

/**
 * 模拟火车票，开启三个窗口卖票
 * @author zhanggl
 */
public class TestHost {

    public static Integer tiket = 100;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (tiket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售卖" + "| 票:" + tiket--);

                }
            }
        });
        thread1.setName("1号窗口");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (tiket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售卖" + "| 票:" + tiket--);
                }
            }
        });
        thread2.setName("2号窗口");
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (tiket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售卖" + "| 票:" + tiket--);
                }
            }
        });
        thread3.setName("3号窗口");
        thread3.start();

    }
}
