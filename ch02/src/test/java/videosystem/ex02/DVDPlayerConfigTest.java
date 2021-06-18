package videosystem.ex02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import videosystem.DigitalVideoDisc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DVDPlayerConfig.class})
public class DVDPlayerConfigTest {
    @Autowired
    @Qualifier("digitalVideoDisc1")
    private DigitalVideoDisc avangers;

    @Autowired
    @Qualifier("avengersEndgame")
    private DigitalVideoDisc avangersEndgame;

    @Test
    public void testAvangersNotNull() {
        assertNotNull(avangers);
    }

    @Test
    public void testAvengersEndgameNotNull() {
        assertNotNull(avangersEndgame);
    }
}
