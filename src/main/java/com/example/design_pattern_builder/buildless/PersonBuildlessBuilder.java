package com.example.design_pattern_builder.buildless;

import java.util.*;

// все поля обязательны!!!! Если есть необязательные не сработает!!!!
final class PersonBuildlessBuilder {
    private final String name;
    private final int age;  // Теперь примитив - обязательно должен быть!

    // Приватный конструктор
    private PersonBuildlessBuilder(String name, int age) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.age = age;
    }

    // Старт fluent interface
    public static Builder name(String name) {
        return new Builder(name);
    }

    public static final class Builder {
        private final String name;
        private int age;

        private Builder(String name) {
            this.name = Objects.requireNonNull(name, "Name cannot be null");
        }

        // Этот метод ВОЗВРАЩАЕТ Person, а не Builder!
        public PersonBuildlessBuilder age(int age) {
            this.age = age;
            return new PersonBuildlessBuilder(name, age);  // Сразу создаем Person!
        }
    }

    public String getName() { return name;}
    public Integer getAge() { return age;}

    public String toString() { return name + " - " + age;}
}