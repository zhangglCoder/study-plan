package cn.zpro.study.thread.notify;

public class Task {
    public static boolean flag = true;

    public synchronized void doTask1() {
        while (!flag) {
            try {
                System.out.println("子线程进入等待状态...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 子线程 ->" + i);
        }
        flag = false;
        this.notify();


    }

    public synchronized void doTask2() {
        while (flag) {
            try {
                System.out.println("主线程进入等待状态...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 主线程 ->" + i);
        }
        flag = true;
        this.notify();


    }
}
