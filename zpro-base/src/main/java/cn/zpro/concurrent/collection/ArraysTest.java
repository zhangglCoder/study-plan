package cn.zpro.concurrent.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhanggl
 */
public class ArraysTest {

    public static void main(String[] args) {
        String[] str = new String[] { "you", "wu" };
        List list = Arrays.asList(str);
        System.out.println(list);
        str[0] = "你";
        System.out.println(list);
    }
}
