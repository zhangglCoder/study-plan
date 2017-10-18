package cn.zpro.study.observer;


public class MainRun {

    public static void main(String[] args) {

        OrderSubject orderSubject = new OrderSubject();

        UserObserver userObserver = new UserObserver();
        userObserver.setName("用户中心");
        orderSubject.addObserver(userObserver);

        orderSubject.setStatus("订单完成支付");
    }
}
