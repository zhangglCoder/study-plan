package cn.zpro.concurrent.vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhanggl
 */
public class RunMain {

    public static ArrayList<Integer> integers = new ArrayList<>();
    public static ConcurrentHashMap<Integer,Object> integersMap = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = Collections.synchronizedList(RunMain.integers);

        Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    integersMap.put(i,i);
                }

        });

        Thread thread2 = new Thread(() -> {
            synchronized (integers){
                for (int i = 0; i < 5; i++) {
                    integersMap.remove(i);
                }
            }

        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

        System.out.println(integersMap.size());


    }

}
