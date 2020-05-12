package com.acidcarpet.hydroponist.box;

import com.acidcarpet.hydroponist.fan.Fan;
import com.acidcarpet.hydroponist.fan.FanGenerator;
import com.acidcarpet.hydroponist.lamp.Lamp;
import com.acidcarpet.hydroponist.lamp.LampGenerator;
import com.acidcarpet.hydroponist.plant.Plant;
import com.acidcarpet.hydroponist.plant.PlantGenerator;
import com.acidcarpet.hydroponist.pot.Pot;
import com.acidcarpet.hydroponist.screen.box.BoxScreen;

public class Box {

    public static Thread seconds;

    public static final int temperature = 25;
    private static Box instance;
    public static Box getInstance(){
        if(instance==null) instance = new Box();
        return instance;
    }

    Box(){
        lamp = LampGenerator.generate_random();
        pot = Pot.getInstance();
        fan = FanGenerator.generate_random();
        plant = PlantGenerator.generate_random();


    }

    private Lamp lamp;
    private Fan fan;
    private Pot pot;
    private Plant plant;

    public synchronized void second(){

        if(plant!=null)lamp.second();
        if(plant!=null)fan.second();
        if(plant!=null)pot.second();
        if(plant!=null)plant.second();
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
