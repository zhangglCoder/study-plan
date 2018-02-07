package cn.zpro.concurrent.exception;

/**
 * Created by dell on 2018/2/7.
 */
public class RunMain {
    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 0 ;i<10;i++){
                if(i==2){
                    throw new NullPointerException("测试多线程异常");
                }
                System.out.println(i);
            }
        }).start();


    }
}
