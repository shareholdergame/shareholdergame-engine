package com.shareholdergame.engine.facade.runner;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Application
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Shareholdergame.com Game Server REST API",
                version = "1.0"
        ),
        servers = {
                @Server(description = "Development Environment",
                        url = "http://stockholdergame.com:8081"),
                /*@Server(description = "Development Environment",
                        url = "http://shareholdergame.com:8081"),*/
                @Server(description = "Local Environment",
                        url = "http://localhost:8081")
        }
)
@SecuritySchemes({
        @SecurityScheme(type = SecuritySchemeType.APIKEY,
                name = "bearerAuth",
                in = SecuritySchemeIn.HEADER,
                paramName = "Authorization")
})
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
