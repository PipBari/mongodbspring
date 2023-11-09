package com.example.mongolab.dtos;

import com.example.mongolab.enums.FishType;
import com.example.mongolab.enums.RodType;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public class CatchDto {
    private ObjectId id;
    private FishType fishType;
    private double weight;
    private LocalDate catchTime;
    private RodType rodType;

    public CatchDto(){}

    public CatchDto(ObjectId id, FishType fishType, double weight, LocalDate catchTime, RodType rodType){
        this.id=id;
        this.fishType=fishType;
        this.weight=weight;
        this.catchTime=catchTime;
        this.rodType=rodType;
    }
    public ObjectId getId(){return id;}
    public void setId(ObjectId id){this.id=id;}
    public FishType getFishType(){return fishType;}
    public void setFishType(FishType fishType){this.fishType=fishType;}
    public double getWeight(){return weight;}
    public void setWeight(double weight){this.weight=weight;}
    public LocalDate getCatchTime(){return catchTime;}
    public void setCatchTime(LocalDate catchTime){this.catchTime=catchTime;}
    public RodType getRodType(){return rodType;}
    public void setRodType(RodType rodType){this.rodType=rodType;}

}
