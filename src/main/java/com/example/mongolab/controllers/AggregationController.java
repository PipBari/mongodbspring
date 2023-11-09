package com.example.mongolab.controllers;

import com.example.mongolab.dtos.AggregatedCatchInfoDto;
import com.example.mongolab.services.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AggregationController {
    @Autowired
    private AggregationService aggregationService;

    @GetMapping("/info")
    public List<AggregatedCatchInfoDto> getAggregatedInfo() {
        return aggregationService.getAggregatedInfo();
    }
    @GetMapping("/info/count")
    public int getAggregatedInfoCount() {
        return aggregationService.getAggregatedInfoCount();
    }
}
