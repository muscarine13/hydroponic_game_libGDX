package com.acidcarpet.hydroponist.plant;


import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PlantStage {

    boolean active;

    private int remain;
    private int leaves_add;
    private int roots_add;
    private int products_add;

    private PlantStages type;

    private Image stage_alive_image;
    private Image stage_dead_image;

    private int ppm_N_min;
    private int ppm_K_min;
    private int ppm_B_min;
    private int ppm_Ca_min;
    private int ppm_Cu_min;
    private int ppm_Fe_min;
    private int ppm_Mn_min;
    private int ppm_Mo_min;
    private int ppm_Zn_min;
    private int ppm_P_min;
    private int ppm_Mg_min;
    private int ppm_S_min;

    private int ppm_N_max;
    private int ppm_K_max;
    private int ppm_B_max;
    private int ppm_Ca_max;
    private int ppm_Cu_max;
    private int ppm_Fe_max;
    private int ppm_Mn_max;
    private int ppm_Mo_max;
    private int ppm_Zn_max;
    private int ppm_P_max;
    private int ppm_Mg_max;
    private int ppm_S_max;

    public synchronized void second(){
        if(!active) return;

        if(type==PlantStages.HARVEST) return;

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

            int time_min,
            int leaves_add_min,
            int roots_add_min,
            int products_add_min,
            int ppm_N_min,
            int ppm_P_min,
            int ppm_K_min,
            int ppm_S_min,
            int ppm_Mg_min,
            int ppm_Ca_min,
            int ppm_B_min,
            int ppm_Cu_min,
            int ppm_Fe_min,
            int ppm_Mn_min,
            int ppm_Mo_min,
            int ppm_Zn_min,

            int time_max,
            int leaves_add_max,
            int roots_add_max,
            int products_add_max,
            int ppm_N_max,
            int ppm_P_max,
            int ppm_K_max,
            int ppm_S_max,
            int ppm_Mg_max,
            int ppm_Ca_max,
            int ppm_B_max,
            int ppm_Cu_max,
            int ppm_Fe_max,
            int ppm_Mn_max,
            int ppm_Mo_max,
            int ppm_Zn_max

    ){
        this.type = type;
        active = true;

        this.remain =  new Random().nextInt(time_max-time_min) + time_min;

        if(leaves_add_max>0&&leaves_add_min>=0&&leaves_add_max>leaves_add_min) this.leaves_add = new Random().nextInt(leaves_add_max-leaves_add_min) + leaves_add_min;
        if(roots_add_max>0&&roots_add_min>=0&&roots_add_max>roots_add_min) this.roots_add = new Random().nextInt(roots_add_max-roots_add_min) + roots_add_min;
        if(products_add_max>0&&products_add_min>=0&&products_add_max>roots_add_min) this.products_add = new Random().nextInt(products_add_max-products_add_min) + products_add_min;

        this.stage_alive_image = stage_alive_image;
        this.stage_dead_image = stage_dead_image;

        this.ppm_N_min = ppm_N_min;
        this.ppm_K_min = ppm_K_min;
        this.ppm_B_min = ppm_B_min;
        this.ppm_Ca_min = ppm_Ca_min;
        this.ppm_Cu_min = ppm_Cu_min;
        this.ppm_Fe_min = ppm_Fe_min;
        this.ppm_Mn_min = ppm_Mn_min;
        this.ppm_Mo_min = ppm_Mo_min;
        this.ppm_Zn_min = ppm_Zn_min;
        this.ppm_P_min = ppm_P_min;
        this.ppm_Mg_min = ppm_Mg_min;
        this.ppm_S_min = ppm_S_min;

        this.ppm_N_max = ppm_N_max;
        this.ppm_K_max = ppm_K_max;
        this.ppm_B_max = ppm_B_max;
        this.ppm_Ca_max = ppm_Ca_max;
        this.ppm_Cu_max = ppm_Cu_max;
        this.ppm_Fe_max = ppm_Fe_max;
        this.ppm_Mn_max = ppm_Mn_max;
        this.ppm_Mo_max = ppm_Mo_max;
        this.ppm_Zn_max = ppm_Zn_max;
        this.ppm_P_max = ppm_P_max;
        this.ppm_Mg_max = ppm_Mg_max;
        this.ppm_S_max = ppm_S_max;


    }

    public PlantStages getType() {
        return type;
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

    public int getPpm_N_min() {
        return ppm_N_min;
    }
    public int getPpm_K_min() {
        return ppm_K_min;
    }
    public int getPpm_B_min() {
        return ppm_B_min;
    }
    public int getPpm_Ca_min() {
        return ppm_Ca_min;
    }
    public int getPpm_Cu_min() {
        return ppm_Cu_min;
    }
    public int getPpm_Fe_min() {
        return ppm_Fe_min;
    }
    public int getPpm_Mn_min() {
        return ppm_Mn_min;
    }
    public int getPpm_Mo_min() {
        return ppm_Mo_min;
    }
    public int getPpm_Zn_min() {
        return ppm_Zn_min;
    }
    public int getPpm_P_min() {
        return ppm_P_min;
    }
    public int getPpm_Mg_min() {
        return ppm_Mg_min;
    }
    public int getPpm_S_min() {
        return ppm_S_min;
    }
    public int getPpm_N_max() {
        return ppm_N_max;
    }
    public int getPpm_K_max() {
        return ppm_K_max;
    }
    public int getPpm_B_max() {
        return ppm_B_max;
    }
    public int getPpm_Ca_max() {
        return ppm_Ca_max;
    }
    public int getPpm_Cu_max() {
        return ppm_Cu_max;
    }
    public int getPpm_Fe_max() {
        return ppm_Fe_max;
    }
    public int getPpm_Mn_max() {
        return ppm_Mn_max;
    }
    public int getPpm_Mo_max() {
        return ppm_Mo_max;
    }
    public int getPpm_Zn_max() {
        return ppm_Zn_max;
    }
    public int getPpm_P_max() {
        return ppm_P_max;
    }
    public int getPpm_Mg_max() {
        return ppm_Mg_max;
    }
    public int getPpm_S_max() {
        return ppm_S_max;
    }
    public int getLeaves_add() {
        return leaves_add;
    }
    public int getRoots_add() {
        return roots_add;
    }
    public int getProducts_add() {
        return products_add;
    }
}
