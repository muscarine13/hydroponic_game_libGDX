package com.acidcarpet.hydroponist.equipment;

import com.acidcarpet.hydroponist.storage.Storable;

public class WaterPack implements Storable {

    public WaterPack(
            double water_volume,
            double current_pH,
            int ELEMENT_N,
            int ELEMENT_P,
            int ELEMENT_K,
            int ELEMENT_S,
            int ELEMENT_Mg,
            int ELEMENT_Ca,
            int ELEMENT_B,
            int ELEMENT_Cu,
            int ELEMENT_Fe,
            int ELEMENT_Mn,
            int ELEMENT_Mo,
            int ELEMENT_Zn
    ) {
        this.current_volume = water_volume;
        this.current_pH = current_pH;

        this.ELEMENT_N = ELEMENT_N;
        this.ELEMENT_K = ELEMENT_K;
        this.ELEMENT_B = ELEMENT_B;
        this.ELEMENT_Ca = ELEMENT_Ca;
        this.ELEMENT_Cu = ELEMENT_Cu;
        this.ELEMENT_Fe = ELEMENT_Fe;
        this.ELEMENT_Mn = ELEMENT_Mn;
        this.ELEMENT_Mo = ELEMENT_Mo;
        this.ELEMENT_Zn = ELEMENT_Zn;
        this.ELEMENT_P = ELEMENT_P;
        this.ELEMENT_Mg = ELEMENT_Mg;
        this.ELEMENT_S = ELEMENT_S;
    }

    double current_volume;
    double current_pH;

    private int ELEMENT_N;
    public int element_ppm_N(){
        return ELEMENT_N;

    }

    private int ELEMENT_P;
    public int element_ppm_P(){
        return ELEMENT_P;
    }

    private int ELEMENT_K;
    public int element_ppm_K(){
        return ELEMENT_K;
    }

    private int ELEMENT_S;
    public int element_ppm_S(){
        return ELEMENT_S;
    }

    private int ELEMENT_Mg;
    public int element_ppm_Mg(){
        return ELEMENT_Mg;
    }

    private int ELEMENT_Ca;
    public int element_ppm_Ca(){
        return ELEMENT_Ca;
    }

    private int ELEMENT_B;
    public int element_ppm_B(){
        return ELEMENT_B;
    }

    private int ELEMENT_Cu;
    public int element_ppm_Cu(){
        return ELEMENT_Cu;
    }

    private int ELEMENT_Fe;
    public int element_ppm_Fe(){
        return ELEMENT_Fe;
    }

    private int ELEMENT_Mn;
    public int element_ppm_Mn(){
        return ELEMENT_Mn;
    }

    private int ELEMENT_Mo;
    public int element_ppm_Mo(){
        return ELEMENT_Mo;
    }

    private int ELEMENT_Zn;
    public int element_ppm_Zn(){
        return ELEMENT_Zn;
    }

    public double total_volume(){
        double out;
        out = current_volume +elements_volume();

        return out;
    }
    public int get_all_ppm(){
        return
                element_ppm_N()+
                        element_ppm_P()+
                        element_ppm_K()+
                        element_ppm_S()+
                        element_ppm_Mg()+
                        element_ppm_Ca()+
                        element_ppm_B()+
                        element_ppm_Cu()+
                        element_ppm_Fe()+
                        element_ppm_Mn()+
                        element_ppm_Mo()+
                        element_ppm_Zn()
                ;
    }
    public double elements_volume(){
        double out = 0;
        out+=

                ELEMENT_N+
                        ELEMENT_K+
                        ELEMENT_B+
                        ELEMENT_Ca+
                        ELEMENT_Cu+
                        ELEMENT_Fe+
                        ELEMENT_Mn+
                        ELEMENT_Mo+
                        ELEMENT_Zn+
                        ELEMENT_P+
                        ELEMENT_Mg+
                        ELEMENT_S;
        return out;

    }

    public double getWater_volume() {
        return current_volume;
    }
    public double getCurrent_pH() {
        return current_pH;
    }
    public double getELEMENT_N() {
        return ELEMENT_N;
    }
    public double getELEMENT_K() {
        return ELEMENT_K;
    }
    public double getELEMENT_B() {
        return ELEMENT_B;
    }
    public double getELEMENT_Ca() {
        return ELEMENT_Ca;
    }
    public double getELEMENT_Cu() {
        return ELEMENT_Cu;
    }
    public double getELEMENT_Fe() {
        return ELEMENT_Fe;
    }
    public double getELEMENT_Mn() {
        return ELEMENT_Mn;
    }
    public double getELEMENT_Mo() {
        return ELEMENT_Mo;
    }
    public double getELEMENT_Zn() {
        return ELEMENT_Zn;
    }
    public double getELEMENT_P() {
        return ELEMENT_P;
    }
    public double getELEMENT_Mg() {
        return ELEMENT_Mg;
    }
    public double getELEMENT_S() {
        return ELEMENT_S;
    }
}
