package videosystem.ex08;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import videosystem.DVDPlayer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:videosystem/ex08/DVDPlayerConfig.xml"})
public class DVDPlayerConfigTest {

    @Autowired
    @Qualifier("dvdPlayer1")
    private DVDPlayer dvdPlayer1;

    @Autowired
    @Qualifier("dvdPlayer2")
    private DVDPlayer dvdPlayer2;

    @Autowired
    @Qualifier("dvdPlayer3")
    private DVDPlayer dvdPlayer3;

    @Test
    public void testDVDInjectedInDvdPlayers() {
        assertNotNull(dvdPlayer1.getDigitalVideoDisc());
        assertNotNull(dvdPlayer2.getDigitalVideoDisc());
        assertNotNull(dvdPlayer3.getDigitalVideoDisc());
    }
}