package ex02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MyApplicationTest {
    @Autowired
    private MyComponent myComponent;

    @Test
    void testMyComponentNotNull() {
        assertNotNull(myComponent);
    }
}
