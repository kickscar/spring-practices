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

import javax.servlet.Filter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:security/config01.xml", "classpath:spring-servlet.xml"})
@WebAppConfiguration
public class FilterChainProxyTest {
    @Autowired
    private WebApplicationContext context;

    // private MockMvc mvc;
    private Filter filter;

    @BeforeEach
    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();

        filter = context.getBean("springSecurityFilterChain", Filter.class);
    }

    @Test
    public void testFiterNotNull() {
        assertNotNull(filter);
    }

    @Test
    public void testDefaultSecurityFiltersSet() {
        FilterChainProxy filterChainProxy = (FilterChainProxy)filter;
        List<Filter> list =  filterChainProxy.getFilterChains().get(0).getFilters();

        assertEquals(15, list.size());

        for(Filter f : list){
            System.out.println(f.getClass().getSimpleName());
        }
    }
}

