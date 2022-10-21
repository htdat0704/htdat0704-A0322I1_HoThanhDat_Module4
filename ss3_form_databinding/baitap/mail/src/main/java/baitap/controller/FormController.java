package baitap.controller;

import baitap.model.FormMail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class FormController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("formMail",new FormMail());
        return "home";
    }

    @PostMapping("/save")
    public String login(@ModelAttribute("formMail") FormMail formMail, Model model){
        model.addAttribute("formMail",formMail);
        return "result";
    }

}
