package com.example.mongolab.controllers;

public class CatchNotFoundException extends RuntimeException{
    CatchNotFoundException(String id) {
        super("Could not find catch " + id);
    }
}
