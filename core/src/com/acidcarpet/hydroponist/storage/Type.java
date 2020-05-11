package com.acidcarpet.hydroponist.storage;

public enum Type {
    LAMP("LAMP"),
    FAN("FAN"),
    BOTTLE("BOTTLE");

    Type(String line){
        this.line = line;
    }
    String line;
}
