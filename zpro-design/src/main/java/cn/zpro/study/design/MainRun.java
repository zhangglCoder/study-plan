package cn.zpro.study.design;

public class MainRun {
    public static void main(String[] args) {
        BizService service = new BizService();
        String str = service.getMethonStr(()-> {
            System.out.println("test");
        });

        System.out.println(str);
    }
}
