package me.kickscar.spring.security.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterMe implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);

        Cookie cookie = new Cookie("FilterMe", "Works");
        cookie.setPath(((HttpServletRequest)request).getContextPath());
        cookie.setMaxAge(60); // 1 minute

        ((HttpServletResponse)response).addCookie(cookie);
    }
}