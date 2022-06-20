package com.robertoclavijob.feignexample.service;

import com.robertoclavijob.feignexample.client.TheCatApiFeignClientCustom;
import com.robertoclavijob.feignexample.client.TheCatApiFeignClientSpring;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheCatApiService {

    @Autowired
    TheCatApiFeignClientSpring theCatApiFeignClientSpring;

    public List<Object> fetchImagesSpring(){
        List<Object> images = theCatApiFeignClientSpring.getImages();
        return images;
    }

    public List<Object> fetchImages() {
        TheCatApiFeignClientCustom theCatApiFeignClientCustom = Feign.builder()
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(TheCatApiFeignClientCustom.class, "https://api.thecatapi.com/v1/");
        List<Object> images = theCatApiFeignClientCustom.getImages();
        return images;
    }
    public List<Object> fetchVotes(){
        List<Object> images = theCatApiFeignClientSpring.getVotes("4d553de3-f30a-4669-9b32-b3e4c3b9f971");
        return images;
    }
}
