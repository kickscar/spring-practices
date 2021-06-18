package videosystem.ex03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import videosystem.Avengers;
import videosystem.DVDPlayer;
import videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
    @Bean
    public DigitalVideoDisc avengers() {
        return new Avengers();
    }

    @Bean
    public DVDPlayer dvdPlayer01() {
        return new DVDPlayer(avengers());
    }

    @Bean
    public DVDPlayer dvdPlayer02(DigitalVideoDisc digitalVideoDisc) {
        return new DVDPlayer(digitalVideoDisc);
    }

    @Bean
    public DVDPlayer dvdPlayer03() {
        DVDPlayer dvdPlayer = new DVDPlayer(avengers());
        dvdPlayer.setDigitalVideoDisc(avengers());
        return dvdPlayer;
    }

    @Bean
    public DVDPlayer dvdPlayer04(DigitalVideoDisc digitalVideoDisc) {
        DVDPlayer dvdPlayer = new DVDPlayer(avengers());
        dvdPlayer.setDigitalVideoDisc(digitalVideoDisc);
        return dvdPlayer;
    }
}