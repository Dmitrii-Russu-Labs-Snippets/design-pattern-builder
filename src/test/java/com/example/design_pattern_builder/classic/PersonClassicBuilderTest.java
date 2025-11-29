package com.example.design_pattern_builder.classic;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonClassicBuilderTest {

    @Test
    void shouldCreatePersonWithName() {

        PersonClassicBuilder person = PersonClassicBuilder.builder().name("jack").build();

        assertNotNull(person);
        assertEquals("jack", person.getName());
        assertNull(person.getAge());
    }

    @Test
    void shouldCreatePersonWithAllProperties() {

        PersonClassicBuilder person
                = PersonClassicBuilder.builder().name("jack").age(10).build();

        assertNotNull(person);
        assertEquals("jack", person.getName());
        assertEquals(10, person.getAge());
    }

    @Test
    void shouldRejectNullName() {

        assertThatThrownBy(() -> PersonClassicBuilder.builder().name(null).build())
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Name cannot be null");
    }

    @Test
    void shouldBeImmutable() {

        PersonClassicBuilder person = PersonClassicBuilder.builder().name("John").build();

        // Не должно быть сеттеров - проверяем что объект действительно immutable
        assertThat(person.getClass().getDeclaredFields())
                .allMatch(field -> java.lang.reflect.Modifier.isFinal(field.getModifiers()));
    }

}
