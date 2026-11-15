# spring-boot-keycloak-testcontainer

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-keycloak-testcontainer/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-keycloak-testcontainer/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.x-6DB33F?logo=springboot)
![Keycloak](https://img.shields.io/badge/Keycloak-26-4D4D4D?logo=keycloak)
![Testcontainers](https://img.shields.io/badge/Testcontainers-2.x-2B9D8F)

A Spring Boot **OAuth2 Resource Server** secured by **Keycloak**, with integration tests that spin up a real
Keycloak server in Docker using [Testcontainers](https://testcontainers.com/) and
[testcontainers-keycloak](https://github.com/dasniko/testcontainers-keycloak).

## Tech Stack

| Component              | Version                                       |
|------------------------|-----------------------------------------------|
| Java                   | 25 (Temurin)                                  |
| Spring Boot            | 4.1.x (Spring Security 7)                     |
| Keycloak (test image)  | `quay.io/keycloak/keycloak:26.0`              |
| Testcontainers         | 2.x (managed by Spring Boot)                  |
| testcontainers-keycloak| 4.4.0                                         |
| RestAssured            | 6.x                                           |
| Lombok                 | managed by Spring Boot                        |
| Build tool             | Maven (wrapper included: `./mvnw`)            |

## Project Structure

```
src
├── main
│   ├── java/id/my/hendisantika/keycloaktestcontainer
│   │   ├── config/OAuth2Security.java         # SecurityFilterChain: JWT resource server, CORS, CSRF off
│   │   ├── controller/UserController.java     # GET /users/me -> info from the JWT
│   │   └── model/User.java
│   └── resources/application.properties       # issuer-uri of the Keycloak realm
└── test
    ├── java/id/my/hendisantika/keycloaktestcontainer
    │   ├── KeyCloakTestContainerTest.java                 # realm imported from realm-export.json
    │   └── KeyCloakTestContainerTestWithDefaultSetup.java # uses the default master realm
    └── resources/keycloak/realm-export.json   # realm `howtodoinjava-realm`, client & test-user
```

## How It Works

1. `@Testcontainers` + `@Container` start a `KeycloakContainer` and import `keycloak/realm-export.json`.
2. `@DynamicPropertySource` points `spring.security.oauth2.resourceserver.jwt.issuer-uri` at the container realm.
3. The test requests an access token for `test-user` (password grant on client `employee-management-api`).
4. RestAssured calls `GET /users/me` with the `Bearer` token and asserts `username == test-user`.

Security configuration (Spring Security 7 lambda DSL):

```java
http.csrf(AbstractHttpConfigurer::disable)
    .cors(Customizer.withDefaults())
    .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
    .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
    .build();
```

## Prerequisites

- **JDK 25**
- **Docker** running locally (Docker Desktop, Colima, OrbStack, Rancher Desktop, or Testcontainers Desktop).
  Tests annotated with `@Testcontainers(disabledWithoutDocker = true)` are **skipped** when Docker is not available.

## Getting Started

1. Clone this repository:
   ```shell
   git clone https://github.com/hendisantika/spring-boot-keycloak-testcontainer.git
   ```
2. Navigate to the folder:
   ```shell
   cd spring-boot-keycloak-testcontainer
   ```
3. Run the tests:
   ```shell
   ./mvnw clean verify
   ```
4. Check the console log. Expected result:
   ```shell
   [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in ...SpringBootKeycloakTestcontainerApplicationTests
   [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in ...KeyCloakTestContainerTest
   [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
   [INFO] BUILD SUCCESS
   ```

### Running the application against your own Keycloak

`application.properties` expects a Keycloak realm at:

```properties
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:7080/realms/PowerRanger
```

Start Keycloak (e.g. `docker run -p 7080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.0 start-dev`),
create the realm, then run:

```shell
./mvnw spring-boot:run
curl -H "Authorization: Bearer <access_token>" http://localhost:8080/users/me
```

## Sample Test Log

```shell
INFO  org.testcontainers.DockerClientFactory -- Connected to docker:
INFO  tc.quay.io/keycloak/keycloak:26.0 -- Creating container for image: quay.io/keycloak/keycloak:26.0
INFO  tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: ... Realm 'howtodoinjava-realm' imported
INFO  tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: ... Keycloak 26.0.0 on JVM (powered by Quarkus) started
INFO  tc.quay.io/keycloak/keycloak:26.0 -- Container quay.io/keycloak/keycloak:26.0 started
INFO  i.m.h.k.KeyCloakTestContainerTest   : Starting KeyCloakTestContainerTest using Java 25 ...
INFO  i.m.h.k.controller.UserController   : Principal attributes:: {..., preferred_username=test-user,
      azp=employee-management-api, iss=http://localhost:xxxxx/realms/howtodoinjava-realm, ...}
```

## Continuous Integration

GitHub Actions workflow [`.github/workflows/maven.yml`](.github/workflows/maven.yml) runs on every push and
pull request to `main`:

- Sets up **Temurin JDK 25** with Maven dependency caching
- Uses the Docker engine pre-installed on the `ubuntu-latest` runner for Testcontainers
- Runs `./mvnw -B -ntp verify` (unit + Keycloak integration tests)

## Dependency Updates (Dependabot)

[`.github/dependabot.yml`](.github/dependabot.yml) checks for updates **daily at 05:00 (Asia/Jakarta)**:

| Ecosystem      | Groups                                                                    | Commit prefix                     |
|----------------|---------------------------------------------------------------------------|-----------------------------------|
| Maven          | `spring`, `testcontainers`, `rest-assured`, `maven-minor-patch`           | `chore(deps)` / `chore(deps-dev)` |
| GitHub Actions | `github-actions` (all actions in one PR)                                  | `ci(deps)`                        |

Major upgrades of `spring-boot-starter-parent` are ignored because they require a manual migration.

## Author

**Hendi Santika** — [s.id/hendisantika](https://s.id/hendisantika) · Telegram [@hendisantika34](https://t.me/hendisantika34)
