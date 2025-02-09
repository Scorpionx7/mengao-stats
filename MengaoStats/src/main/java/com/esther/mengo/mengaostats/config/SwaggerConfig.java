package com.esther.mengo.mengaostats.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI mengaoStatsOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Mengão-Stats API")
                        .description("Api para fornecer informações em tempo real sobre o Flamengo.")
                        .version("v1.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));

    }
}
