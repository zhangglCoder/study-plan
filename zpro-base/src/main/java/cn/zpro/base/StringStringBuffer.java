package cn.zpro.base;


/**
 * The type String string buffer.
 *
 * @author :<a href="mailto:guolongzhang@ebnew.com">张国龙</a>
 * @date :2018-01-04 09:57:17
 */
public class StringStringBuffer {
    public static void main(String[] args) {

//        StringBuffer x = new StringBuffer("A");
//        StringBuffer y = new StringBuffer("B");
//        option(x,y);
//        System.out.println(x+","+y);

        String test = "test";
        test1(test);
        System.out.println(test);

    }

    public static void option(StringBuffer x,StringBuffer y){
        x.append(y);
        y = new StringBuffer("123");
    }



    public static void test1(String a){
        a = "11";
    }


}
