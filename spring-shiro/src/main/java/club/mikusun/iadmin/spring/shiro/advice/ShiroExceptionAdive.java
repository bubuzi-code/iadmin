package club.mikusun.iadmin.spring.shiro.advice;

import club.mikusun.iadmin.webutils.result.account.AccountResult;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@RestController
public class ShiroExceptionAdive {

    /**
     * 账户不存在时抛出的异常
     * @param req
     * @param resp
     * @param e
     * @return
     */
    @ExceptionHandler(value = {UnknownAccountException.class})
    public Object unknownAccountException(HttpServletRequest req,
                                         HttpServletResponse resp,
                                         Exception e){
        return AccountResult.unknownAccount();
    }

    /**
     * 账户效验失败的异常(密码错误等)
     * @param req
     * @param resp
     * @param e
     * @return
     */
    @ExceptionHandler(value = {CredentialsException.class})
    public Object credentialsException(HttpServletRequest req,
                                          HttpServletResponse resp,
                                          Exception e){
        return AccountResult.credentialsException();
    }


    /**
     * 账户没有权限时抛出的异常
     * @param req
     * @param resp
     * @param e
     * @return
     */
    @ExceptionHandler(value = {AuthorizationException.class})
    public Object authorizationException(HttpServletRequest req,
                                         HttpServletResponse resp,
                                         Exception e){
        return AccountResult.noPerm();
    }

    /**
     * 账户为登陆抛出的异常
     * @param req
     * @param resp
     * @param e
     * @return
     */
    @ExceptionHandler(value = {UnauthenticatedException.class})
    public Object unauthenticatedException(HttpServletRequest req,
                                           HttpServletResponse resp,
                                           Exception e){
        return AccountResult.unauthorized();
    }
}
