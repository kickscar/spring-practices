package videosystem.ex02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import videosystem.Avengers;
import videosystem.AvengersEndgame;
import videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
    @Bean
    public DigitalVideoDisc digitalVideoDisc1() {
        return new Avengers();
    }

    @Bean(name = "avengersEndgame")
    public DigitalVideoDisc digitalVideoDisc2() {
        return new AvengersEndgame();
    }
}