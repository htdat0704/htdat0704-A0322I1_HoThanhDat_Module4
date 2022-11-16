package baitap.book.controller;

import baitap.book.exception.UnavailableQuantityBookException;
import baitap.book.model.Book;
import baitap.book.model.CTOrder;
import baitap.book.service.book.IBookService;
import baitap.book.service.ctorder.ICTOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICTOrderService ictOrderService;

    @GetMapping()
    String getList(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("bookList",bookService.findAll(pageable));
        return "list";
    }

    @GetMapping("/rental/{id}")
    public String view (@PathVariable long id, Model model){
        model.addAttribute("book",bookService.findById(id).get());
        return "rental";
    }

    @PostMapping("/rental/{id}")
    public String rental (@PathVariable long id, @RequestParam String quantityOrder
            , Model model, @RequestParam String quantityBook) throws Exception {
        int random_int = (int)Math.floor(Math.random()*(100000-10000+1)+10000);
        int quantityRental = Integer.parseInt(quantityOrder);
        int quantityOfBook = Integer.parseInt(quantityBook);
        if(quantityOfBook < quantityRental){
            throw new UnavailableQuantityBookException("So luong vuot qua");
        }
        quantityOfBook -= quantityRental;
        bookService.rentalBook(quantityOfBook,id);
        ictOrderService.save(new CTOrder(random_int,quantityRental,bookService.findById(id).get()));
        model.addAttribute("book",bookService.findById(id).get());
        model.addAttribute("message", "Rental "+ quantityOrder +" book with number "
                +ictOrderService.findById(random_int).get().getId()+" OK!");
        return "rental";
    }

    @GetMapping("/return")
    String getReturn(Model model){
        model.addAttribute("ctorders",ictOrderService.findAll());
        return "return";
    }

    @PostMapping("/return")
    String bookReturn(@RequestParam String ctorder, Model model, RedirectAttributes redirectAttributes){
        CTOrder ctOrder = ictOrderService.findById(Long.parseLong(ctorder)).get();
        Book book = bookService.findById(ctOrder.getBook().getId()).get();
        int newQuantity = ctOrder.getQuantity() + book.getQuantity();
        bookService.rentalBook(newQuantity,book.getId());
        ictOrderService.delete(ctOrder);
        model.addAttribute("ctorders",ictOrderService.findAll());
        redirectAttributes.addFlashAttribute("message",
                "Return book "+book.getName()+" Success!");
        return "redirect:/book";
    }
}
