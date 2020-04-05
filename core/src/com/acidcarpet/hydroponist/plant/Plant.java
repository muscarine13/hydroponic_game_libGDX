package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.WaterPack;
import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.LinkedList;
import java.util.List;

public abstract class Plant implements Storable {
    private String name;

    private int gold_price;
    private int diamond_price;
    @Override
    public int coin_price() {
        return gold_price;
    }

    @Override
    public int diamond_price() {
        return diamond_price;
    }

    private boolean alive;
    public boolean isAlive() {
        return alive;
    }

    private boolean grow_up;
    public synchronized void setGrowUp(boolean grow_up){
        this.grow_up = grow_up;
    }
    public synchronized void try_grow_up() {
        if (grow_up == true) {


            if (get_current_stage().getLeaves_add() > 0) {
                for (int i = 0; i < get_current_stage().getLeaves_add(); i++) {
                    leaves.add(get_new_leave());
                }
            }
            if (get_current_stage().getRoots_add() > 0) {
                for (int i = 0; i < get_current_stage().getRoots_add(); i++) {
                    roots.add(get_new_root());
                }
            }
            if (get_current_stage().getProducts_add() > 0) {
                for (int i = 0; i < get_current_stage().getProducts_add(); i++) {
                    products.add(get_new_product());
                }
            }

            grow_up = false;
        }
    }

    private int current_health;
    private int maximum_health;
    public synchronized void hit(){
        current_health--;
        if(current_health<=0){
            current_health = 0;
            alive=false;
        }

    }
    public synchronized void heal(){
        if(alive){
            current_health++;
            if(current_health>=maximum_health) current_health = maximum_health;
        }
    }

    private List<PlantStage> stages;
    public synchronized PlantStage get_current_stage(){
        for (PlantStage stage : stages){
            if(stage.isActive()){
                return stage;
            }
        }
        return null;
    }
    public synchronized boolean current_stage_second(){
        if(!alive) return false;
        if(get_current_stage()!=null){
            get_current_stage().second();
            return true;
        }else{
            return false;
        }
    }

