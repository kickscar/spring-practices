package ex02;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldApplication {
    @Bean
    ApplicationRunner applicationRunner() {
        return (ApplicationArguments args) -> {
            System.out.println("Hello World");
        };
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext c = SpringApplication.run(ex02._01.HelloWorldApplication.class, args)) {
        }
    }
}