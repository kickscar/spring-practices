package ex05;

import ex05.component.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {
    @Bean
    ApplicationRunner applicationRunner() {
        return new ApplicationRunner () {
            @Autowired
            private MyComponent myComponent;

            @Override
            public void run(ApplicationArguments args) throws Exception {
                myComponent.printHello();
            }
        };
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext c = SpringApplication.run(MyApplication.class, args)) {
        }
    }
}