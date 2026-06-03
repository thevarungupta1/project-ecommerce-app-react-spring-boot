package com.thevarungupta.grocery_app_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI groceryApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Grocery App API")
                        .description("API documentation for Grocery App backend")
                        .version("v1")
                        .contact(new Contact().name("Grocery App Team").email("support@groceryapp.local"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                );
    }
}
