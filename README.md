# Design Pattern: Builder Variants

A comprehensive collection of Builder pattern implementations in Java, demonstrating different approaches and trade-offs.

## 📋 Overview

This repository contains multiple implementations of the Builder pattern, each with unique characteristics and use cases.

## 🏗️ Builder Variants

### 1. Classic Builder (`PersonClassicBuilder`)
**Standard Java Builder pattern with universal entry point**

```java
PersonClassicBuilder person = PersonClassicBuilder.builder().name("John").age(25).build();
```

## Features:

✅ Universal .builder() static method

✅ Supports optional parameters

✅ Standard Java idiom

✅ Most flexible approach

### 2. Fluent Builder (PersonFluentBuilder)

**Staged builder with mandatory field initialization

```java
PersonFluentBuilder person = PersonFluentBuilder.name("John").age(25).build();
```

## Features:

✅ Fluent interface starting with mandatory fields

✅ Staged construction

✅ Clear required/optional field distinction

✅ Natural reading order

### 3. Buildless Builder (PersonBuildlessBuilder)

**Builder without terminal build() method

``` java
PersonBuildlessBuilder person = PersonBuildlessBuilder.name("John").age(25);
```

## Features:

✅ No .build() method required

✅ Direct object return

✅ All fields are mandatory

✅ Most concise syntax

📁 Project Structure

src/main/java/com/patterns/builder/
├── classic/
│   └── PersonClassicBuilder.java
├── fluent/
│   └── PersonFluentBuilder.java
├── buildless/
│   └── PersonBuildlessBuilder.java
└── Main.java

src/test/java/com/patterns/builder/
├── PersonClassicBuilderTest.java
├── PersonFluentBuilderTest.java
└── PersonBuildlessBuilderTest.java

### Use Cases

## Choose Classic Builder when:

You need maximum flexibility

Supporting optional parameters

Following standard Java conventions

Complex object construction

## Choose Fluent Builder when:

You have clear mandatory/optional field separation

Want guided construction process

Prefer natural language flow

## Choose Buildless Builder when:

All fields are required

You want the most concise syntax

Working with value objects

Performance is critical

