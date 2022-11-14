package de.maschmi.template.domain.example.core.persistence;

import de.maschmi.template.domain.example.api.model.Placeholder;
import reactor.core.publisher.Flux;

public interface ExampleRepository {

    Flux<Placeholder> fetchAll();
}
