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
        List<Object> images = theCatApiFeignSpringClient.getImages();
        return images;
    }

    public List<Object> fetchVotes(){
        List<Object> images = theCatApiFeignSpringClient.getVotes("4d553de3-f30a-4669-9b32-b3e4c3b9f971");
        return images;
    }
}
