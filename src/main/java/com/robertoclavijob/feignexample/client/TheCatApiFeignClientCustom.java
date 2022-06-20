package com.robertoclavijob.feignexample.client;

import feign.RequestLine;

import java.util.List;

public interface TheCatApiFeignClientCustom {

    @RequestLine("GET /images/search?limit=10&order=ASC")
    List<Object> getImages();
}
