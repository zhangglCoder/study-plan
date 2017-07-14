package cn.zpro.study.proxy.jdk;

import cn.zpro.study.proxy.House;

public class Lili implements House {

    public void buyHouse() {
        System.out.println("Lili.买房了");
    }

    public void say() {
        System.out.println("Lili.say");
    }
}
