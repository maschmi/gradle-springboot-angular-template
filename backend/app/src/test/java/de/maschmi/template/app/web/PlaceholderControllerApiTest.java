package de.maschmi.template.app.web;

import de.maschmi.template.app.CocktailsBackend;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CocktailsBackend.class)
@WebFluxTest
class PlaceholderControllerApiTest {

    @Autowired
    ApplicationContext context;

    private static final String BASE_URL = "/api/placeholder";
    private WebTestClient webClient;

    @BeforeEach
    void setup() {
        webClient = WebTestClient
                .bindToApplicationContext(context)
                .configureClient()
                .build();
    }

    @Test
    @DisplayName("Get something returns OK")
    void getSomething() {
        webClient.get()
                .uri(BASE_URL)
                .exchange()
                .expectStatus()
                .isOk();
    }

}