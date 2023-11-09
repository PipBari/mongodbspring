package com.example.mongolab.controllers;

import com.example.mongolab.dtos.FishermenDto;
import com.example.mongolab.services.FishermenService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FishermenController {
    @Autowired
    private FishermenService fishermenService;

    @GetMapping("/fishermen")
    Iterable<FishermenDto> all(){
        return fishermenService.getAll();
    }

    @GetMapping("/fishermen/{id}")
    FishermenDto oneFisherman(@PathVariable String id) throws Throwable {
        return (FishermenDto) fishermenService.findFishermen(new ObjectId(id))
                .orElseThrow(() -> new CatchNotFoundException(id));
    }

    @PostMapping("/fishermen")
    FishermenDto newFireman(@RequestBody FishermenDto fishermenDto)
    {  return fishermenService.createFishermen(fishermenDto); }

    @DeleteMapping("/fishermen/{id}")
    void deleteFisherman(@PathVariable String id) {
        fishermenService.delete(new ObjectId(id));
    }
}
