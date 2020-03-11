package club.mikusun.iadmin.provide.post.advice;

import club.mikusun.iadmin.db.data.BadRequestException;
import club.mikusun.iadmin.webutils.result.account.AccountResult;
import club.mikusun.iadmin.webutils.result.account.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@RestController
public class WebHttpExceptionAdvie {

    @ExceptionHandler(value = {BadRequestException.class})
    public Object unknownAccountException(HttpServletRequest req,
                                          HttpServletResponse resp,
                                          Exception e){
        return HttpResult.badRequest( e.getMessage() );
    }
}
