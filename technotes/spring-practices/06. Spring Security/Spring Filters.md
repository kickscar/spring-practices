Spring Filters

## DelegatingFilterProxy

Proxy for a standard Servlet Filter, delegating to a Spring-managed bean that implements the Filter interface. 

Supports a "targetBeanName" filter init-param in web.xml, specifying the name of the target bean in the Spring application context.
web.xml will usually contain a DelegatingFilterProxy definition, with the specified filter-name corresponding to a bean name in Spring's root application context.

All calls to the filter proxy will then be delegated to that bean in the Spring context, which is required to implement the standard Servlet Filter interface.

This approach is particularly useful for Filter implementation with complex setup needs, allowing to apply the full Spring bean definition machinery to Filter instances. Alternatively, consider standard Filter setup in combination with looking up service beans from the Spring root application context.

NOTE: The lifecycle methods defined by the Servlet Filter interface will by default not be delegated to the target bean, relying on the Spring application context to manage the lifecycle of that bean. 

Specifying the "targetFilterLifecycle" filter init-param as "true" will enforce invocation of the Filter.init and Filter.destroy lifecycle methods on the target bean, letting the servlet container manage the filter lifecycle.

As of Spring 3.1, DelegatingFilterProxy has been updated to optionally accept constructor parameters when using a Servlet container's instance-based filter registration methods, usually in conjunction with Spring's org.springframework.web.WebApplicationInitializer SPI. 

These constructors allow for providing the delegate Filter bean directly, or providing the application context and bean name to fetch, avoiding the need to look up the application context from the ServletContext.

This class was originally inspired by Spring Security's FilterToBeanProxy class, written by Ben Alex.