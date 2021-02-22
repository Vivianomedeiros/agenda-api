package br.com.viviano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class VendasApplication {
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
        System.out.println("Deus seja louvado!");
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World. \n Deus seja louvado!";
    }
}
