package com.acidcarpet.hydroponist.equipment;


import com.acidcarpet.hydroponist.plant.Plant;

public class Box {
    private String name;
    private String description;

    private double box_ordinary_temperature;

    private Lamp lamp;
    private Fan fan;

    private Plant plant;
    private Pot pot;
    private Compressor compressor;

    public Box(
            String name,
            String description,
            double box_ordinary_temperature,

            Lamp lamp,
            Fan fan,
            Pot pot,
            Compressor compressor

    ){
        this.name = name;
        this.description = description;
        this.box_ordinary_temperature = box_ordinary_temperature;
        this.lamp = lamp;
        this.fan = fan;
        this.pot = pot;
        this.compressor = compressor;

        plant = null;

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
    public Compressor getCompressor() {
        return compressor;
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
    public synchronized void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

}
