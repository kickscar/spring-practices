package me.kickscar.spring.security.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FilterChainManager implements Filter {
    private Map<String, Filter> filterUrlPatternMap = new HashMap<String, Filter>();
    private DefaultFilterChain filterChain = new DefaultFilterChain();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        AntPathMatcher pathMatcher = new AntPathMatcher();

        for(String urlPattern : filterUrlPatternMap.keySet()) {
            // 요청 URL과 매치되는 필터들을 filter chain에 등록
            if(pathMatcher.match(urlPattern, httpServletRequest.getRequestURI())) {
                log.debug("-----" + urlPattern + "--------" + httpServletRequest.getRequestURI() + "-----");
                filterChain.addFilter(filterUrlPatternMap.get(urlPattern));
            }
        }

        // filter chain 실행
        filterChain.doFilter(request, response);

        // filter chain 초기화
        filterChain.release();

        // original chain 실행
        // FilterChainManager는 Proxy Filter 로 구현되었다.
        // 1. 테스트를 위해서
        // 2. Spring Security의 FilterChainProxy의 기본적인 작동 원리 흉내
        chain.doFilter(request, response);
    }

    public void setFilterUrlPatternMap(Map filterUrlPatternMap) {
        this.filterUrlPatternMap = filterUrlPatternMap;
    }
}
