package com.acidcarpet.hydroponist.equipment;

import com.acidcarpet.hydroponist.Elements;
import com.acidcarpet.hydroponist.storage.Buyable;
import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bottle implements Storable, Buyable {
    public Bottle(
            String name,
            String description,

            int gold_price,
            int diamond_price,

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

        this.gold_price = gold_price;
        this.diamond_price = diamond_price;

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


    public synchronized void drop_to_pot(double volume){
        if(current_volume==0)return;

        if(current_volume>=volume){
            Box.getInstance().getPot().pour(
                    volume,
                    pH,
                    (int)(percent_N*10000),
                    (int)(percent_P*10000),
                    (int)(percent_K*10000),
                    (int)(percent_S*10000),
                    (int)(percent_Mg*10000),
                    (int)(percent_Ca*10000),
                    (int)(percent_B*10000),
                    (int)(percent_Cu*10000),
                    (int)(percent_Fe*10000),
                    (int)(percent_Mn*10000),
                    (int)(percent_Mo*10000),
                    (int)(percent_Zn*10000)
            );
            current_volume-=volume;
        }else{
            Box.getInstance().getPot().pour(
                    current_volume,
                    pH,
                    (int)(percent_N*10000),
                    (int)(percent_P*10000),
                    (int)(percent_K*10000),
                    (int)(percent_S*10000),
                    (int)(percent_Mg*10000),
                    (int)(percent_Ca*10000),
                    (int)(percent_B*10000),
                    (int)(percent_Cu*10000),
                    (int)(percent_Fe*10000),
                    (int)(percent_Mn*10000),
                    (int)(percent_Mo*10000),
                    (int)(percent_Zn*10000)
            );
            current_volume=0;
        }
    }

    private String name;
    private String description;

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

    @Override
    public Buyable get_new_this() {
        return  new Bottle(
                name,
                description,

                gold_price,
                diamond_price,

                maximum_volume,
                pH,

                percent_N,
                percent_P,
                percent_K,

                percent_S,
                percent_Mg,
                percent_Ca,

                percent_B,
                percent_Cu,
                percent_Fe,

                percent_Mn,
                percent_Mo,
                percent_Zn,

                bottle_icon
        );
    }

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

    private Image bottle_icon;
    public Image get_bottle_icon() {
        return bottle_icon;
    }

    public Elements macro_main(){
        if(percent_N>percent_P&&percent_N>percent_K) return Elements.N;
        if(percent_P>percent_N&&percent_P>percent_K) return Elements.P;
        if(percent_K>percent_N&&percent_K>percent_P) return Elements.K;

        return Elements.EMPTY;
    }
    public Elements macro_secondary(){
        if(percent_S>percent_Mg&&percent_S>percent_Ca) return Elements.S;
        if(percent_Mg>percent_S&&percent_Mg>percent_Ca) return Elements.Mg;
        if(percent_Ca>percent_S&&percent_Ca>percent_Mg) return Elements.Ca;

        return Elements.EMPTY;
    }
    public Elements micro_main(){
        if(percent_B>percent_Cu&&percent_B>percent_Fe) return Elements.B;
        if(percent_Cu>percent_B&&percent_Cu>percent_Fe) return Elements.Cu;
        if(percent_Fe>percent_B&&percent_Fe>percent_Cu) return Elements.Fe;

        return Elements.EMPTY;
    }
    public Elements micro_secondary(){
        if(percent_Mn>percent_Mo&&percent_Mn>percent_Zn) return Elements.Mn;
        if(percent_Mo>percent_Mn&&percent_Mo>percent_Zn) return Elements.Mo;
        if(percent_Zn>percent_Mn&&percent_Zn>percent_Mo) return Elements.Zn;

        return Elements.EMPTY;
    }

    @Override
    public String toString() {
        return "BOTTLE";
    }
}
