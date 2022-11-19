package baitap.cart.controller;

import baitap.cart.model.CTOrder;
import baitap.cart.model.Cart;
import baitap.cart.model.Order;
import baitap.cart.model.Product;
import baitap.cart.repository.ICTOrderRepository;
import baitap.cart.repository.IOrderRepository;
import baitap.cart.service.ICTOrderService;
import baitap.cart.service.IOrderService;
import baitap.cart.service.IProductService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICTOrderService ictOrderService;

    @Autowired
    private IOrderService orderService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @PostMapping("/shop")
    public String createOrder(@ModelAttribute Cart cart) {
        long idOrder = orderService.saveAndFlush(new Order(cart.countTotalPayment()));
        for (Map.Entry<Product,Integer> entry : cart.getProducts().entrySet()) {
            ictOrderService.save(new CTOrder(entry.getValue(),
                    entry.getKey().getPrice()*entry.getValue(),
                    orderService.findById(idOrder).get(),
                    entry.getKey()));
        }
        cart.payment();
        return "order";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/down/{id}")
    public String downQuantity(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.downProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.findById(id).get());
        return "view";
    }

}
