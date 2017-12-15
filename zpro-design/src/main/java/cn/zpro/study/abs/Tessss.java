package cn.zpro.study.abs;

public class Tessss {
    private UserService userService;

    public Tessss(UserService userService) {
        this.userService = userService;
    }

    public String getUser(String name){
        return userService.findUser(name);
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public static void main(String[] args) {
        Tessss tessss = new Tessss((x)-> x +"\\我是实现类" );

        System.out.println(tessss.getUser("我是参数"));

    }
}
