package cn.zpro.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断数组中重复的元素
 * @author zhanggl
 */
public class Arr {

    public  static Set<String> set= new HashSet<>();
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        System.out.println(strings);
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
