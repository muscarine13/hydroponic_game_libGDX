package com.acidcarpet.hydroponist.equipment;

import javafx.scene.image.Image;

public abstract class Compressor {

    public Compressor( double energy_consumption, double oxygen_production){
        on = true;



        this.energy_consumption = energy_consumption;
        oxygen = oxygen_production;
        this.oxygen_production = oxygen_production;
    }



    double energy_consumption;

    private boolean on;
    public synchronized void set_on(){
        on = true;
    }
    public synchronized void set_off(){
        on = false;
    }

    private double oxygen;
    private double oxygen_production;

    public synchronized boolean reduce_oxygen(double consumption){
        if(oxygen >=consumption){
            oxygen -=consumption;
            return true;
        }else{
            return false;
        }
    }
    public synchronized void second(){

        if(!on) return;

        oxygen = oxygen_production;

    }

    public abstract String name();
    public abstract String description();

    public abstract Image inventory_image();
    public abstract Image on_image();
    public abstract Image off_image();

    public boolean isOn() {
        return on;
    }
    public double getOxygen() {
        return oxygen;
    }
    public double getOxygen_production() {
        return oxygen_production;
    }

}
