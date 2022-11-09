package baitap.product.controller;

import baitap.product.model.Product;
import baitap.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView saveCustomer(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New Product created successfully");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);

            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("product", product.get());
            return modelAndView;

    }

    @PostMapping("/edit-product")
    public ModelAndView updateCustomer(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);

            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("product", product.get());
            return modelAndView;

    }

    @PostMapping("/delete-product")
    public String deleteCustomer(@ModelAttribute("product") Product product) {
        productService.remove(product.getId());
        return "redirect:products";
    }
}
