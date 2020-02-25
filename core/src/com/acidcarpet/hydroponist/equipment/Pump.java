package com.acidcarpet.hydroponist.equipment;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class Pump {

    public Pump(double oxygen_production, Image image_on, Image image_off, Image item_icon){
        on = true;

        this.image_on = image_on;
        this.image_off = image_off;
        this.item_icon = item_icon;

        oxygen = oxygen_production;
        this.oxygen_production = oxygen_production;

    }


    private boolean on;
    public synchronized void set_on(){
        on = true;
        Box.update();
    }
    public synchronized void set_off(){
        on = false;
        Box.update();
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

    Image item_icon;

    public Image get_image_pump(){
        if (isOn()) return image_on;
        else return  image_off;
    }
    public Image get_image_item(){
        return item_icon;
    }

    public boolean isOn() {
        return on;
    }
    public double getOxygen() {
        return oxygen;
    }
    public double getOxygen_production() {
        if(on) return oxygen_production;
        else return 0;
    }

}
