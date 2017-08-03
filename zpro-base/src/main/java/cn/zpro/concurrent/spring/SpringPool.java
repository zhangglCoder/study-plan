package cn.zpro.concurrent.spring;


import cn.zpro.concurrent.TaskService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Spring提供的线程池
 */
public class SpringPool {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor)applicationContext.getBean("taskExecutor");
        taskExecutor.execute(new TaskService());
        taskExecutor.shutdown();
    }
}
