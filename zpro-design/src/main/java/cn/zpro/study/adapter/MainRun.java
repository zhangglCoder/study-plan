package cn.zpro.study.adapter;

public class MainRun {
    public static void main(String[] args) {


        //普通方法只能根据ID查询SuperUser对象
        OrderUserServiceImpl orderUserService = new OrderUserServiceImpl();
        System.out.println(orderUserService.getUser("1"));


        //创建适配器
        SupperAdapter supperAdapter = new SupperAdapter();

        //调用适配器方法,让获取SuperUser可以根据名称查询
        SupperAdapterUserServiceImpl supperAdapterUserService = new SupperAdapterUserServiceImpl(supperAdapter);
        System.out.println(supperAdapterUserService.getUser("张三"));
    }
}
