package cn.zpro.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * JDK8 操作集合的流方式处理
 * @author zhanggl
 */
public class StreamDemo {

    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
        List<String> strings = Arrays.asList("1", "2", "3");
        List<String> collect = strings.stream().filter(
                Predicate.isEqual("1")
        ).collect(Collectors.toList());
        System.out.println(collect);

    }
}
