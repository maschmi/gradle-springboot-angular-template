package de.maschmi.template.domain.example.core.query;

import de.maschmi.template.domain.example.api.model.Placeholder;
import de.maschmi.template.domain.example.api.query.ExampleQueryHandler;
import de.maschmi.template.domain.example.api.query.GetAllPlaceholdersQuery;
import de.maschmi.template.domain.example.core.persistence.ExampleRepository;
import reactor.core.publisher.Flux;

public class ExampleQueryHandlerImpl implements ExampleQueryHandler  {

    private final ExampleRepository repository;

    public ExampleQueryHandlerImpl(ExampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Placeholder> queryAll(GetAllPlaceholdersQuery query) {
        return repository.fetchAll();
    }
}
