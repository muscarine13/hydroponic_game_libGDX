package com.acidcarpet.hydroponist.plant;

import javafx.scene.image.Image;

public class PlantStage {

    public PlantStage(
            PlantStages type,
            Image stage_alive_image,
            Image stage_dead_image,

            int LENGTH_MINIMUM,
            int LEAVES_ADD_MINIMUM,
            int ROOTS_ADD_MINIMUM,
            int PRODUCTS_ADD_MINIMUM,
            double CONSUMPTION_ELEMENT_N_MINIMUM,
            double CONSUMPTION_ELEMENT_K_MINIMUM,
            double CONSUMPTION_ELEMENT_B_MINIMUM,
            double CONSUMPTION_ELEMENT_Ca_MINIMUM,
            double CONSUMPTION_ELEMENT_Cu_MINIMUM,
            double CONSUMPTION_ELEMENT_Fe_MINIMUM,
            double CONSUMPTION_ELEMENT_Mn_MINIMUM,
            double CONSUMPTION_ELEMENT_Mo_MINIMUM,
            double CONSUMPTION_ELEMENT_Zn_MINIMUM,
            double CONSUMPTION_ELEMENT_P_MINIMUM,
            double CONSUMPTION_ELEMENT_Mg_MINIMUM,
            double CONSUMPTION_ELEMENT_S_MINIMUM,

            int LENGTH_MAXIMUM,
            int LEAVES_ADD_MAXIMUM,
            int ROOTS_ADD_MAXIMUM,
            int PRODUCTS_ADD_MAXIMUM,
            double CONSUMPTION_ELEMENT_N_MAXIMUM,
            double CONSUMPTION_ELEMENT_K_MAXIMUM,
            double CONSUMPTION_ELEMENT_B_MAXIMUM,
            double CONSUMPTION_ELEMENT_Ca_MAXIMUM,
            double CONSUMPTION_ELEMENT_Cu_MAXIMUM,
            double CONSUMPTION_ELEMENT_Fe_MAXIMUM,
            double CONSUMPTION_ELEMENT_Mn_MAXIMUM,
            double CONSUMPTION_ELEMENT_Mo_MAXIMUM,
            double CONSUMPTION_ELEMENT_Zn_MAXIMUM,
            double CONSUMPTION_ELEMENT_P_MAXIMUM,
            double CONSUMPTION_ELEMENT_Mg_MAXIMUM,
            double CONSUMPTION_ELEMENT_S_MAXIMUM
    ){
        this.type = type;

        this.stage_alive_image = stage_alive_image;
        this.stage_dead_image = stage_dead_image;

        this.LENGTH_MINIMUM = LENGTH_MINIMUM;
                this.LEAVES_ADD_MINIMUM = LEAVES_ADD_MINIMUM;
                this.ROOTS_ADD_MINIMUM = ROOTS_ADD_MINIMUM;
                this.PRODUCTS_ADD_MINIMUM =PRODUCTS_ADD_MINIMUM;
                this.CONSUMPTION_ELEMENT_N_MINIMUM = CONSUMPTION_ELEMENT_N_MINIMUM;
                this.CONSUMPTION_ELEMENT_K_MINIMUM = CONSUMPTION_ELEMENT_K_MINIMUM;
                this.CONSUMPTION_ELEMENT_B_MINIMUM = CONSUMPTION_ELEMENT_B_MINIMUM;
                this.CONSUMPTION_ELEMENT_Ca_MINIMUM = CONSUMPTION_ELEMENT_Ca_MINIMUM;
                this.CONSUMPTION_ELEMENT_Cu_MINIMUM = CONSUMPTION_ELEMENT_Cu_MINIMUM;
                this.CONSUMPTION_ELEMENT_Fe_MINIMUM = CONSUMPTION_ELEMENT_Fe_MINIMUM;
                this.CONSUMPTION_ELEMENT_Mn_MINIMUM = CONSUMPTION_ELEMENT_Mn_MINIMUM;
                this.CONSUMPTION_ELEMENT_Mo_MINIMUM = CONSUMPTION_ELEMENT_Mo_MINIMUM;
                this.CONSUMPTION_ELEMENT_Zn_MINIMUM = CONSUMPTION_ELEMENT_Zn_MINIMUM;
                this.CONSUMPTION_ELEMENT_P_MINIMUM = CONSUMPTION_ELEMENT_P_MINIMUM;
                this.CONSUMPTION_ELEMENT_Mg_MINIMUM = CONSUMPTION_ELEMENT_Mg_MINIMUM;
                this.CONSUMPTION_ELEMENT_S_MINIMUM = CONSUMPTION_ELEMENT_S_MINIMUM;

                this.LENGTH_MAXIMUM = LENGTH_MAXIMUM;
                this.LEAVES_ADD_MAXIMUM = LEAVES_ADD_MAXIMUM;
                this.ROOTS_ADD_MAXIMUM = ROOTS_ADD_MAXIMUM;
                this.PRODUCTS_ADD_MAXIMUM = PRODUCTS_ADD_MAXIMUM;
                this.CONSUMPTION_ELEMENT_N_MAXIMUM = CONSUMPTION_ELEMENT_N_MAXIMUM;
                this.CONSUMPTION_ELEMENT_K_MAXIMUM = CONSUMPTION_ELEMENT_K_MAXIMUM;
                this.CONSUMPTION_ELEMENT_B_MAXIMUM = CONSUMPTION_ELEMENT_B_MAXIMUM;
                this.CONSUMPTION_ELEMENT_Ca_MAXIMUM = CONSUMPTION_ELEMENT_Ca_MAXIMUM;
                this.CONSUMPTION_ELEMENT_Cu_MAXIMUM = CONSUMPTION_ELEMENT_Cu_MAXIMUM;
                this.CONSUMPTION_ELEMENT_Fe_MAXIMUM = CONSUMPTION_ELEMENT_Fe_MAXIMUM;
                this.CONSUMPTION_ELEMENT_Mn_MAXIMUM = CONSUMPTION_ELEMENT_Mn_MAXIMUM;
                this.CONSUMPTION_ELEMENT_Mo_MAXIMUM = CONSUMPTION_ELEMENT_Mo_MAXIMUM;
                this.CONSUMPTION_ELEMENT_Zn_MAXIMUM = CONSUMPTION_ELEMENT_Zn_MAXIMUM;
                this.CONSUMPTION_ELEMENT_P_MAXIMUM = CONSUMPTION_ELEMENT_P_MAXIMUM;
                this.CONSUMPTION_ELEMENT_Mg_MAXIMUM = CONSUMPTION_ELEMENT_Mg_MAXIMUM;
                this.CONSUMPTION_ELEMENT_S_MAXIMUM = CONSUMPTION_ELEMENT_S_MAXIMUM;
    }

