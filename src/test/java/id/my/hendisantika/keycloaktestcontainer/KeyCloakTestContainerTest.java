package id.my.hendisantika.keycloaktestcontainer;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import io.restassured.RestAssured;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.annotation.PostConstruct;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-keycloak-testcontainer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/10/24
 * Time: 13.04
 * To change this template use File | Settings | File Templates.
 */
@Testcontainers(disabledWithoutDocker = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KeyCloakTestContainerTest {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(KeyCloakTestContainerTest.class.getName());
    @Container
    static KeycloakContainer keycloak
//            = new KeycloakContainer("quay.io/keycloak/keycloak:26.0")
            = new KeycloakContainer()
            .withRealmImportFile("keycloak/realm-export.json");
    @LocalServerPort
    private int port;

    @DynamicPropertySource
    static void registerResourceServerIssuerProperty(DynamicPropertyRegistry registry) {
        registry.add("spring.security.oauth2.resourceserver.jwt.issuer-uri",
                () -> keycloak.getAuthServerUrl() + "realms/howtodoinjava-realm");
    }

    @PostConstruct
    public void init() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    protected String getBearerToken_v2() {
        try (Keycloak keycloakAdminClient = KeycloakBuilder.builder()
                .serverUrl(keycloak.getAuthServerUrl())
                .realm("master")
                .clientId("admin-cli")
                .username(keycloak.getAdminUsername())
                .password(keycloak.getAdminPassword())
                .build()) {

            String access_token = keycloakAdminClient.tokenManager().getAccessToken().getToken();

            return "Bearer " + access_token;
        } catch (Exception e) {
            LOGGER.error("Can't obtain an access token from Keycloak!", e);
        }
        return null;
    }
}
