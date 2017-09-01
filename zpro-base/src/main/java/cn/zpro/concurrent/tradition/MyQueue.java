package cn.zpro.concurrent.tradition;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 分布式阻塞队列（手动实现）
 */
public class MyQueue {
    private final int maxSize;
    private final int minSize = 0;
    private LinkedList<Object> list = new LinkedList<>();
    private AtomicInteger count = new AtomicInteger(0);
    private Object lock = new Object();

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 添加队列的一个元素
     */
    public void put(Object obj) {
        synchronized (lock) {
            while (maxSize == count.get()) {
                //阻塞
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(obj);
            count.incrementAndGet();//计数器+1
            System.out.println("添加成功" + obj);
            lock.notify();
        }
    }

    /**
     * 获取队列的一个元素
     */
    public Object take() {
        Object result = null;
        synchronized (lock) {
            while (minSize == count.get()) {
                //阻塞
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            result = list.removeFirst();
            count.getAndDecrement();//计数器-1
            System.out.println(" 元素 " + result + " 被消费 ");
            lock.notify();
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        MyQueue queue = new MyQueue(3);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        TimeUnit.SECONDS.sleep(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("e");
                queue.put("f");
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.take();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.take();
            }
        }).start();
    }
}
