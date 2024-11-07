package com.pokemon.soap.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title ="Service SOAP Pokemon",
        version = "1.0",
        description = "API documentation"
)
)
public class SwaggerConfig {

}
