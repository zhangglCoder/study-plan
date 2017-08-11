package cn.zpro.concurrent.jdk;


public class Tsre {
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            System.out.println(i);
            test();
        }
    }
    public static void test(){
        System.out.println(1);
    }
}
