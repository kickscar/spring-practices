package ex02;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldApplication {
    @Bean
    public MyComponent myComponent() {
        return new MyComponent();
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext c = SpringApplication.run(HelloWorldApplication.class, args)) {
        }
    }
}