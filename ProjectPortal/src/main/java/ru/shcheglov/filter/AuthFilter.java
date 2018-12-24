package ru.shcheglov.filter;

import org.jetbrains.annotations.Nullable;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@WebFilter(urlPatterns = {"/admin/*", "/profile/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (isAuth(request)) filterChain.doFilter(request, response);
        else response.sendRedirect("/login");
    }

    private boolean isAuth(@Nullable final HttpServletRequest request) {
        if (request == null) return false;
        final HttpSession session = request.getSession();
        
        return true;
    }

    @Override
    public void destroy() {

    }

}
