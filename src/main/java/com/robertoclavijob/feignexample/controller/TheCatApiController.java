package com.robertoclavijob.feignexample.controller;

import com.robertoclavijob.feignexample.service.TheCatApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thecatapi")
public class TheCatApiController {
    @Autowired
    private TheCatApiService theCatApiService;

    @GetMapping("/images")
    public List<Object> getData(){
        return this.theCatApiService.fetchBreeds();
    }

    @GetMapping("/votes")
    public List<Object> getVotes(){
        return this.theCatApiService.fetchVotes();
    }
}