    private PlantStages type;

    private Image stage_alive_image;
    private Image stage_dead_image;

    private int LENGTH_MINIMUM;
    private int LEAVES_ADD_MINIMUM;
    private int ROOTS_ADD_MINIMUM;
    private int PRODUCTS_ADD_MINIMUM;

    private double CONSUMPTION_ELEMENT_N_MINIMUM;
    private double CONSUMPTION_ELEMENT_K_MINIMUM;
    private double CONSUMPTION_ELEMENT_B_MINIMUM;
    private double CONSUMPTION_ELEMENT_Ca_MINIMUM;
    private double CONSUMPTION_ELEMENT_Cu_MINIMUM;
    private double CONSUMPTION_ELEMENT_Fe_MINIMUM;
    private double CONSUMPTION_ELEMENT_Mn_MINIMUM;
    private double CONSUMPTION_ELEMENT_Mo_MINIMUM;
    private double CONSUMPTION_ELEMENT_Zn_MINIMUM;
    private double CONSUMPTION_ELEMENT_P_MINIMUM;
    private double CONSUMPTION_ELEMENT_Mg_MINIMUM;
    private double CONSUMPTION_ELEMENT_S_MINIMUM;

    private int LENGTH_MAXIMUM;
    private int LEAVES_ADD_MAXIMUM;
    private int ROOTS_ADD_MAXIMUM;
    private int PRODUCTS_ADD_MAXIMUM;

