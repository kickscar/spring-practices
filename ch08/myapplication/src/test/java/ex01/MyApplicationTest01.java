package ex02;

import ex01.MyApplication;
import ex01.MyComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={MyApplication.class})
public class MyApplicationTest01 {
    @Autowired
    private MyComponent myComponent;

    @Test
    void myComponentNotNull() {
        assertNotNull(myComponent);
    }
}
