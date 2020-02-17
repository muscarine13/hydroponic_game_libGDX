package com.acidcarpet.hydroponist.equipment;


import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class Fan {
    public Fan(double energy_consumption,
               double CO2_production,
               double t_reduce,
               Image image_on,
               Image image_off
    ){
        on = true;

        this.image_on = image_on;
        this.image_off = image_off;

        this.energy_consumption = energy_consumption;
        CO2 = CO2_production;
        this.CO2_production = CO2_production;
        this.t_reduce = t_reduce;
    }

    double energy_consumption;
    double t_reduce;

    private boolean on;
    public synchronized void set_on(){
        on = true;
    }
    public synchronized void set_off(){
        on = false;
    }

    private double CO2;
    private double CO2_production;

    public synchronized boolean reduce_CO2(double consumption){
        if(CO2 >=consumption){
            CO2 -=consumption;
            return true;
        }else{
            return false;
        }
    }
    public synchronized void second(){

        if(!on) return;

        CO2 = CO2_production;

    }

    public boolean isOn() {
        return on;
    }
    public double getCO2() {
        return CO2;
    }
    public double getCO2_production() {
        return CO2_production;
    }
    public double getEnergy_consumption() {
        return energy_consumption;
    }
    public double getT_reduce() {
        if(!on) return 0;
        return t_reduce;
    }

    public abstract String name();
    public abstract String description();

    Image image_on;
    Image image_off;

    public Image get_image_fan(){
        if(isOn())return image_on;
        else return image_off;
    }


}
