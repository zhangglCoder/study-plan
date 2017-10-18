package cn.zpro.study.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 用户模块
 */
public class UserObserver implements Observer {

    private String name;

    @Override
    public void update(Observable o, Object arg) {
        OrderSubject orderSubject = (OrderSubject)o;
        System.out.println("客户端"+name+"收到："+orderSubject.getStatus());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
