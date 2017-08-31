package cn.zpro.concurrent.condition;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁的用法
 */
public class RunMain {
    public static int seq = 1;
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        Lock lock = new ReentrantLock(); //创建读写锁对象
        final Condition condition1  = lock.newCondition();
        final Condition condition2  = lock.newCondition();
        final Condition condition3  = lock.newCondition();

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (seq != 1){
                        condition1.await();
                    }
                    System.out.println(Thread.currentThread().getName() +" A");
                    seq = 2;
                    condition2.signal();

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (seq != 2){
                        condition2.await();
                    }
                    System.out.println(Thread.currentThread().getName() +" B");
                    seq = 3;
                    condition3.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });


        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (seq != 3){
                        condition3.await();
                    }
                    System.out.println(Thread.currentThread().getName() +" C");
                    seq = 1;
                    condition1.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        threadPool.shutdown();//线程池销毁
    }
}
