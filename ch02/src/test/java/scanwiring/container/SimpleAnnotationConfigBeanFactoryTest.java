package scanwiring.container;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import scanwiring.component.MyComponent;
import scanwiring.component.YourComponent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimpleAnnotationConfigBeanFactoryTest {

    private static BeanFactory beanFactory;

    @BeforeAll
    public static void setup() {
        beanFactory = new SimpleAnnotationConfigBeanFactory("scanwiring.component");
    }

    @Test
    @Order(1)
    public void testScanning() {
        MyComponent myComponent = (MyComponent)beanFactory.getBean("myComponent");
        YourComponent yourComponent = (YourComponent)beanFactory.getBean("yourComponent");
        assertTrue(myComponent != null && yourComponent != null);
    }

    @Test
    @Order(2)
    public void testAutowiring() {
        MyComponent myComponent = (MyComponent)beanFactory.getBean("myComponent");
        assertNotNull(myComponent.getYourComponent());
    }

    @Disabled
    @Test
    @Order(2)
    public void test() throws ClassNotFoundException {
        Class<?> handlerClass = ClassUtils.forName("scanwiring.component", ClassUtils.getDefaultClassLoader());
        Controller controller = handlerClass.getAnnotation(Controller.class);
        assertNotNull(controller);
    }
}
