package com.robertoclavijob.feignexample.config;

import com.robertoclavijob.feignexample.decoder.MyErrorDecoder;
import feign.Logger;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignSpringConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("x-api-key", "4d553de3-f30a-4669-9b32-b3e4c3b9f971");
        };
    }
    @Bean
    Retryer retryer(){
        return new Retryer.Default(2000l, 10000l, 5);
    }

    @Bean
    ErrorDecoder customErrorDecoder(){
        return new MyErrorDecoder();
    }
}
