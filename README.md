# Car Sale Backend

A simple Spring Boot backend for a car sales application. This repository provides REST endpoints for authentication and car management, JWT-based security, and a small data model (User, Role, Car). It uses Maven (wrapper included) and is ready to build and run locally or inside CI.

## Features

- Authentication: register and login (JWT issued)
- Car CRUD: save, list, get by id
- Global exception handling and JWT filter

## Tech Stack

- Java (target: Latest LTS recommended)
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- Maven (wrapper included)

## Detected API Endpoints

- `POST /api/v1/auth/register` — register a new user
- `POST /api/v1/auth/login` — authenticate and receive JWT
- `POST /api/v1/cars/save` — create/save a car
- `GET  /api/v1/cars` — list all cars
- `GET  /api/v1/cars/{id}` — get car by id

(Endpoints discovered from `controller` package.)

## Prerequisites

- JDK: Install the latest LTS Java (recommended: Java 21 or later LTS). Ensure `JAVA_HOME` is set.
- Maven: The project includes the Maven wrapper (`mvnw`), so you do not need Maven installed system-wide.

Check your Java version (example):

```bash
java -version
```

If you need to use a specific JDK (e.g., Java 21), set `JAVA_HOME` and your PATH accordingly before building.

## Build

Build using the included Maven wrapper:

```bash
./mvnw clean package -DskipTests
```

Or compile and run from the wrapper:

```bash
./mvnw -DskipTests spring-boot:run
```

## Run (jar)

After packaging, run the application:

```bash
java -jar target/car.sale-0.0.1-SNAPSHOT.jar
```

## Tests

Run the full test suite with:

```bash
./mvnw test
```

## Configuration

Application settings live in `src/main/resources/application.properties`.
Add or override properties via environment variables or a separate `application-*.properties` profile.

Common properties to set in production:

- `spring.datasource.*` — JDBC URL, username, password
- `jwt.secret` (or the name used in the code) — JWT signing key

Example environment variables (macOS / Linux):

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/car_sale
export SPRING_DATASOURCE_USERNAME=app
export SPRING_DATASOURCE_PASSWORD=secret
export JWT_SECRET=change_this_secret
```

## Docker (optional)

If you want to containerize the app, create a `Dockerfile` similar to:

```Dockerfile
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY target/car.sale-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
```

Build and run:

```bash
./mvnw clean package -DskipTests
docker build -t car-sale-backend:latest .
docker run -e SPRING_DATASOURCE_URL=... -p 8080:8080 car-sale-backend:latest
```

## Upgrade Java Runtime (how-to)

To upgrade the runtime to the latest LTS Java:

1. Install the desired JDK on your machine (e.g., Java 21 LTS).
2. Set `JAVA_HOME` and ensure `java -version` shows the new version.
3. Update your CI or Docker base image to use that JDK.
4. Rebuild the project with the wrapper: `./mvnw clean package`.

If you want, I can perform an automated upgrade analysis and changes (compiler plugin, maven wrapper update, source compatibility changes) and run tests.

## Development Notes

- Main application class: `src/main/java/com/example/car/sale/Application.java`
- Controllers: `src/main/java/com/example/car/sale/controller/`
- Services: `src/main/java/com/example/car/sale/service/`
- Repositories: `src/main/java/com/example/car/sale/repository/`

## Contributing

1. Fork the repository
2. Create a branch: `git checkout -b feature/your-feature`
3. Commit changes and push
4. Open a pull request

## Publish to GitHub (quick guide)

```bash
git init
git add .
git commit -m "Initial project import with README"
git branch -M main
git remote add origin <your-github-repo-URL>
git push -u origin main
```

If you'd like, I can prepare the commit and push it to GitHub for you (I can also run the checks and update the Maven wrapper if required).

## License

Add a license file if you intend to open-source this repository (e.g., `LICENSE` with MIT or Apache-2.0).

---

If you'd like the README in Sinhala or want me to also update `pom.xml` to target a specific Java LTS and run the build/tests, tell me which Java LTS you want (e.g., Java 21) and I'll proceed.

