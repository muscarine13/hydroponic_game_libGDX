package com.acidcarpet.hydroponist.bottle;

import com.acidcarpet.hydroponist.storage.Storable;

public class Bottle implements Storable {


    PH_TYPE ph_type;

    public String name(){

        String out;

        out = volumeType.latin+" "+macroSecondaryType.latin+" "+macroPrimaryType.latin+" continet "+microPrimaryType.latin+" "+microSecondaryType.latin+" ("+purityType.latin+")";

        return out;

    }

    public String description(){

        String out = "";

        switch (purityType){
            case PERCENT_10: out+="Непригодное";break;
            case PERCENT_20: out+="Грязное";break;
            case PERCENT_30: out+="Загрязненное";break;
            case PERCENT_40: out+="Техническое";break;
            case PERCENT_50: out+="Очищенное";break;
            case PERCENT_60: out+="Лабораторное";break;
            case PERCENT_70: out+="Чистое";break;
            case PERCENT_80: out+="Чистое специальное";break;
            case PERCENT_95: out+="Абсолютное";break;

        }

        switch (macroPrimaryType){
            case N: out+=" питательное удобрение";break;
            case P: out+=" удобрение для цветения";break;
            case K: out+=" удобрение для вегетации";break;
            case D: out+=" вспомогательное удобрение";break;
        }

        switch (macroSecondaryType){
            case S:out+=" на основе серы";break;
            case Mg:out+=" на основе магния";break;
            case Ca:out+=" на основе кальция";break;
            case D: out+=" на водной основе";break;
        }

        out+=" c содержанием";

        switch (microPrimaryType){
            case B:out+=" бора";break;
            case Cu:out+=" меди";break;
            case Fe:out+=" железа";break;
            case D:out+=" набора кислот";break;
        }

        out+=" и";

        switch (microSecondaryType){
            case Mn:out+=" марганца";break;
            case Mo:out+=" молибдена";break;
            case Zn:out+=" цинка";break;
            case D:out+=" набора оснований";break;
        }

        out+=" объемом";

        switch (volumeType){
            case VOLUME_100:out+=" 100 мл.";break;
            case VOLUME_500:out+=" 500 мл.";break;
            case VOLUME_1000:out+=" 1000 мл.";break;
            case VOLUME_2500:out+=" 2500 мл.";break;
            case VOLUME_5000:out+=" 5000 мл.";break;
        }






        return out;

    }


    private VolumeType volumeType;
    private PurityType purityType;

    private MacroPrimaryType macroPrimaryType;
    private MacroSecondaryType macroSecondaryType;
    private MicroPrimaryType microPrimaryType;
    private MicroSecondaryType microSecondaryType;

