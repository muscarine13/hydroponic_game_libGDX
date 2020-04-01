package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.equipment.Box;

import java.util.Random;

public class Leave {
    private boolean alive;

    private double height;
    private double width;

    private double height_grow_length;
    private double width_grow_length;

    private double dark_energy_production;
    private double light_energy_production;

    private double water_consumption;
    private double CO2_consumption;

    private double t_minimum;
    private double t_maximum;

    private double lm_consumption;

    private int current_health;
    private int maximum_health;

    public Leave(
            int maximum_health,
            double height,
            double width,

            double height_grow_length,
            double width_grow_length,
            double light_energy_production,
            double dark_energy_production,
            double water_consumption,

            double CO2_consumption,
            double t_minimum,
            double t_maximum,
            double lm_consumption
    ){

        alive = true;

        this.maximum_health = maximum_health;
        this.current_health = maximum_health/2;

        this.height = height;
        this.width = width;

        this.height_grow_length = height_grow_length;
        this.width_grow_length = width_grow_length;
        this.light_energy_production = light_energy_production;
        this.dark_energy_production = dark_energy_production;

        this.water_consumption = water_consumption;
        this.CO2_consumption = CO2_consumption;

        this.t_minimum = t_minimum;
        this.t_maximum = t_maximum;
        this.lm_consumption = lm_consumption;

    }
    public synchronized void hit(){
        if(!alive) return;
        current_health--;
        if(current_health<=0) {
            alive = false;
            current_health = 0;
        }
    }
    public synchronized void heal(){
        if(!alive) return;
        current_health++;
        if(current_health>=maximum_health) {
            current_health = maximum_health;
        }
    }
    public boolean may_photosynthesis(){
        if(!alive) return false;
        if(Box.getInstance().getLamp()==null) return false;
        if(Box.getInstance().getFan()==null) return false;

        double actual_water_consumption = water_consumption * (int)(height*width);

        if(
                        (Box.getInstance().getPlant().getWater()>=actual_water_consumption)
                        && Box.getInstance().getFan().reduce_CO2(CO2_consumption *(int)(height*width))
                        &&
                        (Box.getInstance().actual_t()< t_maximum &&Box.getInstance().actual_t()> t_minimum)

        ){
           return true;
        }else{
            return false;
        }

    }
    void grow(){
        if(!alive) return;

        boolean win;
        win = new Random().nextDouble()<0.005; // 1 к 500 0.5%

        if(win){
            height+= height_grow_length;
            width+= width_grow_length;
        }

    }

    public boolean isAlive() {
        return alive;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight_grow_length() {
        return height_grow_length;
    }
    public double getWidth_grow_length() {
        return width_grow_length;
    }
    public double getWater_consumption() {
        return water_consumption;
    }
    public double getCO2_consumption() {
        return CO2_consumption;
    }
    public double getT_minimum() {
        return t_minimum;
    }
    public double getT_maximum() {
        return t_maximum;
    }
    public double getLm_consumption() {
        return lm_consumption;
    }
    public int getCurrent_health() {
        return current_health;
    }
    public int getMaximum_health() {
        return maximum_health;
    }
    public double getDark_energy_production() {
        return dark_energy_production;
    }
    public double getLight_energy_production() {
        return light_energy_production;
    }
}
