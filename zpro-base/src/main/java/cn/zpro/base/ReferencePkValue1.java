package cn.zpro.base;

/**
 * 值传递和引用传递
 */
public class ReferencePkValue1 {



    public static void main(String[] args) {
//        String a1 = "hello";
//        changeVal(a1);
//        System.out.println(a1);
        int i = 99;
        changeNum(i);
        System.out.println(i);
    }

    private static void changeNum(int i) {
        i++;
        System.out.println(i);
    }

    private static void changeVal(String a1) {
        a1+="world";
        System.out.println(a1);
    }
}
