package ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MySiteApplication {

    @Controller
    public class HelloController {
        @GetMapping("/hello")
        public String hello() {
            return "hello";
        }
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext c = null;
        try {
            c = SpringApplication.run(MySiteApplication.class, args);
        } catch(Throwable ex) {

        } finally {
            System.out.println("clean up");

        }
    }
}
