package com.acidcarpet.hydroponist.plant;


import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PlantStage {

    boolean active;
    private int remain;

    public void second(){
        if(!active) return;
        if(remain>0) remain--;
        else{
            active=false;
            remain=0;
        }
    }


    public PlantStage(
            PlantStages type,
            Image stage_alive_image,
            Image stage_dead_image,

            int LENGTH_MINIMUM,
            int LEAVES_ADD_MINIMUM,
            int ROOTS_ADD_MINIMUM,
            int PRODUCTS_ADD_MINIMUM,

            int ppm_N_MINIMUM,
            int ppm_P_MINIMUM,
            int ppm_K_MINIMUM,

            int ppm_S_MINIMUM,
            int ppm_Mg_MINIMUM,
            int ppm_Ca_MINIMUM,

            int ppm_B_MINIMUM,
            int ppm_Cu_MINIMUM,
            int ppm_Fe_MINIMUM,
            int ppm_Mn_MINIMUM,
            int ppm_Mo_MINIMUM,
            int ppm_Zn_MINIMUM,


            int LENGTH_MAXIMUM,
            int LEAVES_ADD_MAXIMUM,
            int ROOTS_ADD_MAXIMUM,
            int PRODUCTS_ADD_MAXIMUM,

            int ppm_N_MAXIMUM,
            int ppm_P_MAXIMUM,
            int ppm_K_MAXIMUM,

            int ppm_S_MAXIMUM,
            int ppm_Mg_MAXIMUM,
            int ppm_Ca_MAXIMUM,

            int ppm_B_MAXIMUM,
            int ppm_Cu_MAXIMUM,
            int ppm_Fe_MAXIMUM,
            int ppm_Mn_MAXIMUM,
            int ppm_Mo_MAXIMUM,
            int ppm_Zn_MAXIMUM

    ){
        this.type = type;

        this.stage_alive_image = stage_alive_image;
        this.stage_dead_image = stage_dead_image;

        this.LENGTH_MINIMUM = LENGTH_MINIMUM;
        this.LEAVES_ADD_MINIMUM = LEAVES_ADD_MINIMUM;
        this.ROOTS_ADD_MINIMUM = ROOTS_ADD_MINIMUM;
        this.PRODUCTS_ADD_MINIMUM =PRODUCTS_ADD_MINIMUM;
        this.ppm_N_MINIMUM = ppm_N_MINIMUM;
        this.ppm_K_MINIMUM = ppm_K_MINIMUM;
        this.ppm_B_MINIMUM = ppm_B_MINIMUM;
        this.ppm_Ca_MINIMUM = ppm_Ca_MINIMUM;
        this.ppm_Cu_MINIMUM = ppm_Cu_MINIMUM;
        this.ppm_Fe_MINIMUM = ppm_Fe_MINIMUM;
        this.ppm_Mn_MINIMUM = ppm_Mn_MINIMUM;
        this.ppm_Mo_MINIMUM = ppm_Mo_MINIMUM;
        this.ppm_Zn_MINIMUM = ppm_Zn_MINIMUM;
        this.ppm_P_MINIMUM = ppm_P_MINIMUM;
        this.ppm_Mg_MINIMUM = ppm_Mg_MINIMUM;
        this.ppm_S_MINIMUM = ppm_S_MINIMUM;

        this.LENGTH_MAXIMUM = LENGTH_MAXIMUM;
        this.LEAVES_ADD_MAXIMUM = LEAVES_ADD_MAXIMUM;
        this.ROOTS_ADD_MAXIMUM = ROOTS_ADD_MAXIMUM;
        this.PRODUCTS_ADD_MAXIMUM = PRODUCTS_ADD_MAXIMUM;
        this.ppm_N_MAXIMUM = ppm_N_MAXIMUM;
        this.ppm_K_MAXIMUM = ppm_K_MAXIMUM;
        this.ppm_B_MAXIMUM = ppm_B_MAXIMUM;
        this.ppm_Ca_MAXIMUM = ppm_Ca_MAXIMUM;
        this.ppm_Cu_MAXIMUM = ppm_Cu_MAXIMUM;
        this.ppm_Fe_MAXIMUM = ppm_Fe_MAXIMUM;
        this.ppm_Mn_MAXIMUM = ppm_Mn_MAXIMUM;
        this.ppm_Mo_MAXIMUM = ppm_Mo_MAXIMUM;
        this.ppm_Zn_MAXIMUM = ppm_Zn_MAXIMUM;
        this.ppm_P_MAXIMUM = ppm_P_MAXIMUM;
        this.ppm_Mg_MAXIMUM = ppm_Mg_MAXIMUM;
        this.ppm_S_MAXIMUM = ppm_S_MAXIMUM;
    }

    private PlantStages type;

    private Image stage_alive_image;
    private Image stage_dead_image;

    private int LENGTH_MINIMUM;
    private int LEAVES_ADD_MINIMUM;
    private int ROOTS_ADD_MINIMUM;
    private int PRODUCTS_ADD_MINIMUM;

    private int ppm_N_MINIMUM;
    private int ppm_K_MINIMUM;
    private int ppm_B_MINIMUM;
    private int ppm_Ca_MINIMUM;
    private int ppm_Cu_MINIMUM;
    private int ppm_Fe_MINIMUM;
    private int ppm_Mn_MINIMUM;
    private int ppm_Mo_MINIMUM;
    private int ppm_Zn_MINIMUM;
    private int ppm_P_MINIMUM;
    private int ppm_Mg_MINIMUM;
    private int ppm_S_MINIMUM;

    private int LENGTH_MAXIMUM;
    private int LEAVES_ADD_MAXIMUM;
    private int ROOTS_ADD_MAXIMUM;
    private int PRODUCTS_ADD_MAXIMUM;

    private int ppm_N_MAXIMUM;
    private int ppm_K_MAXIMUM;
    private int ppm_B_MAXIMUM;
    private int ppm_Ca_MAXIMUM;
    private int ppm_Cu_MAXIMUM;
    private int ppm_Fe_MAXIMUM;
    private int ppm_Mn_MAXIMUM;
    private int ppm_Mo_MAXIMUM;
    private int ppm_Zn_MAXIMUM;
    private int ppm_P_MAXIMUM;
    private int ppm_Mg_MAXIMUM;
    private int ppm_S_MAXIMUM;

    public PlantStages getType() {
        return type;
    }
    public int getLENGTH_MINIMUM() {
        return LENGTH_MINIMUM;
    }
    public int getLEAVES_ADD_MINIMUM() {
        return LEAVES_ADD_MINIMUM;
    }
    public int getROOTS_ADD_MINIMUM() {
        return ROOTS_ADD_MINIMUM;
    }
    public int getPRODUCTS_ADD_MINIMUM() {
        return PRODUCTS_ADD_MINIMUM;
    }
    public int getPPm_N_MINIMUM() {
        return ppm_N_MINIMUM;
    }
    public int getPPm_K_MINIMUM() {
        return ppm_K_MINIMUM;
    }
    public int getPPm_B_MINIMUM() {
        return ppm_B_MINIMUM;
    }
    public int getPPm_Ca_MINIMUM() {
        return ppm_Ca_MINIMUM;
    }
    public int getPPm_Cu_MINIMUM() {
        return ppm_Cu_MINIMUM;
    }
    public int getPPm_Fe_MINIMUM() {
        return ppm_Fe_MINIMUM;
    }
    public int getPPm_Mn_MINIMUM() {
        return ppm_Mn_MINIMUM;
    }
    public int getPPm_Mo_MINIMUM() {
        return ppm_Mo_MINIMUM;
    }
    public int getPPm_Zn_MINIMUM() {
        return ppm_Zn_MINIMUM;
    }
    public int getPPm_P_MINIMUM() {
        return ppm_P_MINIMUM;
    }
    public int getPPm_Mg_MINIMUM() {
        return ppm_Mg_MINIMUM;
    }
    public int getPPm_S_MINIMUM() {
        return ppm_S_MINIMUM;
    }
    public int getLENGTH_MAXIMUM() {
        return LENGTH_MAXIMUM;
    }
    public int getLEAVES_ADD_MAXIMUM() {
        return LEAVES_ADD_MAXIMUM;
    }
    public int getROOTS_ADD_MAXIMUM() {
        return ROOTS_ADD_MAXIMUM;
    }
    public int getPRODUCTS_ADD_MAXIMUM() {
        return PRODUCTS_ADD_MAXIMUM;
    }
    public int getPPm_N_MAXIMUM() {
        return ppm_N_MAXIMUM;
    }
    public int getPPm_K_MAXIMUM() {
        return ppm_K_MAXIMUM;
    }
    public int getPPm_B_MAXIMUM() {
        return ppm_B_MAXIMUM;
    }
    public int getPPm_Ca_MAXIMUM() {
        return ppm_Ca_MAXIMUM;
    }
    public int getPPm_Cu_MAXIMUM() {
        return ppm_Cu_MAXIMUM;
    }
    public int getPPm_Fe_MAXIMUM() {
        return ppm_Fe_MAXIMUM;
    }
    public int getPPm_Mn_MAXIMUM() {
        return ppm_Mn_MAXIMUM;
    }
    public int getPPm_Mo_MAXIMUM() {
        return ppm_Mo_MAXIMUM;
    }
    public int getPPm_Zn_MAXIMUM() {
        return ppm_Zn_MAXIMUM;
    }
    public int getPPm_P_MAXIMUM() {
        return ppm_P_MAXIMUM;
    }
    public int getPPm_Mg_MAXIMUM() {
        return ppm_Mg_MAXIMUM;
    }
    public int getPPm_S_MAXIMUM() {
        return ppm_S_MAXIMUM;
    }
    public Image getStage_alive_image() {
        return stage_alive_image;
    }
    public Image getStage_dead_image() {
        return stage_dead_image;
    }

    public boolean isActive() {
        return active;
    }

    public int getRemain() {
        return remain;
    }
}
