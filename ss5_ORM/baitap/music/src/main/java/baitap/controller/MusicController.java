package baitap.controller;

import baitap.model.Music;
import baitap.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping()
    String getList(Model model){
        model.addAttribute("musicList",musicService.findAll());
        return "music";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String createMusic (@ModelAttribute Music music,
                                RedirectAttributes redirectAttributes){
        musicService.save(music);
        redirectAttributes.addFlashAttribute("message",
                "Create Music: " + music.getName() + " OK!");
//        return "forward:/student/list";
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage (Model model, @PathVariable int id){
        model.addAttribute("music", musicService.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMusic (@ModelAttribute Music music,
                                RedirectAttributes redirectAttributes){
        musicService.update(music);
        redirectAttributes.addFlashAttribute("message",
                "Create Music: " + music.getName() + " OK!");
//        return "forward:/student/list";
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String delete ( @PathVariable int id){
        musicService.delete(musicService.findById(id));
        return "redirect:/music";
    }
}
