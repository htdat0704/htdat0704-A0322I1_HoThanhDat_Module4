package baitap.picture.exception;

import baitap.picture.model.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StringFormatException  extends Exception{
    public StringFormatException(Comment comment){
        super("Error with bad words by Name Author: "+comment.getAuthorne() + "with Feedback: " +
                ""+comment.getFeedbackne() + " time Feedback: "+ LocalDateTime.now());
    }
}
