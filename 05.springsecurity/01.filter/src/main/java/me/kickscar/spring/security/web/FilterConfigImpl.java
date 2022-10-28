package me.kickscar.spring.security.web;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

public class FilterConfigImpl implements FilterConfig {
    private Filter filter;
    private String filterName;
    private String filterClass;
    private String urlPattern;

    public FilterConfigImpl(String filterName, String filterClass, String urlPattern) {
        this.filterName = filterName;
        this.filterClass = filterClass;
        this.urlPattern = urlPattern;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    @Override
    public String getFilterName() {
        return filterName;
    }

    public Filter getFilter() {
        if(filter != null) {
            return filter;
        }

        try {
            filter = (Filter)Class
                .forName(filterClass)
                .getDeclaredConstructor()
                .newInstance();

        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }

        return filter;
    }

    /* Not Supports */
    @Override
    public String getInitParameter(String name) {
        return null;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return null;
    }
}
