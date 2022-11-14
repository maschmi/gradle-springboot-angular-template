package de.maschmi.template.domain.configuration;

import de.maschmi.template.domain.example.api.query.ExampleQueryHandler;
import de.maschmi.template.domain.example.core.persistence.ExampleRepository;
import de.maschmi.template.domain.example.core.query.ExampleQueryHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfiguration {

    @Bean
    public ExampleQueryHandler exampleQueryHandler(ExampleRepository exampleRepository) {
        return new ExampleQueryHandlerImpl(exampleRepository);
    }

}
