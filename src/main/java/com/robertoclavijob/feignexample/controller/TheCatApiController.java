package com.robertoclavijob.feignexample.controller;

import com.robertoclavijob.feignexample.service.TheCatApiCustomService;
import com.robertoclavijob.feignexample.service.TheCatApiSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thecatapi")
public class TheCatApiController {
    @Autowired
    private TheCatApiCustomService theCatApiCustomService;

    @Autowired
    private TheCatApiSpringService theCatApiSpringService;

    @GetMapping("/images")
    public List<Object> getImages(){
        return this.theCatApiCustomService.fetchImages();
    }

    @GetMapping("/images/spring")
    public List<Object> getImagesSpring(){
        return this.theCatApiSpringService.fetchImagesSpring();
    }

    @GetMapping("/votes")
    public List<Object> getVotes(){
        return this.theCatApiSpringService.fetchVotes();
    }
}
