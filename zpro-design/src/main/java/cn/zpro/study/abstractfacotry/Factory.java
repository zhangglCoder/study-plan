package cn.zpro.study.abstractfacotry;

public abstract class Factory {

    abstract void getCar();

    public void getCar(String name){
        if(name.equalsIgnoreCase("bmw")){
            new BmwFactory().getCar();
        }else if(name.equalsIgnoreCase("zt")){
            new ZtFactory().getCar();
        }
    }
}
