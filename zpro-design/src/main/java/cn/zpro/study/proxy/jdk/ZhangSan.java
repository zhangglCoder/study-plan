package cn.zpro.study.proxy.jdk;

import cn.zpro.study.proxy.House;

public class ZhangSan implements House {

    public void buyHouse() {
        System.out.println("ZhangSan.买房了");
    }

    public void say() {
        System.out.println("ZhangSan.say");
    }
}
