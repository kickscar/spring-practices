package videosystem.ex03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import videosystem.DVDPlayer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DVDPlayerConfig.class})
public class DVDPlayerConfigTest {
    @Autowired
    @Qualifier("dvdPlayer01")
    private DVDPlayer dvdPlayer01;

    @Autowired
    @Qualifier("dvdPlayer02")
    private DVDPlayer dvdPlayer02;

    @Autowired
    @Qualifier("dvdPlayer03")
    private DVDPlayer dvdPlayer03;

    @Autowired
    @Qualifier("dvdPlayer04")
    private DVDPlayer dvdPlayer04;

    @Test
    public void testDiscInjectedInDVDPlayers() {
        assertNotNull(dvdPlayer01.getDigitalVideoDisc());
        assertNotNull(dvdPlayer02.getDigitalVideoDisc());
        assertNotNull(dvdPlayer03.getDigitalVideoDisc());
        assertNotNull(dvdPlayer04.getDigitalVideoDisc());
    }
}
