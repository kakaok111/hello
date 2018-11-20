package com.g.web.filter;

import com.g.beans.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrq = (HttpServletRequest)request;
        HttpServletResponse hrp = (HttpServletResponse)response;
        User user = (User) hrq.getSession().getAttribute("user");
        if (user == null ){
            request.setAttribute("msg","你还未登录，无法访问，请登陆!");
            request.getRequestDispatcher("/login.jsp").forward(hrq,hrp);
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
