package me.kickscar.spring.security.web;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Slf4j
public class FilterChainManager implements Filter {
    private Map<String, Filter> filterUrlPatternMap = new HashMap<String, Filter>();
    private DefaultFilterChain filterChain = new DefaultFilterChain();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1. setup filter chain
        for(String urlPattern : filterUrlPatternMap.keySet()) {
            if(urlPatternMaches(urlPattern, ((HttpServletRequest)request).getRequestURI())) {
                filterChain.addFilter(filterUrlPatternMap.get(urlPattern));
            }
        }

        // 2. invoke filter chain
        filterChain.doFilter(request, response);

        // 3. release filter chain
        filterChain.release();

        // 4. invoke original filter chain
        chain.doFilter(request, response);
    }

    public void setFilterUrlPatternMap(Map filterUrlPatternMap) {
        this.filterUrlPatternMap = filterUrlPatternMap;
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
