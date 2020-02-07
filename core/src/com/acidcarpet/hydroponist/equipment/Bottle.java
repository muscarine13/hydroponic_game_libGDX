package com.acidcarpet.hydroponist.equipment;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class Bottle {
    public Bottle(double maximum_volume, double t, double pH, double water_volume, double ELEMENT_N, double ELEMENT_K, double ELEMENT_B, double ELEMENT_Ca, double ELEMENT_Cu, double ELEMENT_Fe, double ELEMENT_Mn, double ELEMENT_Mo, double ELEMENT_Zn, double ELEMENT_P, double ELEMENT_Mg, double ELEMENT_S) {
        this.maximum_volume = maximum_volume;
        this.t = t;
        this.pH = pH;
        this.water_volume = water_volume;

        this.ELEMENT_N = ELEMENT_N;
        this.ELEMENT_P = ELEMENT_P;
        this.ELEMENT_K = ELEMENT_K;

        this.ELEMENT_S = ELEMENT_S;
        this.ELEMENT_Mg = ELEMENT_Mg;
        this.ELEMENT_Ca = ELEMENT_Ca;

        this.ELEMENT_B = ELEMENT_B;
        this.ELEMENT_Cu = ELEMENT_Cu;
        this.ELEMENT_Fe = ELEMENT_Fe;
        this.ELEMENT_Mn = ELEMENT_Mn;
        this.ELEMENT_Mo = ELEMENT_Mo;
        this.ELEMENT_Zn = ELEMENT_Zn;



    }

    double maximum_volume;

    private double t;
    private double pH;

    private double water_volume;

    private double ELEMENT_N;
    public double element_in_volume_N(double volume){
        double percent = ELEMENT_N/total_volume();
        return volume*percent;
    }
    private double ELEMENT_P;
    public double element_in_volume_P(double volume){
        double percent = ELEMENT_P/total_volume();
        return volume*percent;
    }
    private double ELEMENT_K;
    public double element_in_volume_K(double volume){
        double percent = ELEMENT_K/total_volume();
        return volume*percent;
    }


    private double ELEMENT_B;
    public double element_in_volume_B(double volume){
        double percent = ELEMENT_B/total_volume();
        return volume*percent;
    }
    private double ELEMENT_Ca;
    public double element_in_volume_Ca(double volume){
        double percent = ELEMENT_Ca/total_volume();
        return volume*percent;
    }
    private double ELEMENT_Cu;
    public double element_in_volume_Cu(double volume){
        double percent = ELEMENT_Cu/total_volume();
        return volume*percent;
    }
    private double ELEMENT_Fe;
    public double element_in_volume_Fe(double volume){
        double percent = ELEMENT_Fe/total_volume();
        return volume*percent;
    }
    private double ELEMENT_Mn;
    public double element_in_volume_Mn(double volume){
        double percent = ELEMENT_Mn/total_volume();
        return volume*percent;
    }
    private double ELEMENT_Mo;
    public double element_in_volume_Mo(double volume){
        double percent = ELEMENT_Mo/total_volume();
        return volume*percent;
    }
    private double ELEMENT_Zn;
    public double element_in_volume_Zn(double volume){
        double percent = ELEMENT_Zn/total_volume();
        return volume*percent;
    }

    private double ELEMENT_Mg;
    public double element_in_volume_Mg(double volume){
        double percent = ELEMENT_Mg/total_volume();
        return volume*percent;
    }
    private double ELEMENT_S;
    public double element_in_volume_S(double volume){
        double percent = ELEMENT_S/total_volume();
        return volume*percent;
    }

    public WaterPack drain(double volume_to_pack){
        if(volume_to_pack<=total_volume()){
            WaterPack out = new WaterPack(
            volume_to_pack-(
                    element_in_volume_N(volume_to_pack)+
                    element_in_volume_K(volume_to_pack)+
                    element_in_volume_B(volume_to_pack)+
                    element_in_volume_Ca(volume_to_pack)+
                    element_in_volume_Cu(volume_to_pack)+
                    element_in_volume_Fe(volume_to_pack)+
                    element_in_volume_Mn(volume_to_pack)+
                    element_in_volume_Mo(volume_to_pack)+
                    element_in_volume_Zn(volume_to_pack)+
                    element_in_volume_P(volume_to_pack)+
                    element_in_volume_Mg(volume_to_pack)+
                    element_in_volume_S(volume_to_pack)),
            t,
            pH,
                    element_in_volume_N(volume_to_pack),
                    element_in_volume_K(volume_to_pack),
                    element_in_volume_B(volume_to_pack),
                    element_in_volume_Ca(volume_to_pack),
                    element_in_volume_Cu(volume_to_pack),
                    element_in_volume_Fe(volume_to_pack),
                    element_in_volume_Mn(volume_to_pack),
                    element_in_volume_Mo(volume_to_pack),
                    element_in_volume_Zn(volume_to_pack),
                    element_in_volume_P(volume_to_pack),
                    element_in_volume_Mg(volume_to_pack),
                    element_in_volume_S(volume_to_pack)
            );

            water_volume-=
                    (element_in_volume_N(volume_to_pack)+
                    element_in_volume_K(volume_to_pack)+
                    element_in_volume_B(volume_to_pack)+
                    element_in_volume_Ca(volume_to_pack)+
                    element_in_volume_Cu(volume_to_pack)+
                    element_in_volume_Fe(volume_to_pack)+
                    element_in_volume_Mn(volume_to_pack)+
                    element_in_volume_Mo(volume_to_pack)+
                    element_in_volume_Zn(volume_to_pack)+
                    element_in_volume_P(volume_to_pack)+
                    element_in_volume_Mg(volume_to_pack)+
                    element_in_volume_S(volume_to_pack));

            ELEMENT_N-=element_in_volume_N(volume_to_pack);
            ELEMENT_K-=element_in_volume_K(volume_to_pack);
            ELEMENT_B-=element_in_volume_B(volume_to_pack);
            ELEMENT_Ca-=element_in_volume_Ca(volume_to_pack);
            ELEMENT_Cu-=element_in_volume_Cu(volume_to_pack);
            ELEMENT_Fe-=element_in_volume_Fe(volume_to_pack);
            ELEMENT_Mn-=element_in_volume_Mn(volume_to_pack);
            ELEMENT_Mo-=element_in_volume_Mo(volume_to_pack);
            ELEMENT_Zn-=element_in_volume_Zn(volume_to_pack);
            ELEMENT_P-=element_in_volume_P(volume_to_pack);
            ELEMENT_Mg-=element_in_volume_Mg(volume_to_pack);
            ELEMENT_S-=element_in_volume_S(volume_to_pack);

            return out;
        }
        return null;
    }

    abstract String name();
    abstract String description();
    abstract Image inventory_image();

    public double total_volume(){
        double out;
        out = water_volume+elements_volume();

        return out;
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



}
