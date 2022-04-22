package me.kickscar.spring.security.web;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterChainImpl implements FilterChain {

    // The set of filters that will be executed on this chain.
    private final ArrayList filters = new ArrayList<>();

    // The iterator that is used to maintain the current position in the filter chain.
    // This iterator is called the first time that doFilter() is called.
    private Iterator iterator = null;

    // The servlet instance to be executed by this chain.
    // Always null set in this example of implementation.
    private Servlet servlet;

    // Invoke the next filter in this chain, passing the specified request and response.
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

    // Add a filter to the set of filters that will be executed in this chain.
    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    // Release references to the filters and wrapper executed by this chain.
    public void release() {
        filters.clear();
        iterator = null;
        servlet = null;
    }

    // Set the servlet that will be executed at the end of this chain.
    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}
