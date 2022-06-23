package com.robertoclavijob.feignexample.service;

import com.robertoclavijob.feignexample.client.TheCatApiFeignCustomClient;
import com.robertoclavijob.feignexample.model.GeneralResponse;
import com.robertoclavijob.feignexample.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheCatApiCustomService {
    @Autowired
    TheCatApiFeignCustomClient theCatApiFeignCustomClient;

    public List<Object> fetchImages() {
        List<Object> images = this.theCatApiFeignCustomClient.getImages(10, "ASC");
        return images;
    }

    public List<Vote> fetchVotes(){
        List<Vote> votes = this.theCatApiFeignCustomClient.getVotes("4d553de3-f30a-4669-9b32-b3e4c3b9f971");
        return votes;
    }

    public GeneralResponse createVote(String imageId) {
        Vote request = new Vote();
        request.setImageId(imageId);
        request.setSubId("my-user-1234");
        request.setValue(0);

        GeneralResponse result = this.theCatApiFeignCustomClient.postVote(request.getImageId(), request.getSubId(), request.getValue());
        return result;
    }
}
