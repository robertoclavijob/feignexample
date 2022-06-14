package com.robertoclavijob.feignexample.client;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

public interface TheCatApiFeignClientSimple {

    @RequestLine("GET /images/search?limit=10&order=ASC")
    List<Object> getImages();
}
