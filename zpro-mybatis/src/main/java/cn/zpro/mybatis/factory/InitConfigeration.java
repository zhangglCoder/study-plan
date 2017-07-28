package cn.zpro.mybatis.factory;


import cn.zpro.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class InitConfigeration {

    @Autowired
    private UserService userService;

    /**
     * 启动主函数
     * @param args
     */
    public static void main(String[] args) {

    }


    @Test
    public void test1(){
        System.out.println(userService.findAll());
    }
}
