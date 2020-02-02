package club.mikusun.iadmin.account.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自动创建SimpleToken实例
 */
public class AccountCreatTokenFilter implements Filter {


    @Override
    // 过滤器创建后调用的初始化方法
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    // 过滤器执行逻辑正文
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        request.getAttribute("account");
    }

    @Override
    // 过滤器销毁时调用的方法
    public void destroy() {

    }
}
