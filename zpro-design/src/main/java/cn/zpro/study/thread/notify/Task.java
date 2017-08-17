package cn.zpro.study.thread.notify;

public class Task {
    public static boolean flag = true;

    public void doTask1(){
            synchronized (Task.this){
                if(!flag) {
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

    }

    public void doTask2(){
        synchronized (Task.this){
            if(flag){
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
}
