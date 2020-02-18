package club.mikusun.iadmin.spring.shiro.filter;

import club.mikusun.iadmin.spring.shiro.token.OAuth2Token;
import club.mikusun.iadmin.webutils.result.account.AccountResult;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用token鉴权
 */
public class OAuth2Filter extends AuthenticatingFilter {
    /**
     * 创建token
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        String token = getRequestToken((HttpServletRequest) request);
        if(StringUtils.hasText(token)){
            return new OAuth2Token(token);
        }
        return null;
    }

    /**
     * 处理被拒绝的请求
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String token = getRequestToken((HttpServletRequest) request);
        if (!StringUtils.hasText(token)){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setContentType("application/json; charset=utf-8");
            PrintWriter writer = httpResponse.getWriter();
            writer.print(AccountResult.unauthorized().toJson());
            // 清空缓冲区
            writer.flush();
            writer.close();
            return false;
        }
        return executeLogin(request,response);
    }

    /**
     * 处理登陆失败
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json; charset=utf-8");
        try {
            // 处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            PrintWriter writer = httpResponse.getWriter();
            writer.print(AccountResult.unauthorized().setData(throwable.getMessage()).toJson());
            // 清空缓冲区
            writer.flush();
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest){
        // 从header中获取token
        String token = httpRequest.getHeader("token");
        // 如果header中不存在token，则从参数中获取token
        if(StringUtils.hasText(token)){
            token = httpRequest.getParameter("token");
        }
        return token;
    }

}
