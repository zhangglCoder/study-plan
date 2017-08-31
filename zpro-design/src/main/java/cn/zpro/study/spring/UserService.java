package cn.zpro.study.spring;

public class UserService {

    public String name;

    public UserService() {

    }

    public StringBuilder getUserService(){
        StringBuilder userService = new StringBuilder();
        return userService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
