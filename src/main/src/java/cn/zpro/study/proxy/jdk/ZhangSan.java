package cn.zpro.study.proxy.jdk;

import cn.zpro.study.proxy.House;

public class ZhangSan implements House {

    @Override
    public void buyHouse() {
        System.out.println("ZhangSan.买房了");
    }
}
