package cn.zpro.study.proxy.jdk;

import cn.zpro.study.proxy.House;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理
 */
public class Agent implements InvocationHandler {

    private House target;


    public House getInstance(House target){
        this.target = target;
        System.out.println("原始对象="+target.getClass().getName());
        House proxyObj = (House)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxyObj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象=" + proxy.getClass().getName());
        System.out.println("proxy-begin...");
        Object invokeObj = method.invoke(target, args);
        System.out.println("proxy-end...");
        return invokeObj;
    }


    public House getTarget() {
        return target;
    }

    public void setTarget(House target) {
        this.target = target;
    }
}
