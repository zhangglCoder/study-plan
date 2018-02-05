package cn.zpro.concurrent.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String,String> m = Collections.synchronizedMap(new HashMap<String,String>());
        for (int i = 0;i<20;i++){
            m.put(i+"","test"+i);
        }
        for (Map.Entry<String,String> mm:m.entrySet()){
            System.out.println(mm.getKey()+"--->"+mm.getValue());
        }

//        for (Object key:m.keySet()){
//            System.out.println(key);
//            System.out.println(m.get(key));
//        }
    }
}
