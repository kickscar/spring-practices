package ex02._02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class HelloWorldApplication {
    @Bean
    MyComponent myComponent() {
        return new MyComponent();
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext c = SpringApplication.run(HelloWorldApplication.class, args)) {
        }
    }
}