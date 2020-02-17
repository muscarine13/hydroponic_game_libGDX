package com.acidcarpet.hydroponist.equipment;


import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class Pot {

    public Pot(
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



            Image image_pot
    ) {

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
    }

    double maximum_volume;
    double current_volume;

    double current_t;
    double current_pH;

    private double ELEMENT_N;
    public double element_volume_in_volume_N(double volume){
        double percent = ELEMENT_N/total_volume();
        return volume*percent;
    }
    public int element_ppm_N(){
        return (int)
                (
                (element_volume_in_volume_N(current_volume)/current_volume)
                *
                100
                )
                *
                1000;
    }

    private double ELEMENT_P;
    public double element_volume_in_volume_P(double volume){
        double percent = ELEMENT_P/total_volume();
        return volume*percent;
    }
    public int element_ppm_P(){
        return (int)
                (
                        (element_volume_in_volume_P(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_K;
    public double element_volume_in_volume_K(double volume){
        double percent = ELEMENT_K/total_volume();
        return volume*percent;
    }
    public int element_ppm_K(){
        return (int)
                (
                        (element_volume_in_volume_K(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_S;
    public double element_volume_in_volume_S(double volume){
        double percent = ELEMENT_S/total_volume();
        return volume*percent;
    }
    public int element_ppm_S(){
        return (int)
                (
                        (element_volume_in_volume_S(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_Mg;
    public double element_volume_in_volume_Mg(double volume){
        double percent = ELEMENT_Mg/total_volume();
        return volume*percent;
    }
    public int element_ppm_Mg(){
        return (int)
                (
                        (element_volume_in_volume_Mg(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_Ca;
    public double element_volume_in_volume_Ca(double volume){
        double percent = ELEMENT_Ca/total_volume();
        return volume*percent;
    }
    public int element_ppm_Ca(){
        return (int)
                (
                        (element_volume_in_volume_Ca(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_B;
    public double element_volume_in_volume_B(double volume){
        double percent = ELEMENT_B/total_volume();
        return volume*percent;
    }
    public int element_ppm_B(){
        return (int)
                (
                        (element_volume_in_volume_B(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_Cu;
    public double element_volume_in_volume_Cu(double volume){
        double percent = ELEMENT_Cu/total_volume();
        return volume*percent;
    }
    public int element_ppm_Cu(){
        return (int)
                (
                        (element_volume_in_volume_Cu(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_Fe;
    public double element_volume_in_volume_Fe(double volume){
        double percent = ELEMENT_Fe/total_volume();
        return volume*percent;
    }
    public int element_ppm_Fe(){
        return (int)
                (
                        (element_volume_in_volume_Fe(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_Mn;
    public double element_volume_in_volume_Mn(double volume){
        double percent = ELEMENT_Mn/total_volume();
        return volume*percent;
    }
    public int element_ppm_Mn(){
        return (int)
                (
                        (element_volume_in_volume_Mn(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_Mo;
    public double element_volume_in_volume_Mo(double volume){
        double percent = ELEMENT_Mo/total_volume();
        return volume*percent;
    }
    public int element_ppm_Mo(){
        return (int)
                (
                        (element_volume_in_volume_Mo(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    private double ELEMENT_Zn;
    public double element_volume_in_volume_Zn(double volume){
        double percent = ELEMENT_Zn/total_volume();
        return volume*percent;
    }
    public int element_ppm_Zn(){
        return (int)
                (
                        (element_volume_in_volume_Zn(current_volume)/current_volume)
                                *
                                100
                )
                        *
                        1000;
    }

    public WaterPack consume_elements_with_water(double volume){
        if(current_volume>=volume){

            WaterPack out = new WaterPack(
                    volume,
                    current_t,
                    current_pH,
                   element_volume_in_volume_N(volume),
            element_volume_in_volume_K(volume),
            element_volume_in_volume_B(volume),
            element_volume_in_volume_Ca(volume),
            element_volume_in_volume_Cu(volume),
            element_volume_in_volume_Fe(volume),
            element_volume_in_volume_Mn(volume),
            element_volume_in_volume_Mo(volume),
            element_volume_in_volume_Zn(volume),
            element_volume_in_volume_P(volume),
            element_volume_in_volume_Mg(volume),
            element_volume_in_volume_S(volume)
            );

            ELEMENT_N-=element_volume_in_volume_N(volume);
            ELEMENT_K-=element_volume_in_volume_K(volume);
            ELEMENT_B-=element_volume_in_volume_B(volume);
            ELEMENT_Ca-=element_volume_in_volume_Ca(volume);
            ELEMENT_Cu-=element_volume_in_volume_Cu(volume);
            ELEMENT_Fe-=element_volume_in_volume_Fe(volume);
            ELEMENT_Mn-=element_volume_in_volume_Mn(volume);
            ELEMENT_Mo-=element_volume_in_volume_Mo(volume);
            ELEMENT_Zn-=element_volume_in_volume_Zn(volume);
            ELEMENT_P-=element_volume_in_volume_P(volume);
            ELEMENT_Mg-=element_volume_in_volume_Mg(volume);
            ELEMENT_S-=element_volume_in_volume_S(volume);
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

    public abstract String name();
    public abstract String description();

    Image image_pot;
    public Image get_image_pot(){
        return image_pot;
    }


}
