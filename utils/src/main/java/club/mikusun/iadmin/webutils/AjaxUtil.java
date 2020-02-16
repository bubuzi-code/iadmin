package club.mikusun.iadmin.webutils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class AjaxUtil {
    public static boolean isAjax(ServletRequest req) {
        if(null == req||!(req instanceof HttpServletRequest)){
            return false;
        }
        HttpServletRequest request = (HttpServletRequest) req;
        return (request.getHeader("X-Requested-With") != null &&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
