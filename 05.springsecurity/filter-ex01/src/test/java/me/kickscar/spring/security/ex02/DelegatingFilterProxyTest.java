package me.kickscar.spring.security.ex02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:me/kickscar/spring/security/ex02/config.xml"})
@WebAppConfiguration
public class DelegatingFilterProxyTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private FilterChainProxy filterChainProxy;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).addFilter(filterChainProxy, "/*")
//        mvc = MockMvcBuilders.webAppContextSetup(context).addFilter(new DelegatingFilterProxy("springSecurityFilterChain"), "/*")
//                .addDispatcherServletCustomizer(ds -> { ds.setDetectAllHandlerMappings(true); })
//                .dispatchOptions(true)
                .build();
    }

    @Test
    public void test() throws Throwable {
        mvc.perform(get("/"));
    }
}