    private List<Root> roots;
    public synchronized boolean roots_second(){
        if(!alive) return false;

        if(!roots.isEmpty()){

            for (Root root : roots){
                if(root.isAlive()){
                    if(root.may_absorb()){
                        water+=root.getWater_volume_multiplier()*root.getLength();
                        Box.getInstance().getPot().drain(root.getWater_volume_multiplier()*root.getLength());

                        if((Box.getInstance().getPot().getN()>=get_current_stage().getPpm_N_min()&&Box.getInstance().getPot().getN()<=get_current_stage().getPpm_N_max())){
                            N_problem_points--;
                            if(N_problem_points<=0) {
                                N_problem_points=0;
                                heal();
                            }
                        }else{
                            N_problem_points++;
                            if(N_problem_points>=100) {
                                N_problem_points=100;
                                hit();
                            }
                        }
                        if((Box.getInstance().getPot().getP()>=get_current_stage().getPpm_P_min()&&Box.getInstance().getPot().getP()<=get_current_stage().getPpm_P_max())){
                            P_problem_points--;
                            if(P_problem_points<=0) {
                                P_problem_points=0;
                                heal();
                            }
                        }else{
                            P_problem_points++;
                            if(P_problem_points>=100) {
                                P_problem_points=100;
                                hit();

                            }
                        }
                        if((Box.getInstance().getPot().getK()>=get_current_stage().getPpm_K_min()&&Box.getInstance().getPot().getK()<=get_current_stage().getPpm_K_max())){
                            K_problem_points--;
                            if(K_problem_points<=0) {
                                K_problem_points=0;
                                heal();
                            }
                        }else{
                            K_problem_points++;
                            if(K_problem_points>=100) {
                                K_problem_points=100;
                                hit();
                            }
                        }

                        if((Box.getInstance().getPot().getS()>=get_current_stage().getPpm_S_min()&&Box.getInstance().getPot().getS()<=get_current_stage().getPpm_S_max())){
                            S_problem_points--;
                            if(S_problem_points<=0) {
                                S_problem_points=0;
                                heal();
                            }
                        }else{
                            S_problem_points++;
                            if(S_problem_points>=100) {
                                S_problem_points=100;
                                hit();
                            }
                        }
                        if((Box.getInstance().getPot().getMg()>=get_current_stage().getPpm_Mg_min()&&Box.getInstance().getPot().getMg()<=get_current_stage().getPpm_Mg_max())){
                            Mg_problem_points--;
                            if(Mg_problem_points<=0) {
                                Mg_problem_points=0;
                                heal();
                            }
                        }else{
                            Mg_problem_points++;
                            if(Mg_problem_points>=100) {
                                Mg_problem_points=100;
                                hit();
                            }
                        }
                        if((Box.getInstance().getPot().getCa()>=get_current_stage().getPpm_Ca_min()&&Box.getInstance().getPot().getCa()<=get_current_stage().getPpm_Ca_max())){
                            Ca_problem_points--;
                            if(Ca_problem_points<=0) {
                                Ca_problem_points=0;
                                heal();
                            }
                        }else{
                            Ca_problem_points++;
                            if(Ca_problem_points>=100) {
                                Ca_problem_points=100;
                                hit();
                            }
                        }

                        if((Box.getInstance().getPot().getB()>=get_current_stage().getPpm_B_min()&&Box.getInstance().getPot().getB()<=get_current_stage().getPpm_B_max())){
                            B_problem_points--;
                            if(B_problem_points<=0) {
                                B_problem_points=0;
                                heal();
                            }
                        }else{
                            B_problem_points++;
                            if(B_problem_points>=100) {
                                B_problem_points=100;
                               hit();
                            }
                        }
                        if((Box.getInstance().getPot().getCu()>=get_current_stage().getPpm_Cu_min()&&Box.getInstance().getPot().getCu()<=get_current_stage().getPpm_Cu_max())){
                            Cu_problem_points--;
                            if(Cu_problem_points<=0) {
                                Cu_problem_points=0;
                                heal();
                            }
                        }else{
                            Cu_problem_points++;
                            if(Cu_problem_points>=100) {
                                Cu_problem_points=100;
                               hit();
                            }
                        }
                        if((Box.getInstance().getPot().getFe()>=get_current_stage().getPpm_Fe_min()&&Box.getInstance().getPot().getFe()<=get_current_stage().getPpm_Fe_max())){
                            Fe_problem_points--;
                            if(Fe_problem_points<=0) {
                                Fe_problem_points=0;
                                heal();
                            }
                        }else{
                            Fe_problem_points++;
                            if(Fe_problem_points>=100) {
                                Fe_problem_points=100;
                                hit();
                            }
                        }

                        if((Box.getInstance().getPot().getMn()>=get_current_stage().getPpm_Mn_min()&&Box.getInstance().getPot().getMn()<=get_current_stage().getPpm_Mn_max())){
                            Mn_problem_points--;
                            if(Mn_problem_points<=0) {
                                Mn_problem_points=0;
                                heal();
                            }
                        }else{
                            Mn_problem_points++;
                            if(Mn_problem_points>=100) {
                                Mn_problem_points=100;
                                hit();
                            }
                        }
                        if((Box.getInstance().getPot().getMo()>=get_current_stage().getPpm_Mo_min()&&Box.getInstance().getPot().getMo()<=get_current_stage().getPpm_Mo_max())){
                            Mo_problem_points--;
                            if(Mo_problem_points<=0) {
                                Mo_problem_points=0;
                                heal();
                            }
                        }else{
                            Mo_problem_points++;
                            if(Mo_problem_points>=100) {
                                Mo_problem_points=100;
                                hit();
                            }
                        }
                        if((Box.getInstance().getPot().getZn()>=get_current_stage().getPpm_Zn_min()&&Box.getInstance().getPot().getZn()<=get_current_stage().getPpm_Zn_max())){
                            Zn_problem_points--;
                            if(Zn_problem_points<=0) {
                                Zn_problem_points=0;
                                heal();
                            }
                        }else{
                            Zn_problem_points++;
                            if(Zn_problem_points>=100) {
                                Zn_problem_points=100;
                                hit();
                            }
                        }

                        root.heal();
                        root.grow();
                    }else{
                        root.hit();
                    }
                }

            }
            return true;

        }else {
            return false;
        }
    }

