package com.robertoclavijob.feignexample.client;

import com.robertoclavijob.feignexample.service.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        value = "thecatapispringannotations",
        url = "https://api.thecatapi.com/v1/"
        //To use a feign class configuration uncomment next code
        //configuration = FeignConfig.class
)
public interface TheCatApiFeignClientSpring {
    @RequestMapping(method = RequestMethod.GET, value = "/images/search?limit=10&order=ASC")
    List<Object> getImages();

    @RequestMapping(method = RequestMethod.GET, value = "/votes")
    List<Object> getVotes(@RequestHeader("x-api-key") String header);
}
