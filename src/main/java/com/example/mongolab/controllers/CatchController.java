package com.example.mongolab.controllers;

import com.example.mongolab.dtos.CatchDto;
import com.example.mongolab.services.CatchService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CatchController {
    @Autowired
    private CatchService catchService;

    @GetMapping("/catch")
    Iterable<CatchDto> all(){
        return catchService.getAll();
    }

    @GetMapping("/catch/{id}")
    CatchDto oneCatch(@PathVariable String id) throws Throwable {
        return (CatchDto) catchService.findCatch(new ObjectId(id))
                .orElseThrow(() -> new CatchNotFoundException(id));
    }

    @PostMapping("/catch")
    CatchDto newCatch(@RequestBody CatchDto catchDto)
    {  return catchService.createCatch(catchDto); }

    @DeleteMapping("/catch/{id}")
    void deleteCatch(@PathVariable String id) {
        catchService.delete(new ObjectId(id));
    }
}
