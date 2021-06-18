package videosystem.ex06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import videosystem.DVDPack;
import videosystem.DigitalVideoDisc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:videosystem/ex06/DVDPlayerConfig.xml"})
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
    @Qualifier("avengersAgeOfUltron")
    private DigitalVideoDisc avengersAgeOfUltron;

    @Autowired
    @Qualifier("captainAmerica")
    private DigitalVideoDisc captainAmerica;

    @Autowired
    @Qualifier("ironMan")
    private DigitalVideoDisc ironMan;

    @Autowired
    @Qualifier("avengersDirectorEdition")
    private DigitalVideoDisc avengersDirectorEdition;

    @Autowired
    @Qualifier("avengersExpansionPack")
    private DigitalVideoDisc avengersExpansionPack;

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
    public void testAvengersAgeOfUltronNotNull() {
        assertNotNull(avengersAgeOfUltron);
    }

    @Test
    public void testCaptainAmericaNotNull() {
        assertNotNull(captainAmerica);
    }

    @Test
    public void testIronManNotNull() {
        assertNotNull(ironMan);
    }

    @Test
    public void testAvengersDirectorEditionNotNull() {
        assertNotNull(avengersDirectorEdition);
    }

    @Test
    public void testAvengersExpansionPackNotNull() {
        assertNotNull(avengersExpansionPack);
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