package club.mikusun.iadmin.account.shiro.advice;

import club.mikusun.iadmin.webutils.result.account.AccountResult;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@RestController
public class ExceptionAdive {

    @ExceptionHandler(value = {AuthorizationException.class})
    public Object authorizationException(HttpServletRequest req,
                                         HttpServletResponse resp,
                                         Exception e){
        return AccountResult.noPerm();
    }

    @ExceptionHandler(value = {UnauthenticatedException.class})
    public Object unauthenticatedException(HttpServletRequest req,
                                         HttpServletResponse resp,
                                         Exception e){
        return AccountResult.unauthorized();
    }

}
