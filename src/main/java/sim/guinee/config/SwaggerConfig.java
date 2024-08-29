package sim.guinee.config;

import org.springframework.context.annotation.Configuration;


import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Projet Sim Guinée) ")
                        .description("API SIM GUINEE  ")
                        .version("1.0"));
    }
    
}
