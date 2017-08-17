package cn.zpro.study.spring;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

public class UserService {

    public void init(){
        System.out.println(this.getClass().getName());
    }
}
