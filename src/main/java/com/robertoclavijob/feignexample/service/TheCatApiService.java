package com.robertoclavijob.feignexample.service;

import com.robertoclavijob.feignexample.client.TheCatApiFeignClientSimple;
import com.robertoclavijob.feignexample.client.TheCatApiFeignClientSpringAnnotation;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheCatApiService {

    @Autowired
    TheCatApiFeignClientSpringAnnotation theCatApiFeignClientSpringAnnotation;

    public List<Object> fetchImagesSpring(){
        List<Object> images = theCatApiFeignClientSpringAnnotation.getImages();
        return images;
    }

    public List<Object> fetchImages() {
        TheCatApiFeignClientSimple theCatApiFeignClientSimple = Feign.builder().decoder(new JacksonDecoder())
                .target(TheCatApiFeignClientSimple.class, "https://api.thecatapi.com/v1/");
        List<Object> images = theCatApiFeignClientSimple.getImages();
        return images;
    }
    public List<Object> fetchVotes(){
        List<Object> images = theCatApiFeignClientSpringAnnotation.getVotes("4d553de3-f30a-4669-9b32-b3e4c3b9f971");
        return images;
    }
}
