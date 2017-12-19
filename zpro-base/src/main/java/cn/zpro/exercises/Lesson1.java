package cn.zpro.exercises;

/**
 * @author zhanggl
 */
public class Lesson1 {

    /**
     * 题目：古典问题：
     * 有一对兔子，从出生后第3个月起每个月都生一对兔子，
     * 小兔子长到第三个月后每个月又生一对兔子，
     * 假如兔子都不死，问每个月的兔子对数为多少？
        程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
     * @param args
     */
    public static void main(String[] args) {
        for (int i=1;i<=10;i++){
            System.out.print(sun(i) + " ");
        }
        System.out.println();

        for (int i=1;i<=10;i++){
            System.out.print(array(i) + " ");
        }
    }

    /**
     * 递归实现 1,1,2,3,5,8,13,21....
     * @param n
     * @return
     */
    public static int sun(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return sun(n-1) + sun(n-2);
    }

    /**
     * 循环实现 1,1,2,3,5,8,13,21....
     * @param n
     * @return
     */
    public static int array(int n){
        int[] arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2; i<= n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }


}
