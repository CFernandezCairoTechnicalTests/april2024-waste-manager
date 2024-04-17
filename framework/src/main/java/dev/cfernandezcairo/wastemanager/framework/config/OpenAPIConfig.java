package dev.cfernandezcairo.wastemanager.framework.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${cfernandezcairo.openapi.dev-url}")
    private String devUrl;

    @Value("${cfernandezcairo.openapi.default-url}")
    private String defaultUurl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server defaultServer = new Server();
        defaultServer.setUrl(defaultUurl);
        defaultServer.setDescription("Server Default URL environment");

        Contact contact = new Contact();
        contact.setEmail("cfernandezcairo@gmail.com");
        contact.setName("Carlos Alberto Fernandez Cairo");
        contact.setUrl("https://github.com/cfernandezcairo");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Waste Manager API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage Tech Task Services.").termsOfService("https://github.com/cfernandezcairo/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, defaultServer));
    }
}
