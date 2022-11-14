package de.maschmi.template.app.web;

import de.immernurwollen.setupguide.web.generator.PlaceholderQueryApi;
import de.maschmi.template.domain.example.api.model.Placeholder;
import de.maschmi.template.domain.example.api.query.ExampleQueryHandler;
import de.maschmi.template.domain.example.api.query.GetAllPlaceholdersQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class PlaceholderController implements PlaceholderQueryApi {

    private final ExampleQueryHandler exampleQueryHandler;

    public PlaceholderController(ExampleQueryHandler exampleQueryHandler) {
        this.exampleQueryHandler = exampleQueryHandler;
    }

    @Override
    public Mono<ResponseEntity<Flux<String>>> getSomething(ServerWebExchange exchange) {
        var result = exampleQueryHandler.queryAll(new GetAllPlaceholdersQuery());
        return Mono.fromSupplier(() -> ResponseEntity.ok(result.map(Placeholder::name)));
    }
}
