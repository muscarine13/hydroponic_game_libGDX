package com.acidcarpet.hydroponist.equipment;


import com.acidcarpet.hydroponist.genered.test_pack.*;
import com.acidcarpet.hydroponist.plant.Plant;

import java.util.Date;

public class Box {

    private static long last_update;
    public static synchronized void update(){
        last_update = new Date().getTime();
    }
    public static long get_last_update(){
        return last_update;
    }

    private static Box instance;
    public static Box getInstance(){
        if(instance==null) instance = new Box();
        return instance;
    }
    private String name;
    private String description;

    private double box_ordinary_temperature;

    private Lamp lamp;
    private Fan fan;

    private Plant plant;
    private Pot pot;
    private Pump pump;

    public Box(
    ){
        this.name = "Гроубокс";
        this.description = "Описание гроубокса";
        this.box_ordinary_temperature = 24;
        this.lamp = new TestLamp();
        this.fan = new TestFan();
        this.pot = new TestPot();
        this.pump = new TestPump();

        plant = new TestPlant();

        last_update = new Date().getTime();
    }

    public double actual_t(){
        return box_ordinary_temperature +lamp.getT_add()-fan.getT_reduce();
    }

    public Lamp getLamp() {
        return lamp;
    }
    public Fan getFan() {
        return fan;
    }
    public Plant getPlant() {
        return plant;
    }
    public Pot getPot() {
        return pot;
    }
    public Pump getPump() {
        return pump;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getBox_ordinary_temperature() {
        return box_ordinary_temperature;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }
    public synchronized void setDescription(String description) {
        this.description = description;
    }
    public synchronized void setBox_ordinary_temperature(double box_ordinary_temperature) {
        this.box_ordinary_temperature = box_ordinary_temperature;
    }
    public synchronized void setLamp(Lamp lamp) {
        this.lamp = lamp;
    }
    public synchronized void setFan(Fan fan) {
        this.fan = fan;
    }
    public synchronized void setPlant(Plant plant) {
        this.plant = plant;
    }
    public synchronized void setPot(Pot pot) {
        this.pot = pot;
    }
    public synchronized void setPump(Pump pump) {
        this.pump = pump;
    }

}
