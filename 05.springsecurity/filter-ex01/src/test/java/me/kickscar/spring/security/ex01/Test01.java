package me.kickscar.spring.security.ex01;

import me.kickscar.spring.security.filter.MyFilter01;
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


import javax.servlet.Filter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:me/kickscar/spring/security/ex01/config01.xml"})
@WebAppConfiguration
public class Test01 {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter filter;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context).addFilter(filter, "/*")
                .build();
    }

    @Test
    public void test01() throws Throwable {
        assertNotNull(filter);
        System.out.println(filter.getClass().getSimpleName());
    }

    @Test
    public void test02() throws Throwable {
        mvc.perform(get("/")).andExpect(status().isOk());
    }
}
