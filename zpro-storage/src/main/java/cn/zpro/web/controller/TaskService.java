package cn.zpro.web.controller;


/**
 * 线程任务
 */
public class TaskService implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"TaskService start...");
    }
}
