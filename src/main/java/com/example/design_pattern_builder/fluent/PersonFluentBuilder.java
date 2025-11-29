package com.example.design_pattern_builder.fluent;

import java.util.Objects;

public final class PersonFluentBuilder {
    private final String name;
    private final Integer age;

    private PersonFluentBuilder(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static final class Builder {
        private final String name;
        private Integer age;

        private Builder(String name) {
            this.name = Objects.requireNonNull(name, "Name cannot be null");
        }

        public Builder age(Integer age) {
            this.age = age;
            return this; // возвращаем Builder для цепочки
        }

        public PersonFluentBuilder build() {
            return new PersonFluentBuilder(this); // финальное создание
        }
    }

    public static Builder name(String name) {
        return new Builder(name);
    }

    public String getName() { return name;}
    public Integer getAge() { return age;}

    public String toString() {
        return age == null ? name : name + " - " + age;
    }

}
