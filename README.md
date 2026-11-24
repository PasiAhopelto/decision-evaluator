# decision-evaluator

Empty application framework for a Spring Boot web app.

- **Spring Boot 4.2** (Java 21, Maven)
- **H2** in-memory database with Spring Data JPA
- **htmx** UI (server-rendered Thymeleaf templates + htmx served as a WebJar)

## Run

```bash
./mvnw spring-boot:run
```

Then open:

- App: http://localhost:8080
- H2 console: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:decisions`, user `sa`, empty password)

## Test

```bash
./mvnw test
```

## Layout

```
src/main/java/com/example/decisionevaluator
  DecisionEvaluatorApplication.java   Spring Boot entry point
  web/HomeController.java             Page + example htmx fragment endpoint
src/main/resources
  application.properties              H2 / JPA / Thymeleaf config
  templates/layout.html               Base layout (loads htmx)
  templates/index.html                Home page
  templates/fragments/                HTML fragments returned to htmx requests
  static/css/app.css
```
