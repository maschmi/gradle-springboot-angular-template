package de.maschmi.template.domain.example.api.command;

import de.maschmi.template.domain.example.api.model.Placeholder;
import reactor.core.publisher.Mono;

public interface ExampleCommandHandler {

    Mono<Placeholder> addPlaceholder(AddPlaceholderCommand command);
}
