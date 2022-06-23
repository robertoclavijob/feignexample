package com.robertoclavijob.feignexample.controller;

import com.robertoclavijob.feignexample.model.GeneralResponse;
import com.robertoclavijob.feignexample.model.Vote;
import com.robertoclavijob.feignexample.service.TheCatApiSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thecatapi/spring")
public class TheCatApiSpringController {

    @Autowired
    private TheCatApiSpringService theCatApiSpringService;

    @GetMapping("images")
    public List<Object> getImagesSpring(){
        return this.theCatApiSpringService.fetchImages();
    }

    @GetMapping("votes")
    public List<Vote> getVotes(){
        return this.theCatApiSpringService.fetchVotes();
    }
    @PostMapping("votes/{imageId}")
    public GeneralResponse publishVote(@PathVariable("imageId") String imageId){
        return this.theCatApiSpringService.createVote(imageId);
    }
}
