package cn.zpro.study.thread.notify;

/**
 * 线程通信（notify/wait）
 */
public class Demo3 {

    public static void main(String[] args) {
        Task task = new Task();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<= 50;i++){
                    task.doTask1();
                }
            }
        }).start();

        for (int i = 1;i<= 50;i++){
            task.doTask2();
        }

    }
}
