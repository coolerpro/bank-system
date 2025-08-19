# Bank System

A Spring Boot application for managing banks, clients, and credit offers. It demonstrates CRUD operations, payment schedules, and a layered architecture using Thymeleaf for views.

## Prerequisites

- **Java 17**
- **Maven 3**
- **PostgreSQL**

Verify your setup:

```bash
java -version
mvn -v
psql --version
```

## Running the Application

1. Configure the database connection in `src/main/resources/application.properties`.
2. Start PostgreSQL and ensure the configured database/user exist.
3. Run the application:

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## Testing

Ensure the database is running, then execute:

```bash
mvn test
```

## Architecture Overview

The project follows a layered structure:

- **Controllers**: Handle web requests.
- **Services**: Business logic; includes credit management helpers.
- **Repositories**: Spring Data JPA repositories for persistence.
- **Entities**: JPA entities representing banks, clients, credits, and schedules.
- **Forms & Views**: Thymeleaf templates and form classes for the UI.

## Contributing

1. Fork the repository and create your branch from `main`.
2. Make your changes and ensure tests pass.
3. Submit a pull request for review.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

