package baitap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/calculator")
public class Search {
    @GetMapping()
    public String searchPage(){
        return "greeting";
    }

    @GetMapping("/name")
    public String search(Model model, @RequestParam String search){
        String result = null;
        Map<String,String> map = new LinkedHashMap<>();
        map.put("search", "tim kiem");
        map.put("fly", "bay");
        map.put("be likely to", "co kha nang");
        map.put("housemaid", "noi tro");
        map.put("tighten", "ganchat");
        map.put("code", "ma");
        result = map.get(search);
        model.addAttribute("result",result);
        return "greeting";
    }
}
