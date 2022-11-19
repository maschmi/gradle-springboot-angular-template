package de.maschmi.template.app.web;

import com.fasterxml.classmate.GenericType;
import de.maschmi.template.domain.example.api.model.Placeholder;
import de.maschmi.template.domain.example.api.query.ExampleQueryHandler;
import de.maschmi.template.domain.example.api.query.GetAllPlaceholdersQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaceholderControllerTest {


    @Test
    @DisplayName("Get something calls query handler")
    void getSomething(@Mock ExampleQueryHandler queryHandler) {
        var placeholderToReturn = new Placeholder("test");
        when(queryHandler.queryAll(new GetAllPlaceholdersQuery()))
                .thenReturn(Flux.fromStream(Stream.of(placeholderToReturn)));

        var sut = new PlaceholderController(queryHandler);

        var result = sut.getSomething(mock(ServerWebExchange.class))
                .block();

        StepVerifier.create(result.getBody())
                .expectNext("test")
                .verifyComplete();
    }

}