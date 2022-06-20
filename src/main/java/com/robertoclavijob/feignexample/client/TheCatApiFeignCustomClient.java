package com.robertoclavijob.feignexample.client;

import feign.RequestLine;

import java.util.List;

public interface TheCatApiFeignCustomClient {

    @RequestLine("GET /images/search?limit=10&order=ASC")
    List<Object> getImages();
}
