package com.example.design_pattern_builder.classic;

import java.util.Objects;

final class PersonClassicBuilder {
    private final String name;
    private final Integer age;

    private PersonClassicBuilder(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static final class Builder {
        private String name;
        private Integer age;

        private Builder() {}

        public Builder name(String name) {
            this.name = Objects.requireNonNull(name, "Name cannot be null");
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public PersonClassicBuilder build() {
            return new PersonClassicBuilder(this);
        }
    }

    public static Builder builder() { return new Builder();}

    public String getName() { return name;}
    public Integer getAge() { return age;}

    public String toString() {
        return age == null ? name : name + " - " + age;
    }

}
