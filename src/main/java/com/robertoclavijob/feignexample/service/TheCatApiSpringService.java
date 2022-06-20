package com.robertoclavijob.feignexample.service;

import com.robertoclavijob.feignexample.client.TheCatApiFeignSpringClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheCatApiSpringService {
    @Autowired
    TheCatApiFeignSpringClient theCatApiFeignSpringClient;

    public List<Object> fetchImages(){
        List<Object> images = theCatApiFeignSpringClient.getImages(10, "ASC");
        return images;
    }

    public List<Object> fetchVotes(){
        List<Object> images = theCatApiFeignSpringClient.getVotes();
        return images;
    }
}
