package cn.zpro.study.singleton;


public class MainRun {


    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Singleton.getInstances().hashCode());
                }
            }.start();

        }
    }
}
