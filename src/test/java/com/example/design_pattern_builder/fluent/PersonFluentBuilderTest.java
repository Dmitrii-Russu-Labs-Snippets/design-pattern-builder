package com.example.design_pattern_builder.fluent;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonFluentBuilderTest {

    @Test
    void shouldCreatePersonWithName() {

        PersonFluentBuilder person = PersonFluentBuilder.name("jack").build();

        assertNotNull(person);
        assertEquals("jack", person.getName());
        assertNull(person.getAge());
    }

    @Test
    void shouldCreatePersonWithAllProperties() {

        PersonFluentBuilder person
                = PersonFluentBuilder.name("jack").age(10).build();

        assertNotNull(person);
        assertEquals("jack", person.getName());
        assertEquals(10, person.getAge());
    }

    @Test
    void shouldRejectNullName() {

        assertThatThrownBy(() -> PersonFluentBuilder.name(null).build())
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Name cannot be null");
    }

    @Test
    void shouldBeImmutable() {

        PersonFluentBuilder person = PersonFluentBuilder.name("John").build();

        // Не должно быть сеттеров - проверяем что объект действительно immutable
        assertThat(person.getClass().getDeclaredFields())
                .allMatch(field -> java.lang.reflect.Modifier.isFinal(field.getModifiers()));
    }

}

