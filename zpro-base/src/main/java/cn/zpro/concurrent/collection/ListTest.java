package cn.zpro.concurrent.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 并发修改集合-综合
 * @author zhanggl
 */
public class ListTest {

    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(10);
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("2");
        list.add("2");
        list.add("11");
        list.add("11");
        list.add("3");
        list.add("3");
        for (int i=0;i<10;i++){
            doTask(downLatch, list);
        }
    }

    private static void doTask(CountDownLatch downLatch, List<String> list) {
        try {
            for (int i = 0; i < 10; i++) {
                new Thread(() -> {
                    deleteItem(list);
                    downLatch.countDown();
                }).start();
            }
            downLatch.await();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteItem(List<String> list) {
        Lock lock = new ReentrantLock();
        Iterator<String> iterator = list.iterator();
        lock.lock();
        try {
            while (iterator.hasNext()) {
                String val = iterator.next();
                if (val.equals("2")) {
                    iterator.remove();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }



    }


}
