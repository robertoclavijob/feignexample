package com.robertoclavijob.feignexample.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignSpringConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
