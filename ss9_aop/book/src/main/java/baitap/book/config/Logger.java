package baitap.book.config;

import baitap.book.model.Count;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logger {

    private Count count;

    @Pointcut("execution(* baitap.book.controller.BookController.*(..))")
    public void allMethodPointCut(){};

    @After("allMethodPointCut()")
    public void log(JoinPoint jo){
        Count.increase();
        System.out.println("Start method Name "+ jo.getSignature().getName() +" Time: "+ LocalDateTime.now()
        + "number Person join in is "+ Count.getNum());
    }
}
