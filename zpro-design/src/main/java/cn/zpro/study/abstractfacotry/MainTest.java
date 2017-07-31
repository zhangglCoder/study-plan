package cn.zpro.study.abstractfacotry;

public class MainTest {

    public static void main(String[] args) {

        DefaultFactory defaultFactory = new DefaultFactory();
        defaultFactory.getCar("zt");
    }
}
