package baitap.controller;

import baitap.model.Music;
import baitap.repository.MusicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/music")
public class MusicController {
    private static MusicRepository musicController = new MusicRepository();

    @GetMapping("")
    String showLish(Model model){
        model.addAttribute("list",musicController.showAll());
        return "list";
    }

    @GetMapping("/add")
    String addMusic(Model model){
        model.addAttribute("music",new Music());
        return "home";
    }

    @PostMapping("/save")
    String add(@ModelAttribute("music") Music music,Model model){
        musicController.addMusic(music);
        model.addAttribute("list",musicController.showAll());
        return "list";
    }


}