    public Bottle(VolumeType volumeType, PurityType purityType, MacroPrimaryType macroPrimaryType, MacroSecondaryType macroSecondaryType, MicroPrimaryType microPrimaryType, MicroSecondaryType microSecondaryType) {
        this.volumeType = volumeType;
        this.purityType = purityType;
        this.macroPrimaryType = macroPrimaryType;
        this.macroSecondaryType = macroSecondaryType;
        this.microPrimaryType = microPrimaryType;
        this.microSecondaryType = microSecondaryType;

        current_volume = volumeType.volume;

        double macro_primary_percent = macroPrimaryType.volume;
        double macro_secondary_percent = macroSecondaryType.volume;
        double micro_primary_percent = microPrimaryType.volume;
        double micro_secondary_percent = microSecondaryType.volume;

        int all_ppm = 1000000;

        double purity_multiplier = purityType.percent;

        int ppm_after_purify = (int)(all_ppm*purity_multiplier);

        int macro_primary_group_ppm =(int)(ppm_after_purify * macro_primary_percent);
        int macro_secondary_group_ppm =(int)(ppm_after_purify * macro_secondary_percent);
        int micro_primary_group_ppm =(int)(ppm_after_purify * micro_primary_percent);
        int micro_secondary_group_ppm =(int)(ppm_after_purify * micro_secondary_percent);

        ppm_N = (int)(macro_primary_group_ppm*macroPrimaryType.N_percent);
        ppm_P = (int)(macro_primary_group_ppm*macroPrimaryType.P_percent);
        ppm_K = (int)(macro_primary_group_ppm*macroPrimaryType.K_percent);

        ppm_S = (int)(macro_secondary_group_ppm*macroSecondaryType.S_percent);
        ppm_Mg = (int)(macro_secondary_group_ppm*macroSecondaryType.Mg_percent);
        ppm_Ca = (int)(macro_secondary_group_ppm*macroSecondaryType.Ca_percent);



        if(microPrimaryType.equals(MicroPrimaryType.D)){
            ppm_B = 0;
            ppm_Cu = 0;
            ppm_Fe = 0;
            ph_type = PH_TYPE.ACCIDUM;
        }else{
            ppm_B = (int)(micro_primary_group_ppm*microPrimaryType.B_percent);
            ppm_Cu = (int)(micro_primary_group_ppm*microPrimaryType.Cu_percent);
            ppm_Fe = (int)(micro_primary_group_ppm*microPrimaryType.Fe_percent);
            ph_type = PH_TYPE.NEUTRAL;
        }

        if(microSecondaryType.equals(MicroSecondaryType.D)){
            ppm_Mn = 0;
            ppm_Mo = 0;
            ppm_Zn = 0;
            ph_type = PH_TYPE.ALCALINE;
        }else{
            ppm_Mn = (int)(micro_secondary_group_ppm*microSecondaryType.Mn_percent);
            ppm_Mo = (int)(micro_secondary_group_ppm*microSecondaryType.Mo_percent);
            ppm_Zn = (int)(micro_secondary_group_ppm*microSecondaryType.Zn_percent);
            ph_type = PH_TYPE.NEUTRAL;
        }

        if(microPrimaryType.equals(MicroPrimaryType.D)&&microSecondaryType.equals(MicroSecondaryType.D)){
            ph_type = PH_TYPE.NEUTRAL;
        }
    }

    private int current_volume;
    public boolean drain(){
        if(current_volume<=0) {
            current_volume = 0;
            return false;
        }
        else{
            current_volume--;
            return true;
        }
    }

    private int ppm_N;
    private int ppm_P;
    private int ppm_K;

    private int ppm_S;
    private int ppm_Mg;
    private int ppm_Ca;

    private int ppm_B;
    private int ppm_Cu;
    private int ppm_Fe;

    private int ppm_Mn;
    private int ppm_Mo;
    private int ppm_Zn;

    private double pH;

    enum PH_TYPE{
        ACCIDUM,
        NEUTRAL,
        ALCALINE
    }

    public PH_TYPE getPh_type() {
        return ph_type;
    }

    public VolumeType getVolumeType() {
        return volumeType;
    }

    public PurityType getPurityType() {
        return purityType;
    }

    public MacroPrimaryType getMacroPrimaryType() {
        return macroPrimaryType;
    }

    public MacroSecondaryType getMacroSecondaryType() {
        return macroSecondaryType;
    }

    public MicroPrimaryType getMicroPrimaryType() {
        return microPrimaryType;
    }

    public MicroSecondaryType getMicroSecondaryType() {
        return microSecondaryType;
    }

    public int getCurrent_volume() {
        return current_volume;
    }

    public int getPpm_N() {
        return ppm_N;
    }

    public int getPpm_P() {
        return ppm_P;
    }

    public int getPpm_K() {
        return ppm_K;
    }

    public int getPpm_S() {
        return ppm_S;
    }

    public int getPpm_Mg() {
        return ppm_Mg;
    }

    public int getPpm_Ca() {
        return ppm_Ca;
    }

    public int getPpm_B() {
        return ppm_B;
    }

    public int getPpm_Cu() {
        return ppm_Cu;
    }

    public int getPpm_Fe() {
        return ppm_Fe;
    }

    public int getPpm_Mn() {
        return ppm_Mn;
    }

    public int getPpm_Mo() {
        return ppm_Mo;
    }

    public int getPpm_Zn() {
        return ppm_Zn;
    }

    public double getpH() {
        return pH;
    }
}
