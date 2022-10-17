package baitap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bai1")
public class Convert {
    @PostMapping()
    String convertNow(@RequestParam double tiGia, @RequestParam double tien, Model model){
        model.addAttribute("result",tien*tiGia);
        return "result";
    }

    @GetMapping()
    String showForm(){
        return "greeting";
    }
}
