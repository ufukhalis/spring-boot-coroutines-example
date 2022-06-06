# Spring Boot Webflux Coroutines

This is an example project that is basically applies Kotlin's Coroutines with the power of the usual Webflux application. 
You will realize during the inspecting the application that is very easy to apply Kotlin's Coroutines in Spring Boot Webflux application.
The most important part is applying `suspend` keyword to the methods and adding related dependencies.

The structure refers to a usual Spring application that consists below parts.

```
config
model
repository
service
controller
```

The application uses `H2` database for simplicity. There is a `schema.sql` in the resources folder that add creates needed tables when starting the application.

Most important dependencies are related to `db` and `kotlin - reactor` ones.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-r2dbc</artifactId>
</dependency>
<dependency>
    <groupId>io.r2dbc</groupId>
    <artifactId>r2dbc-h2</artifactId>
</dependency>
<dependency>
    <groupId>io.r2dbc</groupId>
    <artifactId>r2dbc-spi</artifactId>
</dependency>

<dependency>
    <groupId>org.jetbrains.kotlinx</groupId>
    <artifactId>kotlinx-coroutines-core</artifactId>
</dependency>
<dependency>
    <groupId>io.projectreactor.kotlin</groupId>
    <artifactId>reactor-kotlin-extensions</artifactId>
</dependency>
```

Commands for requesting end-points

```shell
# Create person /v1/person/
curl -XPOST -H "Content-type: application/json" -d '{
 "fullName": "ufuk halis",
  "age": 30
}' 'http://localhost:8080/v1/person/'

# List all persons /v1/person
curl -XGET -H "Content-type: application/json" 'http://localhost:8080/v1/person/'
```
