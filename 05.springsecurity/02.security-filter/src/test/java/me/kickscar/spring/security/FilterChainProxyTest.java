package me.kickscar.spring.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.Filter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:security/config01.xml"})
@WebAppConfiguration
public class FilterChainProxyTest {
    @Autowired
    private WebApplicationContext context;

    // private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
//        mockMvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
    }

    @Test
    public void testFiterNotNull() {
        Filter filter = context.getBean("springSecurityFilterChain", Filter.class);
        assertNotNull(filter);
    }

    @Test
    public void testDefaultSecurityFiltersSet() {
        Filter filter = context.getBean("springSecurityFilterChain", Filter.class);
        FilterChainProxy filterChainProxy = (FilterChainProxy)filter;

        List<Filter> filters =  filterChainProxy.getFilterChains().get(0).getFilters();

        assertEquals(15, filters.size());

        for(Filter f : filters) {
            // GenericFilterBean filterBean = (GenericFilterBean)f;
            System.out.println(f.getClass().getSuperclass().getSimpleName());

        }
    }
}

