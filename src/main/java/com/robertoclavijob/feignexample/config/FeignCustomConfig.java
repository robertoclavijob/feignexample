package com.robertoclavijob.feignexample.config;

import com.robertoclavijob.feignexample.client.TheCatApiFeignCustomClient;
import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.Retryer;
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
                .requestInterceptor(this.requestInterceptor())
                .retryer(new Retryer.Default(2000l, 10000l, 5))
                .target(TheCatApiFeignCustomClient.class, "https://api.thecatapi.com/v1/");
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("x-api-key", "4d553de3-f30a-4669-9b32-b3e4c3b9f971");
        };
    }
}
