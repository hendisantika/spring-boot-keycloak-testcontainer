package id.my.hendisantika.keycloaktestcontainer.controller;

import id.my.hendisantika.keycloaktestcontainer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-keycloak-testcontainer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/10/24
 * Time: 13.03
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

    @GetMapping("me")
    public User getMe(JwtAuthenticationToken principal) {
        LOGGER.info("Principal attributes:: {}", principal.getTokenAttributes());

        String username = principal.getTokenAttributes().get("preferred_username").toString();
    /*String name = principal.getTokenAttributes().get("name").toString();
    String email = principal.getTokenAttributes().get("email").toString();*/
        return new User(1L, username, "", "", "");
    }

}
