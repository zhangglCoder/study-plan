package cn.zpro.concurrent.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String,String> m = Collections.synchronizedMap(new HashMap<String,String>());
        m.put("key","val");

        for (Map.Entry<String,String> mm:m.entrySet()){
            System.out.println(mm.getKey());
            System.out.println(mm.getValue());
        }

//        for (Object key:m.keySet()){
//            System.out.println(key);
//            System.out.println(m.get(key));
//        }
    }
}
