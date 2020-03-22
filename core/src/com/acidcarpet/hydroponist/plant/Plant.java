package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.equipment.WaterPack;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.LinkedList;
import java.util.List;

public abstract class Plant {
    String name;

    private boolean alive;

    private boolean grow_up;
    public void grow_up(){
        if(grow_up==true){

            if(get_current_stage()==null){
                grow_up=false;
                return;
            }else {

                for (int i = 0; i < get_current_stage().getLeaves_add(); i++) {
                    leaves.add(get_new_leave());
                }

                for (int i = 0; i < get_current_stage().getRoots_add(); i++) {
                    roots.add(get_new_root());
                }

                for (int i = 0; i < get_current_stage().getProducts_add(); i++) {
                    products.add(get_new_product());
                }
            }

            grow_up = false;
        }
    }

    private int current_health;
    private int maximum_health;

    private List<PlantStage> stages;
    public PlantStage get_current_stage(){
        for (PlantStage stage : stages){
            if(stage.isActive()){
                return stage;
            }
        }
        return null;
    }
    public boolean current_stage_second(){
        if(!alive) return false;
        if(get_current_stage()!=null){
            get_current_stage().second();
            return true;
        }else{
            return false;
        }
    }

    private List<Root> roots;
    public boolean roots_second(){
        if(!alive) return false;

        if(!roots.isEmpty()){

            for (Root root : roots){
                root.absorb();
            }
            return true;

        }else {
            return false;
        }
    }
    public synchronized void add_root_pack(WaterPack pack) {
        if (!alive) return;
        if(get_current_stage()==null) return;

        if((pack.element_ppm_N()>=get_current_stage().getPpm_N_min()&&pack.element_ppm_N()<=get_current_stage().getPpm_N_max())){
            N_problem_points--;
            if(N_problem_points<=0) {
                N_problem_points=0;

            }
        }else{
            N_problem_points++;
            if(N_problem_points>=100) {
                N_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }
        if((pack.element_ppm_P()>=get_current_stage().getPpm_P_min()&&pack.element_ppm_P()<=get_current_stage().getPpm_P_max())){
            P_problem_points--;
            if(P_problem_points<=0) {
                P_problem_points=0;

            }
        }else{
            P_problem_points++;
            if(P_problem_points>=100) {
                P_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }
        if((pack.element_ppm_K()>=get_current_stage().getPpm_K_min()&&pack.element_ppm_K()<=get_current_stage().getPpm_K_max())){
            K_problem_points--;
            if(K_problem_points<=0) {
                K_problem_points=0;

            }
        }else{
            K_problem_points++;
            if(K_problem_points>=100) {
                K_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }

        if((pack.element_ppm_S()>=get_current_stage().getPpm_S_min()&&pack.element_ppm_S()<=get_current_stage().getPpm_S_max())){
            S_problem_points--;
            if(S_problem_points<=0) {
                S_problem_points=0;

            }
        }else{
            S_problem_points++;
            if(S_problem_points>=100) {
                S_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }
        if((pack.element_ppm_Mg()>=get_current_stage().getPpm_Mg_min()&&pack.element_ppm_Mg()<=get_current_stage().getPpm_Mg_max())){
            Mg_problem_points--;
            if(Mg_problem_points<=0) {
                Mg_problem_points=0;

            }
        }else{
            Mg_problem_points++;
            if(Mg_problem_points>=100) {
                Mg_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }
        if((pack.element_ppm_Ca()>=get_current_stage().getPpm_Ca_min()&&pack.element_ppm_Ca()<=get_current_stage().getPpm_Ca_max())){
            Ca_problem_points--;
            if(Ca_problem_points<=0) {
                Ca_problem_points=0;

            }
        }else{
            Ca_problem_points++;
            if(Ca_problem_points>=100) {
                Ca_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }

        if((pack.element_ppm_B()>=get_current_stage().getPpm_B_min()&&pack.element_ppm_B()<=get_current_stage().getPpm_B_max())){
            B_problem_points--;
            if(B_problem_points<=0) {
                B_problem_points=0;

            }
        }else{
            B_problem_points++;
            if(B_problem_points>=100) {
                B_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }
        if((pack.element_ppm_Cu()>=get_current_stage().getPpm_Cu_min()&&pack.element_ppm_Cu()<=get_current_stage().getPpm_Cu_max())){
            Cu_problem_points--;
            if(Cu_problem_points<=0) {
                Cu_problem_points=0;

            }
        }else{
            Cu_problem_points++;
            if(Cu_problem_points>=100) {
                Cu_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }
        if((pack.element_ppm_Fe()>=get_current_stage().getPpm_Fe_min()&&pack.element_ppm_Fe()<=get_current_stage().getPpm_Fe_max())){
            Fe_problem_points--;
            if(Fe_problem_points<=0) {
                Fe_problem_points=0;

            }
        }else{
            Fe_problem_points++;
            if(Fe_problem_points>=100) {
                Fe_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }

        if((pack.element_ppm_Mn()>=get_current_stage().getPpm_Mn_min()&&pack.element_ppm_Mn()<=get_current_stage().getPpm_Mn_max())){
            Mn_problem_points--;
            if(Mn_problem_points<=0) {
                Mn_problem_points=0;

            }
        }else{
            Mn_problem_points++;
            if(Mn_problem_points>=100) {
                Mn_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }
        if((pack.element_ppm_Mo()>=get_current_stage().getPpm_Mo_min()&&pack.element_ppm_Mo()<=get_current_stage().getPpm_Mo_max())){
            Mo_problem_points--;
            if(Mo_problem_points<=0) {
                Mo_problem_points=0;

            }
        }else{
            Mo_problem_points++;
            if(Mo_problem_points>=100) {
                Mo_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }
        if((pack.element_ppm_Zn()>=get_current_stage().getPpm_Zn_min()&&pack.element_ppm_Zn()<=get_current_stage().getPpm_Zn_max())){
            Zn_problem_points--;
            if(Zn_problem_points<=0) {
                Zn_problem_points=0;

            }
        }else{
            Zn_problem_points++;
            if(Zn_problem_points>=100) {
                Zn_problem_points=100;
                current_health--;
                if(current_health<=0){
                    alive=false;
                    current_health=0;
                }
            }
        }

        water+=pack.getWater_volume();

    }

    private List<Leave> leaves;
    public boolean leaves_second(){
        if(!alive) return false;

        if(!leaves.isEmpty()){
            for (Leave leave : leaves){
                leave.photosynthesis();
            }
            return true;
        }else{
            return false;
        }


    }
    public synchronized boolean may_drink_water(double volume){
        if(water>=volume){
            water-=volume;
            return true;
        }else{
            return false;
        }
    }
    public synchronized void add_dark_energy(int energy){
        dark_energy+=energy;
    }
    public synchronized void add_light_energy(int energy){
        light_energy+=energy;
    }

    private List<Product> products;
    public boolean products_second(){
        if(!alive) return false;

        if(!products.isEmpty()){

            for (Product product : products){
                product.grow();
            }
            return true;
        }else{
            return true;
        }
    }
    public boolean may_grow_product(int light_energy, int dark_energy){
        if(this.light_energy>=light_energy && this.dark_energy>=dark_energy){
            this.light_energy-=light_energy;
            this.dark_energy-=dark_energy;
            return true;
        }else{
            return false;
        }
    }

    double water;

    int dark_energy;
    int light_energy;

    public Plant(String name, int maximum_health){
        alive = true;
        this.name = name;


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
}
