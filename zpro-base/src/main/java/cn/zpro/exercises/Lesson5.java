package cn.zpro.exercises;


/**
 * @author zhanggl
 */
public class Lesson5 {

    public static void main(String[] args) {
        String say = "1234567";
        System.out.println(reverse(say));
    }

    /**
     * 时间复杂度 O(n)
     * @param str
     * @return
     */
    private static String reverse(String str) {
        String[] strings = str.split("");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i<strings.length;i++){
            buffer.append(strings[strings.length-1-i]);
        }
        return buffer.toString();
    }


}
