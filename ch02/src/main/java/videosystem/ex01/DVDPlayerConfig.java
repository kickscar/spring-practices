package videosystem.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import videosystem.DVDPlayer;

@Configuration
public class DVDPlayerConfig {
    @Bean
    public DVDPlayer dvdPlayer() {
        return new DVDPlayer();
    }
}