package baitap.picture.controller;

import baitap.picture.exception.StringFormatException;
import baitap.picture.model.Comment;
import baitap.picture.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("nasa")
public class CommentController {

    @Autowired
    private ICommentService service;

    @GetMapping()
    String getPage(@PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("commnet",new Comment());
        model.addAttribute("commentList",service.findAll(pageable));
        return "create";
    }

    @PostMapping()
    String addComment(@ModelAttribute Comment comment) throws StringFormatException {
        if(comment.getFeedbackne().contains("no") || comment.getFeedbackne().contains("yes")){
            throw new StringFormatException(comment);
        }
        service.save(comment);
        return "redirect:/nasa";
    }

}
