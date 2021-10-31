package ex02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class MyApplication {
    @Bean
    MyComponent myComponent() {
        return new MyComponent();
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext c = SpringApplication.run(MyApplication.class, args)) {
        }
    }
}