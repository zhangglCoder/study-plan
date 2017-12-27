package cn.zpro.exercises;


/**
 * @author zhanggl
 */
public class Lesson4 {

    /**
     题目：递归实现反转字符串

     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reverse2("123456789"));
    }

    /**
     * 递归实现
     * @param str
     */
    public static String reverse(String str){
        if(str==null || str.length() <=1){
            return str;
        }
        String sun = reverse(str.substring(1));
        char at = str.charAt(0);
        return  sun + at ;
    }

    /**
     * 循环实现
     * @param str
     * @return
     */
    public static String reverse2(String str){
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];
        for(int i=0;i<chars.length;i++){
            result[i] =chars[chars.length-i-1];
        }
        return new String(result);
    }


}
