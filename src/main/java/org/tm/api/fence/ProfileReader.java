/*
package org.tm.api.fence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.tm.api.fence.config.KeycloakServerProperties;

import java.io.*;
import java.util.Scanner;

@Component
public class ProfileReader implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileReader.class);

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String jdbcUser;

    @Value("${spring.datasource.password}")
    private String jdbcPassword;
    @Autowired
    private Environment springEnv;

    @Autowired
    KeycloakServerProperties serverProperties;

    //TODO - look for a proper way of handling this - temp tactical solution

    @Override
    public void run(String... args) throws Exception {
        updateConnectionDetails();
        LOG.info(" Spring profile is {} being used by keycloak", springEnv.getProperty("spring.profiles.active"));
    }

    private void updateConnectionDetails() throws IOException {
        final String PROPS_JSON = "META-INF/keycloak-server.json";
        Scanner sc = new Scanner(new File(PROPS_JSON));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        LOG.info("JSON before change :> "+fileContents);
        sc.close();
        fileContents = fileContents.replaceAll("FENCEJDBCURL",jdbcUrl);
        fileContents = fileContents.replaceAll("FENCEJDBCUSER",jdbcUser);
        fileContents = fileContents.replaceAll("FENCEJDBCPWD",jdbcPassword);
        FileWriter writer = new FileWriter(PROPS_JSON);
        LOG.info("JSON after change: "+fileContents);
        writer.append(fileContents);
        writer.flush();
    }

}
*/