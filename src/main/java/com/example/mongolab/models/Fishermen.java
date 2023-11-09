package com.example.mongolab.models;

import com.example.mongolab.enums.FishermenNames;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;

@Document(collection = "fishermen")
public class Fishermen extends ModelBase{
    @Field(targetType = FieldType.STRING)
    private FishermenNames name;
    private int age;
    private String licenseId;
    private List<Catch> catches;
    private List<FishingSpots> fishingSpots;

    public Fishermen(){}

    public Fishermen(FishermenNames name, int age, String licenseId, List<Catch> catches, List<FishingSpots> fishingSpots){
        this.name=name;
        this.age=age;
        this.licenseId=licenseId;
        this.catches=catches;
        this.fishingSpots=fishingSpots;
    }
    public FishermenNames getName(){return name;}
    public void setName(FishermenNames name){this.name=name;}
    public int getAge(){return age;}
    public void setAge(int age){this.age=age;}
    public String getLicenseId(){return licenseId;}
    public void setLicenseId(String licenseId){this.licenseId=licenseId;}
    public List<Catch> getCatches(){return catches;}
    public void setCatches(List<Catch> catches){this.catches=catches;}
    public List<FishingSpots> getFishingSpots(){return fishingSpots;}
    public void setFishingSpots(List<FishingSpots> fishingSpots){this.fishingSpots=fishingSpots;}
}
