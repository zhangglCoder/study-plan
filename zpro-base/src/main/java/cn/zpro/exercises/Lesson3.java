package cn.zpro.exercises;

/**
 * @author zhanggl
 */
public class Lesson3 {

    /**
     题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
     例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
     程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
     * @param args
     */
    public static void main(String[] args) {
        sun();
    }
    static int x = 0;
    public static void sun(){

        for (int i = 100;i< 999;i++){
            int b = i/100;        //取得百位数
            int s = i%100/10;     //取得十位数
            int g = i%10;        //取得个位数
            flowel(i,b,s,g);
        }
        System.out.println();
        System.out.println("水仙花数"+x+"个");
    }
    public static void flowel(int i,int b,int s,int g){

        if(i==Math.pow(b, 3) + Math.pow(s, 3) + Math.pow(g, 3)){
            x++;    //每次符合水仙花数条件，则x+1;
            System.out.print(i+" ");    //输出符合条件的数
        }

    }

}
