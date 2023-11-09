package com.example.mongolab.dtos;

import com.example.mongolab.enums.FishType;
import com.example.mongolab.enums.FishermenNames;
import com.example.mongolab.enums.SpotsLocation;

public class AggregatedCatchInfoDto {
    private FishermenNames fishermenName;
    private FishType fishType;
    private SpotsLocation spotsLocation;

    public AggregatedCatchInfoDto() {}

    public AggregatedCatchInfoDto(FishermenNames fishermenName, FishType fishType, SpotsLocation spotsLocation) {
        this.fishermenName = fishermenName;
        this.fishType = fishType;
        this.spotsLocation = spotsLocation;
    }

    public FishermenNames getFishermenName() {
        return fishermenName;
    }

    public void setFishermenName(FishermenNames fishermenName) {
        this.fishermenName = fishermenName;
    }

    public FishType getFishType() {
        return fishType;
    }

    public void setFishType(FishType fishType) {
        this.fishType = fishType;
    }

    public SpotsLocation getSpotsLocation() {
        return spotsLocation;
    }

    public void setSpotsLocation(SpotsLocation spotsLocation) {
        this.spotsLocation = spotsLocation;
    }
}
