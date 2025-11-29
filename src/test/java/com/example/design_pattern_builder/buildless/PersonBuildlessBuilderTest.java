package com.example.design_pattern_builder.buildless;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonBuildlessBuilderTest {

    @Test
    void shouldCreatePersonWithName() {

        PersonBuildlessBuilder person = PersonBuildlessBuilder.name("jack").age(10);

        assertNotNull(person);
        assertEquals("jack", person.getName());
        assertEquals(10, person.getAge());
    }

    @Test
    void shouldCreatePersonWithAllProperties() {

        PersonBuildlessBuilder person = PersonBuildlessBuilder.name("jack").age(10);

        assertNotNull(person);
        assertEquals("jack", person.getName());
        assertEquals(10, person.getAge());
    }

    @Test
    void shouldRejectNullName() {

        assertThatThrownBy(() -> PersonBuildlessBuilder.name(null).age(10))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Name cannot be null");
    }

    @Test
    void shouldBeImmutable() {

        PersonBuildlessBuilder person = PersonBuildlessBuilder.name("John").age(10);

        // Не должно быть сеттеров - проверяем что объект действительно immutable
        assertThat(person.getClass().getDeclaredFields())
                .allMatch(field -> java.lang.reflect.Modifier.isFinal(field.getModifiers()));
    }

}


