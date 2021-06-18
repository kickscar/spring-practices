package videosystem.ex05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:videosystem/ex05/DVDPlayerConfig.xml"})
public class DVDPlayerConfigTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testBeanIdNotSetAutomatically() throws Exception {
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            context.getBean("avengers");
        });
    }

    @Test
    public void testGetBeanById() {
        assertNotNull(context.getBean("avengersEndgame"));
    }

    @Test
    public void testGetBeanByName() {
        assertNotNull(context.getBean("AvengersEndgame"));
    }
}