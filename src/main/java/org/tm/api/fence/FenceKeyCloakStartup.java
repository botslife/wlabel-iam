package org.tm.api.fence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import org.tm.api.fence.config.KeycloakServerProperties;


//  TODO find ways to parametrise KeycloakServerProperties to pickup db and other changes based on environment
@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
@EnableConfigurationProperties(KeycloakServerProperties.class)
public class FenceKeyCloakStartup {

    private static final Logger LOG = LoggerFactory.getLogger(FenceKeyCloakStartup.class);

    public static void main(String[] args) {
        SpringApplication.run(FenceKeyCloakStartup.class, args);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(ServerProperties serverProperties, KeycloakServerProperties keycloakServerProperties) {

        return (evt) -> {

            Integer port = serverProperties.getPort();
            String keycloakContextPath = keycloakServerProperties.getContextPath();

            LOG.info("Fence (Keycloak) started: http://localhost:{}{} to use keycloak", port, keycloakContextPath);
        };
    }

}
