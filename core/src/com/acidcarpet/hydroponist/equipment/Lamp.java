package com.acidcarpet.hydroponist.equipment;


import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class Lamp {

    public Lamp(
            double energy_consumption,
            double lm_production,
            double t_add,
            Image image_lamp_on,
            Image image_lamp_off,
            Image image_light_on,
            Image image_light_off
    ){
        on = true;

        this.image_lamp_on = image_lamp_on;
        this.image_lamp_off = image_lamp_off;
        this.image_light_on = image_light_on;
        this.image_light_off = image_light_off;

        this.energy_consumption = energy_consumption;
        lm = lm_production;
        this.lm_production = lm_production;
        this.t_add = t_add;
    }

    double energy_consumption;
    double t_add;

    private boolean on;
    public synchronized void set_on(){
        on = true;
    }
    public synchronized void set_off(){
        on = false;
    }

    private double lm;
    private double lm_production;

    public synchronized boolean reduce_lm(double consumption){
        if(lm>=consumption){
            lm-=consumption;
            return true;
        }else{
            return false;
        }
    }
    public synchronized void second(){

        if(!on) return;

        lm = lm_production;

    }

    public boolean isOn() {
        return on;
    }
    public double getLm() {
        return lm;
    }
    public double getLm_production() {
        return lm_production;
    }
    public double getEnergy_consumption() {
        return energy_consumption;
    }
    public double getT_add() {
        if(!on) return 0;
        return t_add;
    }

    public abstract String name();
    public abstract String description();

    Image image_lamp_on;
    Image image_lamp_off;

    Image image_light_on;
    Image image_light_off;

    public Image get_image_lamp(){
        if(isOn()) return image_lamp_on;
        else return image_lamp_off;
    }
    public Image get_image_light(){
        if (isOn()) return image_light_on;
        else return image_light_off;
    }


}
