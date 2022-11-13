package de.maschmi.template.app.web;

import de.immernurwollen.setupguide.web.generator.PlaceholderQueryApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class PlaceholderController implements PlaceholderQueryApi {

    @Override
    public Mono<ResponseEntity<Flux<String>>> getSomething(ServerWebExchange exchange) {
       var response = List.of("one", "two");
       return Mono.fromCallable(() -> ResponseEntity
               .ok(Flux.fromIterable(response))
       );
    }
}
