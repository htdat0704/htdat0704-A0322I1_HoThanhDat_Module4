package baitap.music.controller;

import baitap.music.model.Music;
import baitap.music.service.IServiceMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    @Autowired
    IServiceMusic musicService;

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String createMusic (@Validated @ModelAttribute("music") Music music, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        musicService.save(music);
        model.addAttribute("music", new Music());
        model.addAttribute("message", "New Music "+music.getName()+" created successfully");
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage (Model model, @PathVariable int id){
        model.addAttribute("music", musicService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateMusic (@Validated @ModelAttribute Music music,BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }
        musicService.update(music);
        redirectAttributes.addFlashAttribute("message",
                "Edit Music: " + music.getName() + " OK!");
        return "redirect:/edit/"+music.getId();
    }
}
