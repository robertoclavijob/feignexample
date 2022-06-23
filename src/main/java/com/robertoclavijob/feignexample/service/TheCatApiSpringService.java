package com.robertoclavijob.feignexample.service;

import com.robertoclavijob.feignexample.client.TheCatApiFeignSpringClient;
import com.robertoclavijob.feignexample.model.GeneralResponse;
import com.robertoclavijob.feignexample.model.Vote;
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

    public List<Vote> fetchVotes(){
        List<Vote> votes = theCatApiFeignSpringClient.getVotes();
        return votes;
    }

    public GeneralResponse createVote(String imageId) {
        Vote request = new Vote();
        request.setImageId(imageId);
        request.setSubId("my-user-1234");
        request.setValue(0);

        GeneralResponse result = this.theCatApiFeignSpringClient.postVote(request);
        return result;
    }
}
