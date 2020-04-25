package com.acidcarpet.hydroponist.ref.bottle;

public class Bottle {


    PH_TYPE ph_type;


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

        if(microPrimaryType.equals(MicroPrimaryType.D)&&microSecondaryType.equals(MicroSecondaryType.D){
            ph_type = PH_TYPE.NEUTRAL;
        }
    }

    private int current_volume;
    private boolean drain(){
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
}
