package cn.zpro.concurrent.bank;

/**
 银行有一个账户，有2个储户分别向同一账户存3000元钱，每次存1000，存3次
 打印每次存完的账户余额
 * @author dell
 */
public class RunMain {

    public volatile static Integer account = 0;
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (RunMain.class){
                    for (int i =0;i<3;i++){
                        account += 1000;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+":余额:"+account);
                    }
                }

            }
        });
        t1.setName("张三");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (RunMain.class){
                    for (int i =0;i<3;i++){
                        account += 1000;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+":余额:"+account);
                    }
                }
            }
        });
        t2.setName("李四");
        t2.start();


    }

}
