package videosystem.ex04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import videosystem.DVDPlayer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:videosystem/ex04/DVDPlayerConfig.xml"})
public class DVDPlayerConfigTest {
    @Autowired
    private DVDPlayer dvdPlayer;

    @Test
    public void testDvdPlayerNotNull() {
        assertNotNull(dvdPlayer);
    }
}
