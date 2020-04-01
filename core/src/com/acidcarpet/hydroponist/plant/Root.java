package com.acidcarpet.hydroponist.plant;
import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.WaterPack;

import java.util.Random;

public class Root {
    private boolean alive;

    public Root(
            int maximum_health,
            int growth_length,

            double oxygen_consume,
            double pH_minimum,
            double ph_maximum,
            double t_minimum,
            double t_maximum,
            int ppm_minimum,
            int ppm_maximum,

            double water_absorb_multiplier

    ){

        alive=true;
        length=growth_length;

        this.maximum_health = maximum_health;
        this.current_health = maximum_health/2;
        this.growth_length = growth_length;

        this.oxygen_consumption = oxygen_consume;

        this.pH_minimum = pH_minimum;
        this.ph_maximum = ph_maximum;

        this.t_minimum = t_minimum;
        this.t_maximum = t_maximum;

        this.ppm_minimum = ppm_minimum;
        this.ppm_maximum = ppm_maximum;

        this.water_volume_multiplier = water_absorb_multiplier;

    }


    private int current_health;
    private int maximum_health;

    private double length;
    private int growth_length;

    private double oxygen_consumption;
    private double pH_minimum;
    private double ph_maximum;
    private double t_minimum;
    private double t_maximum;
    private int ppm_minimum;
    private int ppm_maximum;

    private double water_volume_multiplier;

    public synchronized boolean may_absorb(){
        if(!alive) return false;
        if(Box.getInstance().getPot()==null) return false;
        if(Box.getInstance().getPump()==null) return false;

        if(
                (Box.getInstance().getPot().getCurrent_pH()< ph_maximum &&Box.getInstance().getPot().getCurrent_pH()> pH_minimum)
                        &&      (Box.getInstance().getPot().get_all_ppm()>ppm_minimum&&Box.getInstance().getPot().get_all_ppm()<ppm_maximum)
                        &&       Box.getInstance().getPump().reduce_oxygen(oxygen_consumption *length)
                        &&       Box.getInstance().getPot().getCurrent_volume()>=length*water_volume_multiplier
        ){
            return true;
        }else{
           return false;
        }
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

    public void grow(){
        if(!alive) return;

        boolean win;
        win = new Random().nextDouble()<0.001; // 1 к 1000 0.1%

        if(win) {
            length += growth_length;
        }
    }

    public boolean isAlive() {
        return alive;
    }
    public int getCurrent_health() {
        return current_health;
    }
    public int getMaximum_health() {
        return maximum_health;
    }
    public double getLength() {
        return length;
    }
    public int getGrowth_length() {
        return growth_length;
    }
    public double getOxygen_consumption() {
        return oxygen_consumption;
    }
    public double getpH_minimum() {
        return pH_minimum;
    }
    public double getPh_maximum() {
        return ph_maximum;
    }
    public double getT_minimum() {
        return t_minimum;
    }
    public double getT_maximum() {
        return t_maximum;
    }
    public int getPpm_minimum() {
        return ppm_minimum;
    }
    public int getPpm_maximum() {
        return ppm_maximum;
    }
    public double getWater_volume_multiplier() {
        return water_volume_multiplier;
    }

}
