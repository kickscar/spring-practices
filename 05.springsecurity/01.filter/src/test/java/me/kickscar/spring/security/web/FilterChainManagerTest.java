package me.kickscar.spring.security.web;

import me.kickscar.spring.security.web.FilterChainManager;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:me/kickscar/spring/security/web/applicationContext.xml"})
@WebAppConfiguration
public class FilterChainManagerTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private FilterChainManager filterChainManager;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context).addFilter(filterChainManager, "/*")
                .build();
    }

    @Test
    public void test() throws Throwable {
        mvc.perform(get("/me/kickscar/hello")).andExpect(status().isNotFound());
    }
}
