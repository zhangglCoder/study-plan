package cn.zpro.clazz;

public class Man extends Persion {
    {
        System.out.println("Man 动态代码块");
    }
    static {
        System.out.println("Man 静态代码块");
    }
    public Man() {
        System.out.println("Man 构造方法");
    }
}
