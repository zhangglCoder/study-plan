package cn.zpro.se;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson3 {

    public static void main(String[] args) {
        coolections(new ArrayList<>(), Arrays.asList(1,2,3,4,5),2);
    }


    /**
     * 通过递归算法解决-排列组合问题
     *
     * @param selected 已选择临时变量
     * @param data     需要排列组合的数据
     * @param n        需要排列的个数
     */
    public static void coolections(List<Integer> selected, List<Integer> data, int n) {

        if(n==0){
            for (Integer i:selected){
                System.out.print(i+"\t");
            }
            System.out.println();
            return;
        }
        if(data.isEmpty()){
            return;
        }
        //是第0个
        selected.add(data.get(0));
        coolections(selected, data.subList(1, data.size()), n -1);
        //不是第0个
        selected.remove(selected.size()-1);
        coolections(selected, data.subList(1, data.size()), n);

    }

}
