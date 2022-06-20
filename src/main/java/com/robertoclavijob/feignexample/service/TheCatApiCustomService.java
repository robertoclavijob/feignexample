package com.robertoclavijob.feignexample.service;

import com.robertoclavijob.feignexample.client.TheCatApiFeignCustomClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheCatApiCustomService {
    @Autowired
    TheCatApiFeignCustomClient theCatApiFeignCustomClient;

    public List<Object> fetchImages() {
        List<Object> images = this.theCatApiFeignCustomClient.getImages();
        return images;
    }
}
