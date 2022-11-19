package baitap.cart.controller;

import baitap.cart.service.ICTOrderService;
import baitap.cart.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @Autowired
    ICTOrderService ictOrderService;

    @GetMapping()
    String getListOrder(Model model){
        model.addAttribute("orderList",orderService.findAll());
        return "order";
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        model.addAttribute("detailList",ictOrderService.listDetail(id));
        return "detailOrder";
    }
}
