package org.snoth.xmock;

import org.snoth.xmock.configuration.EmbeddedTomcatConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by robbie on 12/02/2018.
 */
@SpringBootApplication
@Import(EmbeddedTomcatConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
