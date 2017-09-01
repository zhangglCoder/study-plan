package cn.zpro.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("main")
@Controller
public class MainController {

    @RequestMapping("test")
    public String test(){
        return "test";
    }
}
