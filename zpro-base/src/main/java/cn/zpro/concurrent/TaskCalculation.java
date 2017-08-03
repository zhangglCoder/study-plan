package cn.zpro.concurrent;

import java.util.concurrent.Callable;

/**
 * 计算任务
 */
public class TaskCalculation implements Callable<Integer> {
    private int a;
    private int b;

    public TaskCalculation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name + "模拟分布式计算" + (a + b));
        return a + b;
    }

}
