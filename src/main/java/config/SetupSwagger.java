package config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SetupSwagger {

    @Bean
    public GroupedOpenApi springSwagger() {
        return GroupedOpenApi.builder()
                .group("spring")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Spring swagger")
                        .description("starter pack")
                        .version("0.0.1"));
    }
}