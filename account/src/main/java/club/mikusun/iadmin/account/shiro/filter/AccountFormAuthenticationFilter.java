package club.mikusun.iadmin.account.shiro.filter;

import club.mikusun.iadmin.webutils.AjaxUtil;
import club.mikusun.iadmin.webutils.result.account.AccountResult;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.PrintWriter;

@Log4j2
public class AccountFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }

                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
            }
            if(AjaxUtil.isAjax(request)){
                PrintWriter writer = response.getWriter();
                response.setContentType("application/json; charset=UTF-8");
                writer.print(AccountResult.unauthorized().toJson());
                writer.flush();
                writer.close();
            }else{
                // TODO: REST风格返回?
                this.saveRequestAndRedirectToLogin(request, response);
            }
            return false;
        }
    }
}
