package com.astropay.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

/**
 * Configurador de Feign
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Configuration
public class ClientConfiguration {

    @Bean
    ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}