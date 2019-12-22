package com.inno.mobiles.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CheckAuthentificationFilter", urlPatterns = "/edit")
public class CheckAuthentificationFilter implements Filter {
    public void init(FilterConfig filterConfig) {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getSession().getAttribute("IS_AUTHENTIFICATED") != null) {
            chain.doFilter(req, response);
        } else {
            // String requestUrl = req.getRequestURI();
            String requestUrl = (req.getQueryString() != null) ? String.join(
                    "", req.getRequestURL(), "?", req.getQueryString()) : req.getRequestURI();
            req.getSession().setAttribute("REDIRECT_URL_AFTER_SIGNIN", requestUrl);
            ((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/sign-in");
        }
    }

    public void destroy() {
    }
}
