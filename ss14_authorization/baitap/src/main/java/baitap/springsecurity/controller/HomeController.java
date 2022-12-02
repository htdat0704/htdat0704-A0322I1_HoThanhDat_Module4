package baitap.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

    @GetMapping("home")
    String getHome(){
        return "home";
    }

    @GetMapping("about")
    String getAbout(){
        return "about";
    }
}
