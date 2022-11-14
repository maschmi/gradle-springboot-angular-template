package de.maschmi.template.persistence.configuration;

import de.maschmi.template.domain.example.core.persistence.ExampleRepository;
import de.maschmi.template.persistence.inmem.example.ExampleRepositoryImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ExampleRepository exampleRepository() {
        return new ExampleRepositoryImpl();
    }
}
