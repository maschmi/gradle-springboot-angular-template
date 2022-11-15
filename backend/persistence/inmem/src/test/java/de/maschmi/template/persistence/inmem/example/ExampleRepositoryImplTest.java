package de.maschmi.template.persistence.inmem.example;

import de.maschmi.template.domain.example.api.model.Placeholder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//we need this as we do not have any application context in the package, but we still only want to test this single implementation
@ContextConfiguration(classes = {ExampleRepositoryImplAppTest.class})
class ExampleRepositoryImplAppTest {

    // we need this as we use @PostConstruct and this only happens when spring creates the class as Bean
    @Bean
    public ExampleRepositoryImpl exampleRepository() {
        return new ExampleRepositoryImpl();
    }

    @Test
    @DisplayName("Is initialized with example values")
    void initialized(@Autowired ExampleRepositoryImpl sut) {

        var expectation = List.of(new Placeholder("one"), new Placeholder("two"));

        var result = sut.fetchAll().toStream().toList();

        assertThat(result).isEqualTo(expectation);
    }




}