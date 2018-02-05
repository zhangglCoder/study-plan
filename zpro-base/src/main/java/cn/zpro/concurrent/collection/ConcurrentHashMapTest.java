package cn.zpro.concurrent.collection;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author zhanggl
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        HashMap<String,String> hashMap = new HashMap<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("k1","value");
        //concurrentHashMap.put("k2",null); NPE
        //concurrentHashMap.put(null,"test");//NPE
        System.out.println(concurrentHashMap);


        hashMap.put("h1","h1");
        hashMap.put("h2",null);
        hashMap.put(null,"h2");
        hashMap.put(null,null);
        System.out.println(hashMap);
    }
}
