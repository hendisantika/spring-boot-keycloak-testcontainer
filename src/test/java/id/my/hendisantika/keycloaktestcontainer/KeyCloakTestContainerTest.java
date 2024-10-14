package id.my.hendisantika.keycloaktestcontainer;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import io.restassured.RestAssured;
import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.Test;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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

    protected String getBearerToken() {
        try {
            URI authorizationURI = new URIBuilder(keycloak.getAuthServerUrl()
                    + "realms/howtodoinjava-realm/protocol/openid-connect/token").build();
            WebClient webclient = WebClient.builder().build();
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.put("grant_type", Collections.singletonList("password"));
            formData.put("client_id", Collections.singletonList("employee-management-api"));
            formData.put("username", Collections.singletonList("test-user"));
            formData.put("password", Collections.singletonList("password"));

            String result = webclient.post()
                    .uri(authorizationURI)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            JacksonJsonParser jsonParser = new JacksonJsonParser();
            return "Bearer " + jsonParser.parseMap(result).get("access_token").toString();
        } catch (URISyntaxException e) {
            LOGGER.error("Can't obtain an access token from Keycloak!", e);
        }
        return null;
    }

    @Test
    void givenAuthenticatedUser_whenGetMe_shouldReturnMyInfo() {
        given().header("Authorization", getBearerToken())
                .when()
                .get("/users/me")
                .then()
                .body("username", equalTo("test-user"))
        /*.body("lastName", equalTo(""))
        .body("firstName", equalTo("TestUser"))
        .body("email", equalTo("test-user@howtodoinjava.com"))*/;
    }
}
