package com.github.xuzw.forexroo.crm.engine.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 下午3:19:19
 */
@WebFilter("/ui/*")
public class CrmHttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        CrmSessionHolder.set(((HttpServletRequest) request).getSession());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
