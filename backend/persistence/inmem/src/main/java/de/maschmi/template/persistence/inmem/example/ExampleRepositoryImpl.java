package de.maschmi.template.persistence.inmem.example;

import de.maschmi.template.domain.example.api.model.Placeholder;
import de.maschmi.template.domain.example.core.persistence.ExampleRepository;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class ExampleRepositoryImpl implements ExampleRepository {

    private final List<Placeholder> store = new ArrayList<>();

    @PostConstruct
    void dataSeeding() {
        store.add(new Placeholder("one"));
        store.add(new Placeholder("two"));
    }

    @Override
    public Flux<Placeholder> fetchAll() {
        return Flux.fromIterable(store);
    }
}
