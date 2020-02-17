package com.acidcarpet.hydroponist.equipment;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class Compressor {

    public Compressor( double oxygen_production, Image image_on, Image image_off){
        on = true;

        this.image_on = image_on;
        this.image_off = image_off;
        oxygen = oxygen_production;
        this.oxygen_production = oxygen_production;

    }



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

    private Image image_on;
    private Image image_off;

    public Image get_image_compressor(){
        if (isOn()) return image_on;
        else return  image_off;
    }

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
