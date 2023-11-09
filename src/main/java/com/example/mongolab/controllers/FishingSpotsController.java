package com.example.mongolab.controllers;

import com.example.mongolab.dtos.CatchDto;
import com.example.mongolab.dtos.FishingSpotsDto;
import com.example.mongolab.services.FishingSpotsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FishingSpotsController {
    @Autowired
    private FishingSpotsService fishingSpotsService;

    @GetMapping("/fishingspots")
    Iterable<FishingSpotsDto> all(){
        return fishingSpotsService.getAll();
    }

    @GetMapping("/fishingspots/{id}")
    FishingSpotsDto oneFishingSpots(@PathVariable String id) throws Throwable {
        return (FishingSpotsDto) fishingSpotsService.findFishingSpot(new ObjectId(id))
                .orElseThrow(() -> new FishingSpotsNotFoundException(id));
    }

    @PostMapping("/fishingspots")
    FishingSpotsDto newFishingSpots(@RequestBody FishingSpotsDto fishingSpotsDto)
    {  return fishingSpotsService.createFishingSpots(fishingSpotsDto); }

    @DeleteMapping("/fishingspots/{id}")
    void deleteFishingSpots(@PathVariable String id) {
        fishingSpotsService.delete(new ObjectId(id));
    }
}
