package de.maschmi.template.domain.example.core.query;

import de.maschmi.template.domain.example.api.model.Placeholder;
import de.maschmi.template.domain.example.api.query.GetAllPlaceholdersQuery;
import de.maschmi.template.domain.example.core.persistence.ExampleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExampleQueryHandlerImplTest {

    @Test
    @DisplayName("Returns all elements retrieved from the repository")
    void queryAll() {
        var mockRepository = mock(ExampleRepository.class);
        var sut = new ExampleQueryHandlerImpl(mockRepository);

        var expectation = List.of(new Placeholder("one"), new Placeholder("two"));
        when(mockRepository.fetchAll()).thenReturn(Flux.fromIterable(expectation));

        var result = sut.queryAll(new GetAllPlaceholdersQuery()).as(Flux::toStream).toList();

        assertThat(result).isEqualTo(expectation);
    }

}