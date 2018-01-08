package cn.zpro.base;

public class Bit {




    public static void main(String[] args) {
        right();
    }

    /**
     * 左移
     */
    private static void left(){
        System.out.println(1<<2); //1 * (2 *2) = 4
        System.out.println(2<<3); //2 * (2 *2 *2) = 16
    }
    private static void right(){
        System.out.println(4>>1); // 4 / (2) = 2
        System.out.println(4>>2); // 4 / (2*2) = 1
    }
}
