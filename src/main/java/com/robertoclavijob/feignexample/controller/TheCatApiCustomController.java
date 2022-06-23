package com.robertoclavijob.feignexample.controller;

import com.robertoclavijob.feignexample.model.GeneralResponse;
import com.robertoclavijob.feignexample.service.TheCatApiCustomService;
import com.robertoclavijob.feignexample.service.TheCatApiSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thecatapi/custom")
public class TheCatApiCustomController {
    @Autowired
    private TheCatApiCustomService theCatApiCustomService;

    @GetMapping("images")
    public List<Object> getImages(){
        return this.theCatApiCustomService.fetchImages();
    }

    @GetMapping("votes")
    public List<Object> getVotes(){
        return this.theCatApiCustomService.fetchVotes();
    }

    @PostMapping("votes/{imageId}")
    public GeneralResponse publishVote(@PathVariable("imageId") String imageId){
        return this.theCatApiCustomService.createVote(imageId);
    }

}
