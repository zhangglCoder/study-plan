package cn.zpro.base;

public class FinalTest {

    public static final String str1 = "";
    static public final String str2 = "";
    public static void main(String[] args) {
        User1 user1 = new User1();
        user1.name = "123123";
        System.out.println(user1);
    }

    protected void test3(){

    }
    protected static void test1(){

    }
    private void test2(){
    }

    private final static class User1{
        private String name;
    }
}
