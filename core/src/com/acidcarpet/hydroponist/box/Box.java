package com.acidcarpet.hydroponist.box;

import com.acidcarpet.hydroponist.fan.Fan;
import com.acidcarpet.hydroponist.lamp.Lamp;
import com.acidcarpet.hydroponist.plant.Plant;
import com.acidcarpet.hydroponist.pot.Pot;

public class Box {
    public static final int temperature = 25;
    private static Box instance;
    public static Box getInstance(){
        if(instance==null) instance = new Box();
        return instance;
    }

    private Lamp lamp;
    private Fan fan;
    private Pot pot;
    private Plant plant;

    public synchronized void second(){
        lamp.second();
        fan.second();
        pot.second();
        plant.second();
    }
    public static void setInstance(Box instance) {
        Box.instance = instance;
    }

    public Lamp getLamp() {
        return lamp;
    }
    public synchronized void setLamp(Lamp lamp) {
        this.lamp = lamp;
    }
    public Fan getFan() {
        return fan;
    }
    public synchronized void setFan(Fan fan) {
        this.fan = fan;
    }
    public Pot getPot() {
        return pot;
    }
    public synchronized void setPot(Pot pot) {
        this.pot = pot;
    }
    public Plant getPlant() {
        return plant;
    }
    public synchronized void setPlant(Plant plant) {
        this.plant = plant;
    }
}
