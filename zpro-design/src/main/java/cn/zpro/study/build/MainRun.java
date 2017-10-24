package cn.zpro.study.build;


/**
 * @author zhanggl
 */
public class MainRun {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        UserFactory userFactory = new UserFactory.UserBuild("1", "zs").setAge(12).bulid();
        System.out.println(userFactory);
    }
}
