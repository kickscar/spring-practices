package me.kickscar.spring.security.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:me/kickscar/spring/security/web/applicationContext.xml"})
@WebAppConfiguration
public class FilterChainTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private FilterChainManager filterChainManager;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context).addFilter(new DelegatingFilterProxy(filterChainManager), "/*")
                .build();
    }

    @Test
    public void testFilterEx00AndEx01() throws Throwable {
        mvc
            .perform(get("/ex01/test"))
            .andExpect(status().isNotFound())
            .andExpect(cookie().value("FilterEx00", "Works"))
            .andExpect(cookie().value("FilterEx01", "Works"));
    }

    @Test
    public void testFilterexEx00AndEx01AndEx02() throws Throwable {
        mvc
            .perform(get("/ex01/ex02/test"))
            .andExpect(status().isNotFound())
            .andExpect(cookie().value("FilterEx00", "Works"))
            .andExpect(cookie().value("FilterEx01", "Works"))
            .andExpect(cookie().value("FilterEx02", "Works"));
    }

    @Test
    public void testFilterEx00AndEx01AndEx02AndEx03() throws Throwable {
        mvc
            .perform(get("/ex01/ex02/ex03/test"))
            .andExpect(status().isNotFound())
            .andExpect(cookie().value("FilterEx00", "Works"))
            .andExpect(cookie().value("FilterEx01", "Works"))
            .andExpect(cookie().value("FilterEx02", "Works"))
            .andExpect(cookie().value("FilterEx03", "Works"));
    }
}