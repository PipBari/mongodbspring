package com.example.mongolab.controllers;

public class FishingSpotsNotFoundException extends RuntimeException{
    FishingSpotsNotFoundException(String id) {
        super("Could not find fishing spots " + id);
    }
}
