package com.acidcarpet.hydroponist.equipment;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class Lamp {

    public Lamp(
            int lm_production,
            double t_add,
            Image image_lamp_on,
            Image image_lamp_off,
            Image image_light_on,
            Image image_light_off,
            Image item_icon
    ){
        on = true;

        this.image_lamp_on = image_lamp_on;
        this.image_lamp_off = image_lamp_off;
        this.image_light_on = image_light_on;
        this.image_light_off = image_light_off;
        this.item_icon = item_icon;


        lm = lm_production;
        this.lm_production = lm_production;
        this.t_add = t_add;
    }

    double t_add;

    private boolean on;
    public synchronized void set_on(){
        on = true;
    }
    public synchronized void set_off(){
        on = false;
    }
    public synchronized void set_on_off(){
        if(on) on = false;
        else on = true;
    }

    private int lm;
    private int lm_production;

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
    public int getLm() {
        return lm;
    }
    public int getLm_production() {
        if(on) return lm_production;
        else return 0;
    }
    public double getT_add() {
        if(!on) return 0;
        return t_add;
    }

    public abstract String name();
    public abstract String description();

    private Image item_icon;

    private Image image_lamp_on;
    private Image image_lamp_off;

    private Image image_light_on;
    private Image image_light_off;

    public Image get_image_item(){
        return item_icon;
    }
    public Image get_image_lamp(){
        if(isOn()) return image_lamp_on;
        else return image_lamp_off;
    }
    public Image get_image_light(){
        if (isOn()) return image_light_on;
        else return image_light_off;
    }

    @Override
    public String toString() {
        return "Lamp{"+name()+"}";
    }
}
