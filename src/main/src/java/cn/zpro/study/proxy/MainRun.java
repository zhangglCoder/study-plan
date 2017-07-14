package cn.zpro.study.proxy;

import cn.zpro.study.proxy.jdk.Agent;
import cn.zpro.study.proxy.jdk.ZhangSan;

public class MainRun {

    public static void main(String[] args) {

        Agent agent = new Agent();
        House agentInstance = agent.getInstance(new ZhangSan());

        System.out.println("动态代理对象=" + agentInstance.getClass().getName());
        agentInstance.buyHouse();

    }
}
