package com.parameta.employee.rest.util;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Utilities for the rest api.
 * */

@Component
public class Utilities {

    /**
     * Rest template builder to consume rest apis.
     * @param builder The builder.
     * @return RestTemplate the configured rest template.
     * */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
