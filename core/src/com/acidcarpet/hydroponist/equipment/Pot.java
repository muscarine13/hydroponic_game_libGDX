package com.acidcarpet.hydroponist.equipment;


import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pot implements Storable {

    public void pour(
            double volume,

            double pH,

            int ppm_N,
            int ppm_P,
            int ppm_K,

            int ppm_S,
            int ppm_Mg,
            int ppm_Ca,

            int ppm_B,
            int ppm_Cu,
            int ppm_Fe,

            int ppm_Mn,
            int ppm_Mo,
            int ppm_Zn
    ){

        this.pH = ((this.pH*this.current_volume) +(pH*volume)) /(current_volume+volume);

        this.N =(int) (((this.N*this.current_volume)   + (ppm_N*volume)) / (current_volume+volume));
        this.P =(int) (((this.P*this.current_volume)   + (ppm_P*volume)) / (current_volume+volume));
        this.K =(int) (((this.K*this.current_volume)   + (ppm_K*volume)) / (current_volume+volume));
        this.S =(int) (((this.S*this.current_volume)   + (ppm_S*volume)) / (current_volume+volume));
        this.Mg =(int) (((this.Mg*this.current_volume) + (ppm_Mg*volume)) / (current_volume+volume));
        this.Ca =(int) (((this.Ca*this.current_volume) + (ppm_Ca*volume)) / (current_volume+volume));
        this.B =(int) (((this.B*this.current_volume)   + (ppm_B*volume))  / (current_volume+volume));
        this.Cu =(int) (((this.Cu*this.current_volume) + (ppm_Cu*volume)) / (current_volume+volume));
        this.Fe =(int) (((this.Fe*this.current_volume) + (ppm_Fe*volume)) / (current_volume+volume));
        this.Mn =(int) (((this.Mn*this.current_volume) + (ppm_Mn*volume)) / (current_volume+volume));
        this.Mo =(int) (((this.Mo*this.current_volume) + (ppm_Mo*volume)) / (current_volume+volume));
        this.Zn =(int)(((this.Zn*this.current_volume)  + (ppm_Zn*volume)) / (current_volume+volume));

        current_volume=current_volume+volume;
        if (current_volume>maximum_volume)current_volume=maximum_volume;
        Box.update();

    }
    public synchronized void drain(double volume){
        current_volume=round(current_volume-volume, 10);
        if(current_volume<0) {
            current_volume=0;
            pH=0;
            N=0;
            P=0;
            K=0;

            S=0;
            Mg=0;
            Ca=0;

            B=0;
            Cu=0;
            Fe=0;

            Mn=0;
            Mo=0;
            Zn=0;
        }
        Box.update();
    }

    public Pot(
            String name,
            String description,
            double maximum_volume,

            int gold_price,
            int diamond_price,

            Image image_pot,
            Image icon_pot
    ) {

        this.name = name;
        this.description = description;

        this.maximum_volume = maximum_volume;
        this.current_volume = 0;

        this.gold_price = gold_price;
        this.diamond_price = diamond_price;

        this.pH = 0;
        this.N = 0;
        this.K = 0;
        this.B = 0;
        this.Ca = 0;
        this.Cu = 0;
        this.Fe = 0;
        this.Mn = 0;
        this.Mo = 0;
        this.Zn = 0;
        this.P = 0;
        this.Mg = 0;
        this.S = 0;

        this.image_pot = image_pot;
        this.icon_pot = icon_pot;
    }

    private String name;
    private String description;
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
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

    private double maximum_volume;
    private double current_volume;

    private double pH;

    private int N;
    private int P;
    private int K;
    private int S;
    private int Mg;
    private int Ca;
    private int B;
    private int Cu;
    private int Fe;
    private int Mn;
    private int Mo;
    private int Zn;
    public int getN() {
        return N;
    }
    public int getP() {
        return P;
    }
    public int getK() {
        return K;
    }
    public int getS() {
        return S;
    }
    public int getMg() {
        return Mg;
    }
    public int getCa() {
        return Ca;
    }
    public int getB() {
        return B;
    }
    public int getCu() {
        return Cu;
    }
    public int getFe() {
        return Fe;
    }
    public int getMn() {
        return Mn;
    }
    public int getMo() {
        return Mo;
    }
    public int getZn() {
        return Zn;
    }

    public double getMaximum_volume() {
        return maximum_volume;
    }
    public double getCurrent_volume() {
        return current_volume;
    }
    public double getCurrent_pH() {
        return pH;
    }

    public int get_all_ppm(){
        return
                        N+
                        P+
                        K+
                        S+
                        Mg+
                        Ca+
                        B+
                        Cu+
                        Fe+
                        Mn+
                        Mo+
                        Zn;
    }

    Image image_pot;
    Image icon_pot;
    public Image get_image_pot(){
        return image_pot;
    }
    public Image get_icon_pot(){
        return icon_pot;
    }

    @Override
    public String toString() {
        return "POT";
    }

    public String getInfo(){
        return name+" --- "+getMaximum_volume();
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
