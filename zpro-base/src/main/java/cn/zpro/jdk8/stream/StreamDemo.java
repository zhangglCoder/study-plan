package cn.zpro.jdk8.stream;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * JDK8 操作集合的流方式处理
 * @author zhanggl
 */
public class StreamDemo {

    public static void main(String[] args) {
        test2();
    }

    private static void test1(){
        List<String> strings = Arrays.asList("1", "2", "3");
        List<String> collect = strings.stream().filter(
                Predicate.isEqual("1")
        ).collect(Collectors.toList());
        System.out.println(collect);

    }

    private static void test2(){
        List<User> userList = Arrays.asList(
                new User(1, "张三", new Date(),1),
                new User(2, "李四", new Date(),1),
                new User(3, "王五", new Date(),1));
        List<User> collect = userList.stream().
                        //过滤条件
                        filter(e -> {
                    boolean equals = e.getId().equals(e.getPid());
                    e.setName("我改过了");
                    return equals;
                }).collect(Collectors.toList());
        System.out.println(collect);
    }


}
