package com.acidcarpet.hydroponist.equipment;


import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Fan implements Storable {
    public Fan(
            String name,
            String description,

            double CO2_production,
            double t_reduce,

            int gold_price,
            int diamond_price,

            Image image_on,
            Image image_off,
            Image item_icon
    ){
        on = true;

        this.name = name;
        this.description = description;
        this.image_on = image_on;
        this.image_off = image_off;
        this.item_icon = item_icon;

        this.gold_price = gold_price;
        this.diamond_price = diamond_price;

        this.CO2 = CO2_production;
        this.CO2_production = CO2_production;
        this.t_reduce = t_reduce;
    }

    private int gold_price;
    private int diamond_price;

    @Override
    public int coin_price() {
        return gold_price;
    }

    @Override
    public int diamond_price() {
        return diamond_price;
    }

    private String name;
    private String description;
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
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

    private double CO2;
    private double CO2_production;

    double t_reduce;

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
        if(!on) return 0;
        return CO2_production;
    }

    public double getT_reduce() {
        if(!on) return 0;
        return t_reduce;
    }

    Image image_on;
    Image image_off;

    Image item_icon;

    public Image get_image_fan(){
        if(isOn())return image_on;
        else return image_off;
    }
    public Image get_image_item(){
        return item_icon;
    }

    @Override
    public String toString() {
        return "FAN";
    }


}
