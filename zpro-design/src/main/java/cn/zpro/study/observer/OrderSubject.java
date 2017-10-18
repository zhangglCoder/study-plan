package cn.zpro.study.observer;

import java.util.Observable;

public class OrderSubject extends Observable {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.setChanged();
        //采用拉模式
        this.notifyObservers();
    }
}
