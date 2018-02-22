package cn.zpro.base;

public class Bit {




    public static void main(String[] args) {
        double a = 0.1;
        long b = 1;
    }

    /**
     * 左移 *
     */
    private static void left(){
        System.out.println(1<<4); //(2 *2 *2 *2) = 16
        System.out.println(2<<3); // = 24

        // 0000 0010       2
        //--------------
        // 0001 0000
        // 16
        //
    }

    /**
     * 右移 /
     */
    private static void right(){
        System.out.println(4>>1); // 4 / (2) = 2
        System.out.println(4>>2); // 4 / (2*2) = 1
    }

    private static class P{
        float u;
        double d;

    }
}
