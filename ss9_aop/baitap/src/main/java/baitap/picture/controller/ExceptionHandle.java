package baitap.picture.controller;

import baitap.picture.exception.StringFormatException;
import baitap.picture.model.Comment;
import baitap.picture.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ExceptionHandle {

    @Autowired
    private ICommentService service;

    @ExceptionHandler(StringFormatException.class)
    public String showErrorPage(@PageableDefault(value = 2) Pageable pageable, Model model,
                                StringFormatException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message",
                e.getMessage());
        System.out.println(e.getMessage());
        model.addAttribute("commnet",new Comment());
        model.addAttribute("commentList",service.findAll(pageable));
        return "create";}

//        @ExceptionHandler(StringFormatException.class)
//        public String showErrorPage() {return "error";}
}
