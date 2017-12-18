package cn.zpro.study.abs;

public class DeptIndexControoler extends AbsIndexController {

    @Override
    public String getStr() {
        return "DeptIndexControoler";
    }

    public static void main(String[] args) {
        new DeptIndexControoler().test();
    }
}
