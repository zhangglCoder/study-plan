package cn.zpro.exercises;

/**
 * @author zhanggl
 */
public class Lesson2 {

    /**
     题目：判断101-200之间有多少个素数，并输出所有素数。
     定义：质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数。
     程序分析：
        判断素数的方法：
            1.用一个数分别去除2到sqrt(这个数)，
            2.如果能被整除，则表明此数不是素数，
            3.反之是素数。
     * @param args
     */
    public static void main(String[] args) {
        sun();
    }

    public static void sun(){

        int count = 0;
        for (int i = 101; i< 200 ;i++){
            if(isPrime(i)){
                System.out.print(i);
                System.out.print(" ");
                count++;
            }
        }
        System.out.println();
        System.out.println("从101到200共有"+count+"个质数/素数");

    }

    /**
     * 判断是否是质数
     * @param n
     * @return
     */
    public static boolean isPrime(int n){
        boolean flag = true;
        if(n==1){
            flag = false;
        }
        else{
            for( int i=2; i<= Math.sqrt(n); i++){
                if((n%i)==0 || n==1){
                    flag = false;
                    break;
                }
                else{
                    flag = true;
                }
            }
        }
        return flag;
    }



}
