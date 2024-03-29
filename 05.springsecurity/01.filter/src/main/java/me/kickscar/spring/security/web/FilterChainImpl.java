package me.kickscar.spring.security.web;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FilterChainImpl implements FilterChain {

    // The set of filters that will be executed on this chain.
    private final ArrayList filters = new ArrayList<>();

    // The iterator that is used to maintain the current position in the filter chain.
    // This iterator is called the first time that doFilter() is called.
    private Iterator iterator = null;

    // Invoke the next filter in this chain, passing the specified request and response.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (iterator == null) {
            iterator = filters.iterator();
        }

        if (iterator.hasNext()) {
            FilterConfigImpl filterConfig = (FilterConfigImpl)iterator.next();
            Filter filter = filterConfig.getFilter();

            filter.doFilter(request, response, this);

            return;
        }
    }

    // Add a filter to the set of filters that will be executed in this chain.
    public void addFilter(FilterConfigImpl filterConfig) {
        this.filters.add(filterConfig);
    }

    // Release references to the filters and wrapper executed by this chain.
    public void release() {
        filters.clear();
        iterator = null;
    }
}
