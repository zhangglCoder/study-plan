package cn.zpro.concurrent.collection;


import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhanggl
 */
public class TreeMapTest {

    public static void main(String[] args) {
        sortMap();
    }
    private static void sortLink(){
        LinkedHashMap hashMap = new LinkedHashMap();
        hashMap.put(1,"zhangsan1");
        hashMap.put(4,"zhangsan4");
        hashMap.put(2,"zhangsan2");
        System.out.println(hashMap);
    }

    private static void sortMap(){
        TreeMap<Integer,String> treeMap = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o2).compareTo((Integer) o1);
            }
        });
        treeMap.put(1,"zhangsan1");
        treeMap.put(4,"zhangsan4");
        treeMap.put(102,"zhangsan2");
        treeMap.put(99,"zhangsan3");

        for (Map.Entry<Integer,String> m: treeMap.entrySet()){
            System.out.println(m.getKey()+"---"+m.getValue());
        }
    }
}
