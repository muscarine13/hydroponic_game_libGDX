package com.acidcarpet.hydroponist.equipment;


import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pot implements Storable {

    public boolean may_add(double volume){
        return true;
    }
    public boolean add_from_bottle(Bottle bottle, double volume){
        return true;
    }

    public boolean may_drain(double volume){
        return true;
    }
    public boolean drain(double volume){
        if(may_drain(volume)){

        }else{

        }
        return true;
    }

    public Pot(
            String name,
            String description,
            double maximum_volume,
            double current_volume,
            double current_t,
            double current_pH,

            double ELEMENT_N,
            double ELEMENT_P,
            double ELEMENT_K,

            double ELEMENT_S,
            double ELEMENT_Mg,
            double ELEMENT_Ca,

            double ELEMENT_B,
            double ELEMENT_Cu,
            double ELEMENT_Fe,
            double ELEMENT_Mn,
            double ELEMENT_Mo,
            double ELEMENT_Zn,

            Image image_pot,
            Image icon_pot
    ) {

        this.name = name;
        this.description = description;
        this.maximum_volume = maximum_volume;
        this.current_volume = current_volume;
        this.current_t = current_t;
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

    private double maximum_volume;
    private double current_volume;

    private double current_t;
    private double current_pH;

    private double ELEMENT_N;
    public int element_ppm_N(){
        return (int)
                ((
                (ELEMENT_N/current_volume)
                *
                100
                )
                *
                10000);
    }

    private double ELEMENT_P;
    public int element_ppm_P(){
        return (int)
                ((
                        (ELEMENT_P/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_K;
    public int element_ppm_K(){
        return (int)
                ((
                        (ELEMENT_K/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_S;
    public int element_ppm_S(){
        return (int)
                ((
                        (ELEMENT_S/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_Mg;
    public int element_ppm_Mg(){
        return (int)
                ((
                        (ELEMENT_Mg/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_Ca;
    public int element_ppm_Ca(){
        return (int)
                ((
                        (ELEMENT_Ca/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_B;
    public int element_ppm_B(){
        return (int)
                ((
                        (ELEMENT_B/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_Cu;
    public int element_ppm_Cu(){
        return (int)
                ((
                        (ELEMENT_Cu/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_Fe;
    public int element_ppm_Fe(){
        return (int)
                ((
                        (ELEMENT_Fe/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_Mn;
    public int element_ppm_Mn(){
        return (int)
                ((
                        (ELEMENT_Mn/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_Mo;
    public int element_ppm_Mo(){
        return (int)
                ((
                        (ELEMENT_Mo/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    private double ELEMENT_Zn;
    public int element_ppm_Zn(){
        return (int)
                ((
                        (ELEMENT_Zn/current_volume)
                                *
                                100
                )
                        *
                        10000);
    }

    public WaterPack consume_elements_with_water(double volume){
        if(current_volume>=volume){

            WaterPack out = new WaterPack(
                    volume,
                    current_t,
                    current_pH,
                   ELEMENT_N,
                    ELEMENT_K,
                    ELEMENT_B,
                    ELEMENT_Ca,
                    ELEMENT_Cu,
                    ELEMENT_Fe,
                    ELEMENT_Mn,
                    ELEMENT_Mo,
                    ELEMENT_Zn,
                    ELEMENT_P,
                    ELEMENT_Mg,
                    ELEMENT_S
            );

            ELEMENT_N-= ELEMENT_N;
            ELEMENT_K-= ELEMENT_K;
            ELEMENT_B-= ELEMENT_B;
            ELEMENT_Ca-= ELEMENT_Ca;
            ELEMENT_Cu-= ELEMENT_Cu;
            ELEMENT_Fe-= ELEMENT_Fe;
            ELEMENT_Mn-= ELEMENT_Mn;
            ELEMENT_Mo-= ELEMENT_Mo;
            ELEMENT_Zn-= ELEMENT_Zn;
            ELEMENT_P-= ELEMENT_P;
            ELEMENT_Mg-= ELEMENT_Mg;
            ELEMENT_S-= ELEMENT_S;
            current_volume-=volume;

            return out;
        }else{
            return null;
        }
    }
    public void fill(WaterPack waterPack){
        if(current_volume+waterPack.total_volume()<=maximum_volume){

            current_t = ((current_t*current_volume)+(waterPack.getCurrent_t()*waterPack.total_volume()))
                    /
                    (current_volume+total_volume());
            current_pH = ((current_pH*current_volume)+(waterPack.getCurrent_pH()*waterPack.total_volume()))
                    /
                    (current_volume+total_volume());


            current_volume += waterPack.getWater_volume();

            ELEMENT_N+=waterPack.getELEMENT_N();
            ELEMENT_K+=waterPack.getELEMENT_K();
            ELEMENT_B+=waterPack.getELEMENT_B();
            ELEMENT_Ca+=waterPack.getELEMENT_Ca();
            ELEMENT_Cu+=waterPack.getELEMENT_Cu();
            ELEMENT_Fe+=waterPack.getELEMENT_Fe();
            ELEMENT_Mn+=waterPack.getELEMENT_Mn();
            ELEMENT_Mo+=waterPack.getELEMENT_Mo();
            ELEMENT_Zn+=waterPack.getELEMENT_Zn();
            ELEMENT_P+=waterPack.getELEMENT_P();
            ELEMENT_Mg+=waterPack.getELEMENT_Mg();
            ELEMENT_S+=waterPack.getELEMENT_S();
        }
    }

    public double total_volume(){
        double out;
        out = current_volume+elements_volume();

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

    public double getMaximum_volume() {
        return maximum_volume;
    }
    public double getCurrent_volume() {
        return current_volume;
    }
    public double getCurrent_t() {
        return current_t;
    }
    public double getCurrent_pH() {
        return current_pH;
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
                        element_ppm_Zn();
    }

    Image image_pot;
    public Image get_image_pot(){
        return image_pot;
    }

    Image icon_pot;
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
}
