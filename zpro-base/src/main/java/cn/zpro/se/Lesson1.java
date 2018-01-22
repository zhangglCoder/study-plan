package cn.zpro.se;

public class Lesson1 {

    /**
     * 打印菱形三角形
     * 			i	j-	k*    j=i | k=((4-i)*2)+1
     *********	0	0	9
      *******	1	1	7
       *****	2	2	5
        ***		3	3	3
         *		4	4	1

     * @param args
     */
    public static void main(String[] args) {


        //上部分
        // j=4-i | k=(i*2)+1
        for (int i = 0; i< 4;i++){
            for (int j=0;j<4-i+1;j++){
                System.out.print(" ");
            }
            for (int k=0;k<(i*2)+1;k++){
                System.out.print("*");
            }
            System.out.println();
        }

        //下部分
        //j=i | k=((4-i)*2)+1
        for (int i = 0; i< 5;i++){
            for (int j=0;j<i+1;j++){
                System.out.print(" ");
            }
            for (int k=0;k<((4-i)*2)+1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
