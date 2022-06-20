package com.robertoclavijob.feignexample.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface TheCatApiFeignCustomClient {

    @RequestLine("GET /images/search?limit={limit}&order={order}")
    List<Object> getImages(@Param Integer limit, @Param String order);

    @RequestLine("GET /votes")
    @Headers("x-api-key: {apiKey}")
    List<Object> getVotes(@Param("apiKey") String apiKey);
}
