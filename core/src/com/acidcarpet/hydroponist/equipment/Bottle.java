package com.acidcarpet.hydroponist.equipment;

import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bottle implements Storable {
    public Bottle(
            String name,
            String description,

            double maximum_volume,
            double pH,

            int percent_N,
            int percent_P,
            int percent_K,

            int percent_S,
            int percent_Mg,
            int percent_Ca,

            int percent_B,
            int percent_Cu,
            int percent_Fe,

            int percent_Mn,
            int percent_Mo,
            int percent_Zn,

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


    public synchronized void drop(double volume){
        if(current_volume==0)return;

        if(current_volume>=volume){
            Box.getInstance().getPot().pour(
                    volume,
                    pH,
                    (percent_N*10000),
                    (percent_P*10000),
                    (percent_K*10000),
                    (percent_S*10000),
                    (percent_Mg*10000),
                    (percent_Ca*10000),
                    (percent_B*10000),
                    (percent_Cu*10000),
                    (percent_Fe*10000),
                    (percent_Mn*10000),
                    (percent_Mo*10000),
                    (percent_Zn*10000)
            );
            current_volume-=volume;
        }else{
            Box.getInstance().getPot().pour(
                    current_volume,
                    pH,
                    (percent_N*10000),
                    (percent_P*10000),
                    (percent_K*10000),
                    (percent_S*10000),
                    (percent_Mg*10000),
                    (percent_Ca*10000),
                    (percent_B*10000),
                    (percent_Cu*10000),
                    (percent_Fe*10000),
                    (percent_Mn*10000),
                    (percent_Mo*10000),
                    (percent_Zn*10000)
            );
            current_volume=0;
        }
    }

    private String name;
    private String description;

    private double maximum_volume;
    private double current_volume;

    private double pH;

    private int percent_N;
    private int percent_P;
    private int percent_K;

    private int percent_S;
    private int percent_Mg;
    private int percent_Ca;

    private int percent_B;
    private int percent_Cu;
    private int percent_Fe;

    private int percent_Mn;
    private int percent_Mo;
    private int percent_Zn;

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
    public int getPercent_N() {
        return percent_N;
    }
    public int getPercent_P() {
        return percent_P;
    }
    public int getPercent_K() {
        return percent_K;
    }
    public int getPercent_S() {
        return percent_S;
    }
    public int getPercent_Mg() {
        return percent_Mg;
    }
    public int getPercent_Ca() {
        return percent_Ca;
    }
    public int getPercent_B() {
        return percent_B;
    }
    public int getPercent_Cu() {
        return percent_Cu;
    }
    public int getPercent_Fe() {
        return percent_Fe;
    }
    public int getPercent_Mn() {
        return percent_Mn;
    }
    public int getPercent_Mo() {
        return percent_Mo;
    }
    public int getPercent_Zn() {
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
