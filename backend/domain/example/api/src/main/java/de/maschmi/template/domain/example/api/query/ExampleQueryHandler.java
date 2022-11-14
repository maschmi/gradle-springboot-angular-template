package de.maschmi.template.domain.example.api.query;

import de.maschmi.template.domain.example.api.model.Placeholder;
import reactor.core.publisher.Flux;

public interface ExampleQueryHandler {

    Flux<Placeholder> queryAll(GetAllPlaceholdersQuery query);
}
