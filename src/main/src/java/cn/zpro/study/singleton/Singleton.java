package cn.zpro.study.singleton;

public class Singleton {

    private static Singleton singleton = null;

    /**
     * 线程不安全
     * @return
     */
    public static Singleton getInstances() {
        if (singleton == null) {
            try {
                //创建对象消耗时间
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 线程安全
     * @return
     */
    public static synchronized Singleton getInstancesThreadSafe() {
        if (singleton == null) {
            try {
                //创建对象消耗时间
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 私有的构造器，不让你new
     */
    private Singleton() {

    }
}
