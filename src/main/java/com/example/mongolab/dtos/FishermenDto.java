package com.example.mongolab.dtos;

import com.example.mongolab.enums.FishermenNames;
import com.example.mongolab.models.Catch;
import com.example.mongolab.models.FishingSpots;
import org.bson.types.ObjectId;

import java.util.List;

public class FishermenDto {
    private ObjectId id;
    private FishermenNames name;
    private int age;
    private String licenseId;
    private List<CatchDto> catches;
    private List<FishingSpotsDto> fishingSpots;

    public FishermenDto(){}

    public FishermenDto(ObjectId id, FishermenNames name, int age, String licenseId, List<CatchDto> catches, List<FishingSpotsDto> fishingSpots){
        this.id=id;
        this.name=name;
        this.age=age;
        this.licenseId=licenseId;
        this.catches=catches;
        this.fishingSpots=fishingSpots;
    }
    public ObjectId getId(){return id;}
    public void setId(ObjectId id){this.id=id;}
    public FishermenNames getName(){return name;}
    public void setName(FishermenNames name){this.name=name;}
    public int getAge(){return age;}
    public void setAge(int age){this.age=age;}
    public String getLicenseId(){return licenseId;}
    public void setLicenseId(String licenseId){this.licenseId=licenseId;}
    public List<CatchDto> getCatches(){return catches;}
    public void setCatches(List<CatchDto> catches){this.catches=catches;}
    public List<FishingSpotsDto> getFishingSpots(){return fishingSpots;}
    public void setFishingSpots(List<FishingSpotsDto> fishingSpots){this.fishingSpots=fishingSpots;}
}