    private List<Leave> leaves;
    public synchronized boolean leaves_second(){
        if(!alive) return false;

        if(!leaves.isEmpty()){
            for (Leave leave : leaves){
               if(leave.isAlive()){
                   if(leave.may_photosynthesis()){

                       water-=leave.getWater_consumption()*(leave.getHeight()*leave.getWidth());

                       if(Box.getInstance().getLamp()!=null){


                           if(
                                   Box.getInstance().getLamp().isOn()
                                           &&
                                   Box.getInstance().getLamp().reduce_lm(leave.getLm_consumption()*(int)(leave.getWidth()*leave.getHeight())))
                           {
                               light_energy+=(int)(leave.getLight_energy_production()*(leave.getHeight()*leave.getWidth()));
                           }else{
                               dark_energy+=(int)(leave.getDark_energy_production()*(leave.getHeight()*leave.getWidth()));
                           }
                       }else{
                           dark_energy+=(int)(leave.getDark_energy_production()*(leave.getHeight()*leave.getWidth()));
                       }

                       leave.heal();
                       leave.grow();
                   }else{
                       leave.hit();
                   }
               }
            }
            return true;
        }else{
            return false;
        }


    }

    private List<Product> products;
    public synchronized boolean products_second(){
        if(!alive) return false;

        if(!products.isEmpty()){

            for (Product product : products){
                if(may_grow_product((int)product.getLight_energy(), (int)product.getDark_energy())){
                    product.grow();
                }

            }
            return true;
        }else{
            return true;
        }
    }
    public synchronized boolean may_grow_product(int light_energy, int dark_energy){
        if(this.light_energy>=light_energy && this.dark_energy>=dark_energy){
            this.light_energy-=light_energy;
            this.dark_energy-=dark_energy;
            return true;
        }else{
            return false;
        }
    }

    public synchronized void second(){

        if(alive) {
            if(current_health<=0) {
                alive = false;
                current_health=0;
            }else {
                current_stage_second();
                try_grow_up();

                roots_second();
                leaves_second();
                products_second();

                Box.update();
            }
        }

    }

    double water;

    int dark_energy;
    int light_energy;

    public Plant(String name, int maximum_health, int gold_price, int diamond_price){
        alive = true;
        this.name = name;

        this.gold_price = gold_price;
        this.diamond_price = diamond_price;

        water = 0;

        leaves = new LinkedList<>();
        roots = new LinkedList<>();
        products = new LinkedList<>();

        stages = set_stages();

        this.maximum_health = maximum_health;
        current_health=maximum_health/2;

        N_problem_points = 0;
        K_problem_points = 0;
        B_problem_points = 0;
        Ca_problem_points = 0;
        Cu_problem_points = 0;
        Fe_problem_points = 0;
        Mn_problem_points = 0;
        Mo_problem_points = 0;
        Zn_problem_points = 0;
        P_problem_points = 0;
        Mg_problem_points = 0;
        S_problem_points = 0;

        grow_up = true;

    }

    private double N_problem_points;
    private double P_problem_points;
    private double K_problem_points;
    private double S_problem_points;
    private double Mg_problem_points;
    private double Ca_problem_points;
    private double B_problem_points;
    private double Cu_problem_points;
    private double Fe_problem_points;
    private double Mn_problem_points;
    private double Mo_problem_points;
    private double Zn_problem_points;
    public double getN_problem_points() {
        return N_problem_points;
    }
    public double getP_problem_points() {
        return P_problem_points;
    }
    public double getK_problem_points() {
        return K_problem_points;
    }
    public double getS_problem_points() {
        return S_problem_points;
    }
    public double getMg_problem_points() {
        return Mg_problem_points;
    }
    public double getCa_problem_points() {
        return Ca_problem_points;
    }
    public double getB_problem_points() {
        return B_problem_points;
    }
    public double getCu_problem_points() {
        return Cu_problem_points;
    }
    public double getFe_problem_points() {
        return Fe_problem_points;
    }
    public double getMn_problem_points() {
        return Mn_problem_points;
    }
    public double getMo_problem_points() {
        return Mo_problem_points;
    }
    public double getZn_problem_points() {
        return Zn_problem_points;
    }

    public abstract List<PlantStage> set_stages(); // Получить все стадии растения
    public Image get_image_plant(){
        if(alive) return get_current_stage().getStage_alive_image();
        else return get_current_stage().getStage_dead_image();
    }

    public abstract Leave get_new_leave(); // Получить новый обьект листочка
    public abstract Root get_new_root(); // Получить новый обьект корешочка
    public abstract Product get_new_product(); // Получить новый обьект цветочка или плода или проччего продукта

    public String getName() {
        return name;
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
    public List<Root> getRoots() {
        return roots;
    }
    public List<Leave> getLeaves() {
        return leaves;
    }
    public List<Product> getProducts() {
        return products;
    }
    public double getWater() {
        return water;
    }
    public int getDark_energy() {
        return dark_energy;
    }
    public int getLight_energy() {
        return light_energy;
    }
}
