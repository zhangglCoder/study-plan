package cn.zpro.base;

/**
 * 常量池
 * 运行时常量池相对于CLass文件常量池的另外一个重要特征是具备动态性，Java语言并不要求常量一定只有编译期才能产生，
 * 也就是并非预置入CLass文件中常量池的内容才能进入方法区运行时常量池，运行期间也可能将新的常量放入池中，
 * 这种特性被开发人员利用比较多的就是String类的intern()方法。
 String的intern()方法会查找在常量池中是否存在一份equal相等的字符串,如果有则返回该字符串的引用,如果没有则添加自己的字符串进入常量池。
 * @author zhanggl
 */
public class ConstantPool {
    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        String s4 = "计算机";
        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s3 == s2? " + (s3 == s2));
        System.out.println("s3 == s4? " + (s3 == s4));
    }
    public static void test2(){
        String s1 = new String("计算机");
        String s2 = "计算机";
        String s3 = new String("计算机");

        System.out.println(s1.equals(s2));

        //false s1 是引用类型的内存地址， s2 是常量池中的值
        System.out.println(s1==s2);

        //s1 是 是引用类型的内存地址 存放在堆中,s2 又开辟了一块  2个对象的比较的是内存地址 显然寻址不一样
        System.out.println(s1==s3);

        //因为equals 比较的是值
        System.out.println(s1.equals(s3));
    }

    public static void test3(){
        Integer obj1 = -129;
        Integer obj2 = -129;
        System.out.println(obj1.equals(obj2));

        int i1 = 129;
        int i2 = 129;
        System.out.println(i1 == i2);
    }
}
