package cn.zpro.concurrent.volatiler;

/**
 * volatile 关键字的用法
 */
public class RunMain {

    //解决的是线程变量中的赋值问题
    volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    //ignore
                }
                System.out.println("线程停止了");
            }
        }).start();
        Thread.sleep(2000);
        flag = false; //没有volatile关键字是不生效的,变量之存在主线程变量副本中
        Thread.sleep(1000);
        System.out.println(flag);

    }
}
