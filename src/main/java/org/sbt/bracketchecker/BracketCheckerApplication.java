package org.sbt.bracketchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Bracket Checker project Docs",
                version = "1.0",
                description = "This is the official documentation of the Bracket Checker API developed by Saparin Alexander",
                contact = @Contact(
                        name = "Saparin Alexander",
                        email = "johntom@yandex.ru"
                )
        )
)
public class BracketCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BracketCheckerApplication.class, args);
    }
}
