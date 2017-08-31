//package cn.zpro.study.spring;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
///**
// *
// * @author :<a href="mailto:guolongzhang@ebnew.com">张国龙</a>
// * @date :2017-08-11 12:17:52
// */
//@Component
//public class SpringDemo  /* implements InitializingBean, DisposableBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware*/ {
//
//    private String name;
//
//    public SpringDemo() {
//        System.out.println("new SpringDemo");
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    //    @Override
////    public void afterPropertiesSet() throws Exception {
////        System.out.println("afterPropertiesSet");
////    }
////
////    @PostConstruct
////    public void init(){
////        System.out.println("init");
////    }
////
////    @Override
////    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
////        System.out.println("setApplicationContext");
////    }
////
////    @Override
////    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
////        System.out.println("setBeanFactory");
////    }
////
////    @Override
////    public void setBeanName(String s) {
////        System.out.println("setBeanName");
////    }
////
////    @Override
////    public void destroy() throws Exception {
////        System.out.println("destroy");
////    }
//
//
//    @Override
//    public String toString() {
//        return "SpringDemo{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}
