package baitap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @GetMapping("/s")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/calculator")
    public String greeting(@RequestParam String dau,@RequestParam double so1 , @RequestParam double so2,
                           Model model) {
        double result = 0;
        switch (dau){
            case "+":
                result = so1 + so2;
                break;
            case "-":
                result = so1 - so2;
                break;
            case "*":
                result = so1 * so2;
                break;
            case "/":
                result = so1 / so2;
                break;
        }
        model.addAttribute("result",result);
        return "greeting";
    }

}
