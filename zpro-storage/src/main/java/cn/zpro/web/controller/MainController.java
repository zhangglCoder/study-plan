package cn.zpro.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("main")
public class MainController {

    @Autowired
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @RequestMapping("test")
    public ModelAndView test(){
        poolTaskExecutor.execute(new TaskService());
        return new ModelAndView("test");

    }
}
