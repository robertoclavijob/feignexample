package com.robertoclavijob.feignexample.controller;

import com.robertoclavijob.feignexample.service.TheCatApiSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Object> getVotes(){
        return this.theCatApiSpringService.fetchVotes();
    }
}
