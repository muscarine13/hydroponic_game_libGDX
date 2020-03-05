package com.acidcarpet.hydroponist.equipment;

import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bottle implements Storable {
    public Bottle(
            String name,
            String description,

            double maximum_volume,
            double pH,

            double percent_N,
            double percent_P,
            double percent_K,

            double percent_S,
            double percent_Mg,
            double percent_Ca,

            double percent_B,
            double percent_Cu,
            double percent_Fe,

            double percent_Mn,
            double percent_Mo,
            double percent_Zn,

            Image bottle_icon
    ) {
        this.maximum_volume = maximum_volume;
        this.current_volume = maximum_volume;
        this.pH = pH;

        this.percent_N = percent_N;
        this.percent_P = percent_P;
        this.percent_K = percent_K;

        this.percent_S = percent_S;
        this.percent_Mg = percent_Mg;
        this.percent_Ca = percent_Ca;

        this.percent_B = percent_B;
        this.percent_Cu = percent_Cu;
        this.percent_Fe = percent_Fe;
        this.percent_Mn = percent_Mn;
        this.percent_Mo = percent_Mo;
        this.percent_Zn = percent_Zn;

        this.bottle_icon  = bottle_icon;

        this.name = name;
        this.description = description;

    }

    public synchronized boolean may_drop(double volume){
        if(volume<=current_volume&&Box.getInstance().getPot()!=null&&Box.getInstance().getPot().may_add(volume)){
            return true;
        }else{
            return false;
        }
    }
    public synchronized boolean drop(double volume){
        if(may_drop(volume)){

            if(Box.getInstance().getPot().add_from_bottle(this, volume)){
                current_volume-=volume;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    private String name;
    private String description;

    private double maximum_volume;
    private double current_volume;

    private double pH;

    private double percent_N;
    private double percent_P;
    private double percent_K;

    private double percent_S;
    private double percent_Mg;
    private double percent_Ca;

    private double percent_B;
    private double percent_Cu;
    private double percent_Fe;

    private double percent_Mn;
    private double percent_Mo;
    private double percent_Zn;

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getMaximum_volume() {
        return maximum_volume;
    }
    public double getCurrent_volume() {
        return current_volume;
    }
    public double getpH() {
        return pH;
    }
    public double getPercent_N() {
        return percent_N;
    }
    public double getPercent_P() {
        return percent_P;
    }
    public double getPercent_K() {
        return percent_K;
    }
    public double getPercent_S() {
        return percent_S;
    }
    public double getPercent_Mg() {
        return percent_Mg;
    }
    public double getPercent_Ca() {
        return percent_Ca;
    }
    public double getPercent_B() {
        return percent_B;
    }
    public double getPercent_Cu() {
        return percent_Cu;
    }
    public double getPercent_Fe() {
        return percent_Fe;
    }
    public double getPercent_Mn() {
        return percent_Mn;
    }
    public double getPercent_Mo() {
        return percent_Mo;
    }
    public double getPercent_Zn() {
        return percent_Zn;
    }

    Image bottle_icon;
    public Image get_bottle_icon() {
        return bottle_icon;
    }

    @Override
    public String toString() {
        return "BOTTLE";
    }
}
