package com.robertoclavijob.feignexample.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyErrorDecoder implements ErrorDecoder {
    private static Logger logger = LoggerFactory.getLogger(MyErrorDecoder.class);

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 401){
            throw new IllegalArgumentException("The api key is not valid");
        }
        throw new IllegalArgumentException("The cat API returned an error");
    }
}
