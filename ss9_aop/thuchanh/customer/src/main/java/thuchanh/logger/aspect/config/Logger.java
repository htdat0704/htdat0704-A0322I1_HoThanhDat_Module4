package thuchanh.logger.aspect.config;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @AfterThrowing(pointcut = "execution(* thuchanh.logger.aspect.service.customer.CustomerService.findAll(..))", throwing = "e")
    public void log(Exception e) {
        System.out.println("[CMS] co loi xay ra: " + e.getMessage());
    }
}
