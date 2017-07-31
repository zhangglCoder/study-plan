package cn.zpro.study.abstractfacotry;

public class DefaultFactory extends Factory {

    private BmwFactory bmwFactory = new BmwFactory();

    void getCar() {
        bmwFactory.getCar();
    }

}
