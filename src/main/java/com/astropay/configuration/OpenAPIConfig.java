package com.astropay.configuration;

import static com.astropay.constant.Constant.API_DESCRIPTION;
import static com.astropay.constant.Constant.API_MANAGER_TAG;
import static com.astropay.constant.Constant.API_MANAGER_TAG_DESCRIPCION;
import static com.astropay.constant.Constant.API_NAME;
import static com.astropay.constant.Constant.AUTHORIZATION_TYPE;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

/**
* @apiNote Configuración de OpenAPI
* @author luchos297
* @version 1.0.0
* @since 09 aug. 2022
*/
@Configuration
@SecurityScheme(name = AUTHORIZATION_TYPE, type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class OpenAPIConfig {

	@Value("${info.application.version}")
	private String version;
	
    @Bean
    OpenAPI config() {
        return new OpenAPI().info(new Info().title(API_NAME).description(API_DESCRIPTION).version(version)).addTagsItem(new Tag().name(API_MANAGER_TAG).description(API_MANAGER_TAG_DESCRIPCION));
    }
}