package cn.zpro.clazz;


public class Persion {
    public static int parentStaticMethod() {
        System.out.println("Persion 的静态成员变量");
        return 10;
    }
    public int parentMethod()
    {
        System.out.println("Persion 的成员变量");
        return 10;
    }

    {
        System.out.println("Persion 动态代码块");
    }
    static {
        System.out.println("Persion 静态代码块");
    }
    public Persion() {
        System.out.println("Persion 构造方法");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Persion 销毁");
    }
}
