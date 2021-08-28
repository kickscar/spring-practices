package ex02._02;

import ex02._01.MyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// @ExtendWith(SpringExtension.class)
// @ContextConfiguration
@SpringBootTest
public class HelloWorldApplicationTest {
    @Autowired
    private MyComponent myComponent;

    @Test
    void testMyComponentNotNull() {
        assertNotNull(myComponent);
    }
}
