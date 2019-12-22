package com.inno.mobiles.filter;

import com.inno.mobiles.util.RoutingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    @WebFilter("/*")
    public class ErrorHandlerFilter implements Filter {
        protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
        @Override
        public void init(FilterConfig filterConfig) {
        }

        @Override
        public void doFilter(ServletRequest req, ServletResponse resp,
                             FilterChain chain) throws IOException, ServletException {
            try {
                chain.doFilter(req, resp);
            } catch (Throwable th) {
                String requestUrl = ((HttpServletRequest) req).getRequestURI();

                LOGGER.error("Request " + requestUrl + " failed: " + th.getMessage(), th);
                Object error;
                System.out.println(
                        th.getMessage()
                );
                th.printStackTrace();
                req.setAttribute("st", "Произошла ошибка!");

                RoutingUtils.forwardToPage("error.jsp", ((HttpServletRequest) req), ((HttpServletResponse) resp));
            }
        }
        @Override
        public void destroy() {
        }
    }

