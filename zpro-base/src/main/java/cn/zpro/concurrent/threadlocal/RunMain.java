package cn.zpro.concurrent.threadlocal;

/**
 * @author dell
 */
public class RunMain {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        new Thread(() -> {
            threadLocal.set("v1");
            System.out.println(Thread.currentThread().getName()+"-->1-->"+threadLocal.get());
        }).start();

        new Thread(() -> {
            threadLocal.set("v2");
            System.out.println(Thread.currentThread().getName()+"-->2-->"+threadLocal.get());
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"-->3-->"+threadLocal.get());
        }).start();
    }
}
