package cn.zpro.zookeeper.curator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void test1(){
        logger.info("123");
        System.out.println(22);
    }
    public static void main(String[] args) {
        new Test().test1();
    }
}
