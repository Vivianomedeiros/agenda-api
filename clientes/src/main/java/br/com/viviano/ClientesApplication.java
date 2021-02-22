package br.com.viviano;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ClientesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);

    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }
}
