package com.example.mongolab.models;

import com.example.mongolab.enums.FishType;
import com.example.mongolab.enums.RodType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDate;

@Document(collection = "catch")
public class Catch extends ModelBase{
    @Field(targetType = FieldType.STRING)
    private FishType fishType;
    private double weight;
    private LocalDate catchTime;
    @Field(targetType = FieldType.STRING)
    private RodType rodType;

    public Catch(){}

    public Catch(FishType fishType, double weight, LocalDate catchTime, RodType rodType){
        this.fishType=fishType;
        this.weight=weight;
        this.catchTime=catchTime;
        this.rodType=rodType;
    }
    public FishType getFishType(){return fishType;}
    public void setFishType(FishType fishType){this.fishType=fishType;}
    public double getWeight(){return weight;}
    public void setWeight(double weight){this.weight=weight;}
    public LocalDate getCatchTime(){return catchTime;}
    public void setCatchTime(LocalDate catchTime){this.catchTime=catchTime;}
    public RodType getRodType(){return rodType;}
    public void setRodType(RodType rodType){this.rodType=rodType;}
}
