package cn.zpro.se;

public class Lesson2 {

    /**
     *  乘法口诀
     *  1*1=1
     *  1*2=2   2*2=4
     *  1*3=3   2*3=6
     *
     *
     *  i    j
     *  0    1
     *  1    1
     *  2    1
     *  3
     * @param args
     */
    public static void main(String[] args) {

        zgl:for (int i=1;i<=9;i++){
            for(int j=1; j<=i;j++){
                System.out.print(j+"*"+i+"="+i*j+"\t");
                continue zgl;
            }
            System.out.println();
        }
    }

}