    private double CONSUMPTION_ELEMENT_N_MAXIMUM;
    private double CONSUMPTION_ELEMENT_K_MAXIMUM;
    private double CONSUMPTION_ELEMENT_B_MAXIMUM;
    private double CONSUMPTION_ELEMENT_Ca_MAXIMUM;
    private double CONSUMPTION_ELEMENT_Cu_MAXIMUM;
    private double CONSUMPTION_ELEMENT_Fe_MAXIMUM;
    private double CONSUMPTION_ELEMENT_Mn_MAXIMUM;
    private double CONSUMPTION_ELEMENT_Mo_MAXIMUM;
    private double CONSUMPTION_ELEMENT_Zn_MAXIMUM;
    private double CONSUMPTION_ELEMENT_P_MAXIMUM;
    private double CONSUMPTION_ELEMENT_Mg_MAXIMUM;
    private double CONSUMPTION_ELEMENT_S_MAXIMUM;

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
    public double getCONSUMPTION_ELEMENT_N_MINIMUM() {
        return CONSUMPTION_ELEMENT_N_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_K_MINIMUM() {
        return CONSUMPTION_ELEMENT_K_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_B_MINIMUM() {
        return CONSUMPTION_ELEMENT_B_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Ca_MINIMUM() {
        return CONSUMPTION_ELEMENT_Ca_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Cu_MINIMUM() {
        return CONSUMPTION_ELEMENT_Cu_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Fe_MINIMUM() {
        return CONSUMPTION_ELEMENT_Fe_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Mn_MINIMUM() {
        return CONSUMPTION_ELEMENT_Mn_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Mo_MINIMUM() {
        return CONSUMPTION_ELEMENT_Mo_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Zn_MINIMUM() {
        return CONSUMPTION_ELEMENT_Zn_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_P_MINIMUM() {
        return CONSUMPTION_ELEMENT_P_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Mg_MINIMUM() {
        return CONSUMPTION_ELEMENT_Mg_MINIMUM;
    }
    public double getCONSUMPTION_ELEMENT_S_MINIMUM() {
        return CONSUMPTION_ELEMENT_S_MINIMUM;
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
    public double getCONSUMPTION_ELEMENT_N_MAXIMUM() {
        return CONSUMPTION_ELEMENT_N_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_K_MAXIMUM() {
        return CONSUMPTION_ELEMENT_K_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_B_MAXIMUM() {
        return CONSUMPTION_ELEMENT_B_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Ca_MAXIMUM() {
        return CONSUMPTION_ELEMENT_Ca_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Cu_MAXIMUM() {
        return CONSUMPTION_ELEMENT_Cu_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Fe_MAXIMUM() {
        return CONSUMPTION_ELEMENT_Fe_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Mn_MAXIMUM() {
        return CONSUMPTION_ELEMENT_Mn_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Mo_MAXIMUM() {
        return CONSUMPTION_ELEMENT_Mo_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Zn_MAXIMUM() {
        return CONSUMPTION_ELEMENT_Zn_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_P_MAXIMUM() {
        return CONSUMPTION_ELEMENT_P_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_Mg_MAXIMUM() {
        return CONSUMPTION_ELEMENT_Mg_MAXIMUM;
    }
    public double getCONSUMPTION_ELEMENT_S_MAXIMUM() {
        return CONSUMPTION_ELEMENT_S_MAXIMUM;
    }
    public Image getStage_alive_image() {
        return stage_alive_image;
    }
    public Image getStage_dead_image() {
        return stage_dead_image;
    }

    @Override
    public String toString() {
        return "PlantStage{" +
                "LENGTH_MINIMUM=" + LENGTH_MINIMUM +
                ", LEAVES_ADD_MINIMUM=" + LEAVES_ADD_MINIMUM +
                ", ROOTS_ADD_MINIMUM=" + ROOTS_ADD_MINIMUM +
                ", PRODUCTS_ADD_MINIMUM=" + PRODUCTS_ADD_MINIMUM +
                ", CONSUMPTION_ELEMENT_N_MINIMUM=" + CONSUMPTION_ELEMENT_N_MINIMUM +
                ", CONSUMPTION_ELEMENT_K_MINIMUM=" + CONSUMPTION_ELEMENT_K_MINIMUM +
                ", CONSUMPTION_ELEMENT_B_MINIMUM=" + CONSUMPTION_ELEMENT_B_MINIMUM +
                ", CONSUMPTION_ELEMENT_Ca_MINIMUM=" + CONSUMPTION_ELEMENT_Ca_MINIMUM +
                ", CONSUMPTION_ELEMENT_Cu_MINIMUM=" + CONSUMPTION_ELEMENT_Cu_MINIMUM +
                ", CONSUMPTION_ELEMENT_Fe_MINIMUM=" + CONSUMPTION_ELEMENT_Fe_MINIMUM +
                ", CONSUMPTION_ELEMENT_Mn_MINIMUM=" + CONSUMPTION_ELEMENT_Mn_MINIMUM +
                ", CONSUMPTION_ELEMENT_Mo_MINIMUM=" + CONSUMPTION_ELEMENT_Mo_MINIMUM +
                ", CONSUMPTION_ELEMENT_Zn_MINIMUM=" + CONSUMPTION_ELEMENT_Zn_MINIMUM +
                ", CONSUMPTION_ELEMENT_P_MINIMUM=" + CONSUMPTION_ELEMENT_P_MINIMUM +
                ", CONSUMPTION_ELEMENT_Mg_MINIMUM=" + CONSUMPTION_ELEMENT_Mg_MINIMUM +
                ", CONSUMPTION_ELEMENT_S_MINIMUM=" + CONSUMPTION_ELEMENT_S_MINIMUM +
                ", LENGTH_MAXIMUM=" + LENGTH_MAXIMUM +
                ", LEAVES_ADD_MAXIMUM=" + LEAVES_ADD_MAXIMUM +
                ", ROOTS_ADD_MAXIMUM=" + ROOTS_ADD_MAXIMUM +
                ", PRODUCTS_ADD_MAXIMUM=" + PRODUCTS_ADD_MAXIMUM +
                ", CONSUMPTION_ELEMENT_N_MAXIMUM=" + CONSUMPTION_ELEMENT_N_MAXIMUM +
                ", CONSUMPTION_ELEMENT_K_MAXIMUM=" + CONSUMPTION_ELEMENT_K_MAXIMUM +
                ", CONSUMPTION_ELEMENT_B_MAXIMUM=" + CONSUMPTION_ELEMENT_B_MAXIMUM +
                ", CONSUMPTION_ELEMENT_Ca_MAXIMUM=" + CONSUMPTION_ELEMENT_Ca_MAXIMUM +
                ", CONSUMPTION_ELEMENT_Cu_MAXIMUM=" + CONSUMPTION_ELEMENT_Cu_MAXIMUM +
                ", CONSUMPTION_ELEMENT_Fe_MAXIMUM=" + CONSUMPTION_ELEMENT_Fe_MAXIMUM +
                ", CONSUMPTION_ELEMENT_Mn_MAXIMUM=" + CONSUMPTION_ELEMENT_Mn_MAXIMUM +
                ", CONSUMPTION_ELEMENT_Mo_MAXIMUM=" + CONSUMPTION_ELEMENT_Mo_MAXIMUM +
                ", CONSUMPTION_ELEMENT_Zn_MAXIMUM=" + CONSUMPTION_ELEMENT_Zn_MAXIMUM +
                ", CONSUMPTION_ELEMENT_P_MAXIMUM=" + CONSUMPTION_ELEMENT_P_MAXIMUM +
                ", CONSUMPTION_ELEMENT_Mg_MAXIMUM=" + CONSUMPTION_ELEMENT_Mg_MAXIMUM +
                ", CONSUMPTION_ELEMENT_S_MAXIMUM=" + CONSUMPTION_ELEMENT_S_MAXIMUM +
                '}';
    }
}
