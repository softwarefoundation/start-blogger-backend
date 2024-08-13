package com.softwarefoundations.blogger.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().servers(this.getServers()).components(createComponents()).info(creatInfos())
                .addSecurityItem(creatSecurityRequirement());
    }

    private SecurityScheme createOAuthScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");
    }

    private Components createComponents() {
        return new Components().addSecuritySchemes("bearer-key", createOAuthScheme());
    }

    private Info creatInfos() {
        return new Info().title("Blogger").description("API's Blogger").version("v0.0.1");
    }

    private SecurityRequirement creatSecurityRequirement() {
        return new SecurityRequirement().addList("bearer-jwt", Arrays.asList("read", "write")).addList("bearer-key",
                Collections.emptyList());
    }

//    @NotNull
    private List<Server> getServers() {
        List<Server> servers = new ArrayList<>();
//        servers.add(new Server().url("/api/v1"));
        return servers;
    }
}

