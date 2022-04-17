package videosystem.ex07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import videosystem.DVDPack;
import videosystem.DigitalVideoDisc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:videosystem/ex07/DVDPlayerConfig.xml"})
public class DVDPlayerConfigTest {
    @Autowired
    @Qualifier("avengers")
    private DigitalVideoDisc avengers;

    @Autowired
    @Qualifier("avengersInfinityWar")
    private DigitalVideoDisc avengersInfinityWar;

    @Autowired
    @Qualifier("avengersEndgame")
    private DigitalVideoDisc avengersEndgame;

    @Autowired
    @Qualifier("avengersDoublepack")
    private DVDPack avengersDoublepack;

    @Autowired
    @Qualifier("avengersTriplepack")
    private DVDPack avengersTriplepack;

    @Test
    public void testAvengersNotNull() {
        assertNotNull(avengers);
    }

    @Test
    public void testAvengersInfinityWarNotNull() {
        assertNotNull(avengersInfinityWar);
    }

    @Test
    public void testAvengersEndgameNotNull() {
        assertNotNull(avengersEndgame);
    }

    @Test
    public void testAvengersDoublepack() {
        assertEquals(2, avengersDoublepack.getDvds().size());
    }

    @Test
    public void testAvengersTriplepack() {
        assertEquals(3, avengersTriplepack.getDvds().size());
    }
}