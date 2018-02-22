package cn.zpro.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断数组中重复的元素
 * @author zhanggl
 */
public class Arr {

    public  static Set<String> set= new HashSet<String>();
    public static void main(String[] args) {
        boolean compare = compare(new String[]{"1", "2", "2", "3", "3"}, set);
        System.out.println(set);
    }
    public static boolean compare(String[] strs,Set set){
        boolean result = false;
        //从第一个元素开始比较元素是不是有相同的出现
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                //如果元素相同，保存到set中
                if(strs[i].equals(strs[j])){
                    set.add(strs[i]);
                    result = true;
                }
            }
        }
        return result;
    }
}
