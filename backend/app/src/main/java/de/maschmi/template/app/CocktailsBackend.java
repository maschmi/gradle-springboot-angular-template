package de.maschmi.template.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "de.maschmi.template.domain", "de.maschmi.template.persistence", "de.maschmi.template.app"})
public class CocktailsBackend {
    public static void main(String[] args) {
        SpringApplication.run(CocktailsBackend.class, args);
    }
}
