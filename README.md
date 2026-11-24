# decision-evaluator

Empty application framework for a Spring Boot web app.

- **Spring Boot 4.2** (Java 21, Maven)
- **H2** in-memory database with Spring Data JPA, reachable only from the backend
  (no web console, no TCP server)
- **Flyway** builds the schema from SQL files at every startup
- **htmx** UI (server-rendered Thymeleaf templates + htmx served as a WebJar)

## Run

```bash
./mvnw spring-boot:run
```

Then open http://localhost:8080

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
  application.properties              H2 / JPA / Flyway / Thymeleaf config
  db/migration/                       Flyway SQL migrations (V1__init.sql, V2__..., ...)
  templates/layout.html               Base layout (loads htmx)
  templates/index.html                Home page
  templates/fragments/                HTML fragments returned to htmx requests
  static/css/app.css
```

## Database schema

The schema is created by [Flyway](https://documentation.red-gate.com/flyway) from the SQL files in
`src/main/resources/db/migration`, applied in version order at every startup. Because H2 runs in memory,
the database is rebuilt from these scripts each time the app starts.

Add a change as a new file, e.g. `V2__create_decision_table.sql`. Don't edit a migration once it has
been committed. Hibernate runs with `ddl-auto=validate`, so the app won't start if JPA entities don't
match the schema.

