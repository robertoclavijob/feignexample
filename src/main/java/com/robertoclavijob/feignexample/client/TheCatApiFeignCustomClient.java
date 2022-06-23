package com.robertoclavijob.feignexample.client;

import com.robertoclavijob.feignexample.model.GeneralResponse;
import com.robertoclavijob.feignexample.model.Vote;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface TheCatApiFeignCustomClient {

    @RequestLine("GET /images/search?limit={limit}&order={order}")
    List<Object> getImages(@Param Integer limit, @Param String order);

    @RequestLine("GET /votes")
    @Headers("x-api-key: {apiKey}")
    List<Vote> getVotes(@Param("apiKey") String apiKey);

    @RequestLine("POST /votes")
    @Headers("Content-Type: application/json")
    @Body("%7B\"image_id\":\"{imageId}\",\"sub_id\":\"{subId}\",\"value\":{value}%7D")
    GeneralResponse postVote(@Param("imageId") String imageId, @Param("subId") String subId, @Param("value") Integer value);
}
