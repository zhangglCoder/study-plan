package cn.zpro.freamwork;

import cn.zpro.jdk8.stream.User;

import java.util.Objects;

/**
 * 判断对象
 * @author zhanggl
 */
public class ObjectTest {
    public static void main(String[] args) {
        User user1 = null;
        User user2 = new User();
        user2.setId(3);

        System.out.println(Objects.equals(user1,user2));
    }
}
