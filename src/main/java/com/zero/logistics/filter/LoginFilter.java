package com.zero.logistics.filter;

import com.zero.logistics.constants.Constant;
import com.zero.logistics.entity.TAdmin;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginFilter
 * @Description TODO
 * @Author 郑思华
 * @Date 2020/5/22 14:35
 * @Version 1.0
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
@Component
public class LoginFilter implements Filter {

    String[] includeUrls = new String[]{"/index","/customerTable","/customerEdit","/addressTable",
            "/dotTable","/dotEdit","/staffTable","/staffEdit","/priceTable","/priceEdit","/orderTable",
            "/orderDetail","/waybillTable","/waybillDetail","/feedBackTable"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String url = request.getRequestURI();

        //放行静态资源
        if (url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".jpg")
            || url.endsWith(".gif") || url.endsWith(".png")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //判断是否需要过滤
        if (isNeedFilter(url)) {
            TAdmin admin = (TAdmin) session.getAttribute(Constant.ADMIN);
            if (admin == null) {
                String requestType = request.getHeader("X-Requested-With");
                //判断是否为ajax请求
                if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                    response.getWriter().write("您还没有登录");
                } else {
                    response.sendRedirect(request.getContextPath() + "/admin/login");
                }
            }
        }
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

    private boolean isNeedFilter(String url){
        for (String includeUrl : includeUrls) {
            if (includeUrl.equals(url))
                return true;
        }
        return false;
    }
}