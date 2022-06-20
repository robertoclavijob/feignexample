package com.robertoclavijob.feignexample.config;

import com.robertoclavijob.feignexample.client.TheCatApiFeignCustomClient;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignCustomConfig {
    @Bean
    public TheCatApiFeignCustomClient feignClient(){
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.BASIC)
                .target(TheCatApiFeignCustomClient.class, "https://api.thecatapi.com/v1/");
    }
}
