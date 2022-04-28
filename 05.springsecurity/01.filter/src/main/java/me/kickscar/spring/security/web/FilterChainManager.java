package me.kickscar.spring.security.web;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Slf4j
public class FilterChainManager implements Filter {
    private FilterConfigImpl[] filterConfigs;

    public void setFilterConfigs(FilterConfigImpl[] filterConfigs) {
        this.filterConfigs = filterConfigs;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        FilterChainImpl filterChain = createFilterChain(request);

        // Call the filter chain for this request
        if(filterChain != null) {
            filterChain.doFilter(request, response);
        }

        // Release the filter chain (if any) for this request
        if(filterChain != null) {
            filterChain.release();
        }

        // Call original filter chain
        // NOTE:
        // FilterChainManager is implemented as filter proxy for spring mvc test integrated
        // This also calls the servlet's service() method
        chain.doFilter(request, response);
    }

    private FilterChainImpl createFilterChain(ServletRequest request) {

        // Create and initialize a filter chain object
        FilterChainImpl filterChain = new FilterChainImpl();

        // Add filters that match on it's URL Pattern and Request URL
        for(FilterConfigImpl filterConfig : filterConfigs) {
            if(urlPatternMaches(filterConfig.getUrlPattern(), ((HttpServletRequest)request).getRequestURI())) {
                filterChain.addFilter(filterConfig);
            }
        }

        // Return the completed filter chain
        return filterChain;
    }

    private boolean urlPatternMaches(String pattern, String url) {
        String[] paths = pattern.split("/");
        AtomicInteger index = new AtomicInteger();

        String regExp = Arrays.asList(paths)
                .stream()
                .map(s -> {
                    boolean isEnd = index.getAndIncrement() == paths.length - 1;

                    if(s.equals("*")) {
                        return  isEnd ? ".*" :"[^/]*";
                    }

                    if(s.startsWith("*.") && isEnd) {
                        return  s.replaceAll("\\*.", ".*");
                    }

                    return s.replaceAll("\\*", "[^/]*");

                }).reduce("", (r, s) -> r + ("".equals(s) ? "" : "/" + s));

        return Pattern.matches("^" + regExp + "$", url);
    }
}
