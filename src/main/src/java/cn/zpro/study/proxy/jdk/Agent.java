package cn.zpro.study.proxy.jdk;

import cn.zpro.study.proxy.House;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理
 */
public class Agent implements InvocationHandler {

    House target;
    public void getInstance(House target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
