package com.robertoclavijob.feignexample.client;

import com.robertoclavijob.feignexample.config.FeignSpringConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        value = "thecatapispringannotations",
        url = "https://api.thecatapi.com/v1/",
        configuration = FeignSpringConfig.class
)
public interface TheCatApiFeignSpringClient {
    @RequestMapping(method = RequestMethod.GET, value = "/images/search")
    List<Object> getImages(@RequestParam("limit") Integer limit, @RequestParam("order") String order);

    @RequestMapping(method = RequestMethod.GET, value = "/votes")
    List<Object> getVotes(@RequestHeader("x-api-key") String header);
}
