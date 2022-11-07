package baitap.controller;

import baitap.model.Blog;
import baitap.model.Category;
import baitap.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    String getList(@PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("categories",categoryService.findAll(pageable));
        return "category/list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String createMusic (@ModelAttribute Category category,
                               RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message",
                "Create Category: " + category.getName() + " OK!");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage (Model model, @PathVariable int id){
        model.addAttribute("category", categoryService.findById(id).get());
        return "category/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMusic (@ModelAttribute Category category,
                               RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message",
                "Update Category: " + category.getName() + " OK!");
//        return "forward:/student/list";
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete ( @PathVariable int id){
        categoryService.delete(categoryService.findById(id).get());
        return "redirect:/category";
    }

}
