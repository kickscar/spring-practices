package ex02._01;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class HelloWorldApplication {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext c = SpringApplication.run(HelloWorldApplication.class, args)) {
        }
    }
}