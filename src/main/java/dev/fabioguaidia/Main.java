package dev.fabioguaidia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(@RequestParam(value = "name", required = false)  String name) {
        String greetMessage = name == null || name.isBlank() ? "Hello!": "Hello " + name + "!";
        return new GreetResponse(
                greetMessage,
                List.of("java","go","rust"),
                new Person("Fabio", 30, 10_000));
    }

    record Person(
            String name,
            int age,
            double salary
    ){}

    record GreetResponse(
            String message,
            List<String> favProgrammingLanguages,
            Person person
    ){}

}
