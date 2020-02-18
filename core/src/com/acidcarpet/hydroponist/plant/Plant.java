package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.WaterPack;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Plant {

    private boolean alive;

    private int current_stage_index;
    private int next_stage_remain;

    private int current_health;
    private int maximum_health;

    private List<PlantStage> stages;

    private List<Leave> leaves;
    private List<Root> roots;
    private List<Product> products;

    public Plant(int maximum_health){
        alive = true;

        current_stage_index=0;

        leaves = new LinkedList<>();
        roots = new LinkedList<>();
        products = new LinkedList<>();



        stages = set_stages();

        this.maximum_health = maximum_health;
        current_health=maximum_health/2;

        element_N_problem_points = 0;
        element_K_problem_points = 0;
        element_B_problem_points = 0;
        element_Ca_problem_points = 0;
        element_Cu_problem_points = 0;
        element_Fe_problem_points = 0;
        element_Mn_problem_points = 0;
        element_Mo_problem_points = 0;
        element_Zn_problem_points = 0;
        element_P_problem_points = 0;
        element_Mg_problem_points = 0;
        element_S_problem_points = 0;

    }

    private void check_for_next_stage() {
        if(!alive) return;
        if(current_stage_index>=stages.size()) return;

        if (next_stage_remain == 0) {

            current_stage_index++;
            if(current_stage_index>=stages.size()) {

                //перенести результат на склад

                alive=false;



            }else{
                next_stage_remain= new Random().nextInt(stages.get(current_stage_index).getLENGTH_MAXIMUM() - stages.get(current_stage_index).getLENGTH_MINIMUM())+stages.get(current_stage_index).getLENGTH_MINIMUM();

                try{
                    int leaves_to_add = new Random().nextInt( stages.get(current_stage_index).getLEAVES_ADD_MAXIMUM() - stages.get(current_stage_index).getLEAVES_ADD_MINIMUM()+stages.get(current_stage_index).getLEAVES_ADD_MINIMUM());
                    for(int i = 0; i<leaves_to_add;i++){
                        leaves.add(get_new_leave());
                    }
                }catch (Exception e){

                }

                try{
                    int roots_to_add = new Random().nextInt(stages.get(current_stage_index).getROOTS_ADD_MAXIMUM()-stages.get(current_stage_index).getROOTS_ADD_MINIMUM())+stages.get(current_stage_index).getROOTS_ADD_MINIMUM();
                    for(int i = 0; i<roots_to_add;i++){
                        roots.add(get_new_root());
                    }
                }catch (Exception e){

                }

                try{
                    int flowers_to_add = new Random().nextInt(stages.get(current_stage_index).getPRODUCTS_ADD_MAXIMUM() - stages.get(current_stage_index).getPRODUCTS_ADD_MINIMUM())+stages.get(current_stage_index).getPRODUCTS_ADD_MINIMUM();
                    for(int i = 0; i<flowers_to_add;i++){
                        products.add(get_new_product());
                    }
                }catch (Exception e){

                }



            }

        }
    }
    private void check_health(){
        if(current_health<=0){
           alive=false;
        }
    }

    public synchronized void add_metabolism_pack(WaterPack pack){
        if(!alive) return;

        if(pack.element_ppm_N()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_N_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_N_MINIMUM()!=0){
            element_N_problem_points--;
        }
        if(pack.element_ppm_N()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_N_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_N_MAXIMUM()!=0){
            element_N_problem_points++;
        }
        if(pack.element_ppm_P()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_P_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_P_MINIMUM()!=0){
            element_P_problem_points--;
        }
        if(pack.element_ppm_P()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_P_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_P_MAXIMUM()!=0){
            element_P_problem_points++;
        }
        if(pack.element_ppm_K()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_K_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_K_MINIMUM()!=0){
            element_K_problem_points--;
        }
        if(pack.element_ppm_K()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_K_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_K_MAXIMUM()!=0){
            element_K_problem_points++;
        }

        if(pack.element_ppm_S()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_S_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_S_MINIMUM()!=0){
            element_S_problem_points--;
        }
        if(pack.element_ppm_S()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_S_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_S_MAXIMUM()!=0){
            element_S_problem_points++;
        }
        if(pack.element_ppm_Mg()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mg_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mg_MINIMUM()!=0){
            element_Mg_problem_points--;
        }
        if(pack.element_ppm_Mg()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mg_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mg_MAXIMUM()!=0){
            element_Mg_problem_points++;
        }
        if(pack.element_ppm_Ca()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Ca_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Ca_MINIMUM()!=0){
            element_Ca_problem_points--;
        }
        if(pack.element_ppm_Ca()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Ca_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Ca_MAXIMUM()!=0){
            element_Ca_problem_points++;
        }

        if(pack.element_ppm_B()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_B_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_B_MINIMUM()!=0){
            element_B_problem_points--;
        }
        if(pack.element_ppm_B()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_B_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_B_MAXIMUM()!=0){
            element_B_problem_points++;
        }
        if(pack.element_ppm_Cu()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Cu_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Cu_MINIMUM()!=0){
            element_Cu_problem_points--;
        }
        if(pack.element_ppm_Cu()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Cu_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Cu_MAXIMUM()!=0){
            element_Cu_problem_points++;
        }
        if(pack.element_ppm_Fe()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Fe_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Fe_MINIMUM()!=0){
            element_Fe_problem_points--;
        }
        if(pack.element_ppm_Fe()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Fe_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Fe_MAXIMUM()!=0){
            element_Fe_problem_points++;
        }
        if(pack.element_ppm_Mn()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mn_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mn_MINIMUM()!=0){
            element_Mn_problem_points--;
        }
        if(pack.element_ppm_Mn()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mn_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mn_MAXIMUM()!=0){
            element_Mn_problem_points++;
        }
        if(pack.element_ppm_Mo()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mo_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mo_MINIMUM()!=0){
            element_Mo_problem_points--;
        }
        if(pack.element_ppm_Mo()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mo_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Mo_MAXIMUM()!=0){
            element_Mo_problem_points++;
        }
        if(pack.element_ppm_Zn()<stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Zn_MINIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Zn_MINIMUM()!=0){
            element_Zn_problem_points--;
        }
        if(pack.element_ppm_Zn()>stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Zn_MAXIMUM()&&stages.get(current_stage_index).getCONSUMPTION_ELEMENT_Zn_MAXIMUM()!=0){
            element_Zn_problem_points++;
        }

    }

    private double water;
    public synchronized boolean drink(double volume){
        if(water>=volume){
            water-=volume;
            return true;
        }else return false;
    }

    private double light_energy;
    private double dark_energy;
    public synchronized void add_light_energy(double energy){
        light_energy+=energy;
    }
    public synchronized void add_dark_energy(double energy){
        dark_energy+=energy;
    }
    public synchronized boolean buy(double dark_energy, double light_energy){
        if(this.light_energy>=light_energy && this.dark_energy>=dark_energy){
            this.light_energy-=light_energy;
            this.dark_energy-=dark_energy;
            return true;
        }else{
            return false;
        }
    }

    public synchronized void roots_absorb(){
        if(roots.isEmpty()) return;

        for(Root root : roots){
            root.absorb();
        }
    }
    public synchronized void leaves_production(){
        if (leaves.isEmpty()) return;

        for (Leave leave : leaves){
            leave.photosynthesis();
        }
    }
    public synchronized void try_grow_up(){

        int problem = 0;
        int ok = 0;

        if(element_N_problem_points!=0) problem++;
        else ok++;
        if(element_P_problem_points!=0) problem++;
        else ok++;
        if(element_K_problem_points!=0) problem++;
        else ok++;

        if(element_S_problem_points!=0) problem++;
        else ok++;
        if(element_Mg_problem_points!=0) problem++;
        else ok++;
        if(element_Ca_problem_points!=0) problem++;
        else ok++;

        if(element_B_problem_points!=0) problem++;
        else ok++;
        if(element_Cu_problem_points!=0) problem++;
        else ok++;
        if(element_Fe_problem_points!=0) problem++;
        else ok++;
        if(element_Mn_problem_points!=0) problem++;
        else ok++;
        if(element_Mo_problem_points!=0) problem++;
        else ok++;
        if(element_Zn_problem_points!=0) problem++;
        else ok++;

        current_health-=problem;
        current_health+=ok;

        if(current_health<0) {
            current_health = 0;
            alive=false;
        }
        if(current_health>maximum_health) {
            current_health = maximum_health;
            for(Root root : roots){
                root.grow();
            }
            for (Leave leave : leaves){
                leave.grow();
            }
        }

        if(ok>problem){
            for(Root root : roots){
                root.grow();
            }
            for (Leave leave : leaves){
                leave.grow();
            }
        }

    }
    public synchronized void try_grow_up_products(){
        for (Product product : products){
            product.grow(this);
        }
    }

    public synchronized void second(){
        if(!alive) return;

        check_health(); // Проверить живо ли растение

        check_for_next_stage(); // Проверить перешло ли растение в следующую фазу

        roots_absorb(); // Корни пытаются поппить из бака если живы
        leaves_production(); //Листья пьют воду и производят энергию
        try_grow_up(); // Если успешных параметров больше, то растут и корни и листья

        try_grow_up_products(); // Пробуем купить плоды и цветы за энергию

    }

    private double element_N_problem_points;
    private double element_P_problem_points;
    private double element_K_problem_points;

    private double element_S_problem_points;
    private double element_Mg_problem_points;
    private double element_Ca_problem_points;

    private double element_B_problem_points;
    private double element_Cu_problem_points;
    private double element_Fe_problem_points;
    private double element_Mn_problem_points;
    private double element_Mo_problem_points;
    private double element_Zn_problem_points;

    public abstract List<PlantStage> set_stages(); // Получить все стадии растения
    public Image get_image_plant(){
        if(alive) return stages.get(current_stage_index).getStage_alive_image();
        else return stages.get(current_stage_index).getStage_dead_image();
    }

    public abstract Leave get_new_leave(); // Получить новый обьект листочка
    public abstract Root get_new_root(); // Получить новый обьект корешочка
    public abstract Product get_new_product(); // Получить новый обьект цветочка или плода или проччего продукта

    public boolean isAlive() {
        return alive;
    }
    public int getCurrent_stage_index() {
        return current_stage_index;
    }
    public int getNext_stage_remain() {
        return next_stage_remain;
    }
    public int getCurrent_health() {
        return current_health;
    }
    public int getMaximum_health() {
        return maximum_health;
    }
    public List<PlantStage> getStages() {
        return stages;
    }
    public List<Leave> getLeaves() {
        return leaves;
    }
    public List<Root> getRoots() {
        return roots;
    }
    public List<Product> getProducts() {
        return products;
    }
    public double getWater() {
        return water;
    }
    public double getLight_energy() {
        return light_energy;
    }
    public double getDark_energy() {
        return dark_energy;
    }

}
