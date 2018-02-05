package cn.zpro.concurrent.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 在 subList 场景中，高度注意对原集合元素个数的修改，会导致子列表的遍历、增加、
    删除均会产生 ConcurrentModificationException 异常
 * @author zhanggl
 */
public class SubListTest {

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        List<Integer> subList = data.subList(1, data.size());
        for (Integer i:subList){
            if(i== 4){
                subList.remove(i);
            }
        }


    }
}
