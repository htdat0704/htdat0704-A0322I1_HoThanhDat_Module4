package baitap.controller;

import baitap.model.Blog;
import baitap.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping()
    String getList(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "blog";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createMusic (@ModelAttribute Blog blog,
                               RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message",
                "Create Blog: " + blog.getDescription() + " OK!");
//        return "forward:/student/list";
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage (Model model, @PathVariable int id){
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMusic (@ModelAttribute Blog blog,
                               RedirectAttributes redirectAttributes){
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message",
                "Update Blog: " + blog.getAuthor() + " OK!");
//        return "forward:/student/list";
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete ( @PathVariable int id){
        blogService.delete(blogService.findById(id));
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view ( @PathVariable int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }
}
