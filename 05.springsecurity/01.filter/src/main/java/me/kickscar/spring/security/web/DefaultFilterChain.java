package me.kickscar.spring.security.web;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultFilterChain implements FilterChain {
    private final List<Filter> filters = new ArrayList<>();
    private Iterator iterator = null;

    /* Not Supported */
    private Servlet servlet = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (iterator == null) {
            iterator = filters.iterator();
        }

        if (iterator.hasNext()) {
            Filter filter = (Filter)iterator.next();
            filter.doFilter(request, response, this);
            return;
        }
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public void release() {
        this.filters.clear();
        this.iterator = null;
        this.servlet = null;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}
