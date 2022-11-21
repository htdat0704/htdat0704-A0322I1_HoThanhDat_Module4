package baitap.blog.controller;


import baitap.blog.model.Blog;
import baitap.blog.service.IBlogService;
import baitap.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    String getList(@PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("blogList",blogService.findAll(pageable));
        return "blog";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories",categoryService.findAll());
        return "create";
    }

    @GetMapping("/create/s")
    public String createMusic (@ModelAttribute Blog blog,
                               RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message",
                "Create Blog: " + blog.getDescription() + " OK!");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage (Model model, @PathVariable int id){
        model.addAttribute("blog", blogService.findById(id).get());
        model.addAttribute("categories",categoryService.findAll());
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMusic (@ModelAttribute Blog blog,
                               RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message",
                "Update Blog: " + blog.getAuthor() + " OK!");
//        return "forward:/student/list";
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete ( @PathVariable int id){
        blogService.delete(blogService.findById(id).get());
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view (@PathVariable int id, Model model){
        model.addAttribute("blog",blogService.findById(id).get());
        return "detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam String kq, Model model){
        model.addAttribute("blogList",blogService.findByAuthor(kq));
        return "blog";
    }
}
