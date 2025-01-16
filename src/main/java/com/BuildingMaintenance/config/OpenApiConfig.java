package com.BuildingMaintenance.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "BuildingMaintenance API",
                version = "1.0",
                description = "API para gerenciamento de manutenção predial.",
                contact = @Contact(
                        name = "Shermann Barbosa Alcântara",
                        email = "shermawns@gmail.com",
                        url = "https://github.com/Shermawns/BuildingMaintenanceProject"
                )
        )
)
public class OpenApiConfig {
}
