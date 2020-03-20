package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.plant.Leave;
import com.acidcarpet.hydroponist.plant.PlantStage;
import com.acidcarpet.hydroponist.plant.Product;
import com.acidcarpet.hydroponist.plant.Root;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.Date;
import java.util.List;

public class PlantScreen implements Screen {
    long last_update;
    Game game;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    BitmapFont alice_144_green;
    BitmapFont alice_64_black;

    public void leave_buy_button_click(){}
    public void leave_coin_heal_button_click(){}
    public void leave_ad_heal_button_click(){}

    public void root_buy_button_click(){}
    public void root_coin_heal_button_click(){}
    public void root_ad_heal_button_click(){}

    public void product_buy_button_click(){}
    public void product_coin_heal_button_click(){}
    public void product_ad_heal_button_click(){}

    public void harvest_button_click(){}
    public void kill_button_click(){}
    public void back_button_click(){}


    public PlantScreen(Game game){
        this.game = game;
        last_update = new Date().getTime();
    }

    public Group generate_info_pane(){
            Group out = new Group();


            Image background = new Image(atlas.findRegion("info_pane_background"));
            background.setPosition(0, 0);
            background.setName("info_pane_background");
            out.addActor(background);

            if (Box.getInstance().getPlant() != null) {
                Image hp_bar = generate_plant_hp_bar();
                hp_bar.setPosition(20, 500 - 20-100);
                hp_bar.setName("plant_hp_bar");
                out.addActor(hp_bar);

                Group element_pane = generate_element_pane();
                element_pane.setPosition(20, 500 - 20 - 100 - 20-86.66f);
                element_pane.setName("element_pane");
                out.addActor(element_pane);

                Label plant_name_label = new Label(
                        Box.getInstance().getPlant().getName(),
                        new Label.LabelStyle(alice_144_green, Color.GREEN)
                );
                plant_name_label.setAlignment(Align.center);
                plant_name_label.setName("plant_name");
                plant_name_label.setWrap(true);
                plant_name_label.setBounds(20, 100, 1040, 170);
                out.addActor(plant_name_label);

                Group stages_pane = generate_stage_pane();
                stages_pane.setPosition(20, 20);
                stages_pane.setName("stages_pane");
                out.addActor(stages_pane);

            }

            out.setPosition(20+20, 1920 - 500);
            out.setName("info_pane");
            return out;

    }
    public Image generate_plant_hp_bar(){
        Image hp_bar;
        int percent_hp = (int) (((double)Box.getInstance().getPlant().getCurrent_health()/(double)Box.getInstance().getPlant().getMaximum_health())*100);

        if(percent_hp<=0){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_0_image"));
        }else
        if(percent_hp>=0&&percent_hp<=10){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_10_image"));
        }else
        if(percent_hp>10&&percent_hp<=20){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_20_image"));
        }else
        if(percent_hp>20&&percent_hp<=30){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_30_image"));
        }else
        if(percent_hp>30&&percent_hp<=40){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_40_image"));
        }else
        if(percent_hp>40&&percent_hp<=50){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_50_image"));
        }else
        if(percent_hp>50&&percent_hp<=60){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_60_image"));
        }else
        if(percent_hp>60&&percent_hp<=70){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_70_image"));
        }else
        if(percent_hp>70&&percent_hp<=80){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_80_image"));
        }else
        if(percent_hp>80&&percent_hp<=90){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_90_image"));
        }else
        if(percent_hp>90&&percent_hp<=100){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_100_image"));
        }else{
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_100_image"));
        }

        return hp_bar;
    }
    public Group generate_element_pane(){
        Group out = new Group();

        Image N = generate_N();
        N.setBounds(0, 0, 86.66f, 86.66f);
        out.addActor(N);

        Image P= generate_P();
        P.setBounds(0+(86.66f*1), 0, 86.66f, 86.66f);
        out.addActor(P);

        Image K= generate_K();
        K.setBounds(0+(86.66f*2), 0, 86.66f, 86.66f);
        out.addActor(K);

        Image S= generate_S();
        S.setBounds(0+(86.66f*3), 0, 86.66f, 86.66f);
        out.addActor(S);

        Image Mg= generate_Mg();
        Mg.setBounds(0+(86.66f*4), 0, 86.66f, 86.66f);
        out.addActor(Mg);

        Image Ca= generate_Ca();
        Ca.setBounds(0+(86.66f*5), 0, 86.66f, 86.66f);
        out.addActor(Ca);

        Image B= generate_B();
        B.setBounds(0+(86.66f*6), 0, 86.66f, 86.66f);
        out.addActor(B);

        Image Cu= generate_Cu();
        Cu.setBounds(0+(86.66f*7), 0, 86.66f, 86.66f);
        out.addActor(Cu);

        Image Fe= generate_Fe();
        Fe.setBounds(0+(86.66f*8), 0, 86.66f, 86.66f);
        out.addActor(Fe);

        Image Mn= generate_Mn();
        Mn.setBounds(0+(86.66f*9), 0, 86.66f, 86.66f);
        out.addActor(Mn);

        Image Mo= generate_Mo();
        Mo.setBounds(0+(86.66f*10), 0, 86.66f, 86.66f);
        out.addActor(Mo);

        Image Zn= generate_Zn();
        Zn.setBounds(0+(86.66f*11), 0, 86.66f, 86.66f);
        out.addActor(Zn);

        return out;

    }
    public Image generate_N(){
        Image out;
        if(Box.getInstance().getPlant().getElement_N_problem_points() == 0){
            out = new Image(atlas.findRegion("N_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_N_problem_points() >= 0 && Box.getInstance().getPlant().getElement_N_problem_points() <= 100)
                        ||
                (Box.getInstance().getPlant().getElement_N_problem_points() <= 0 && Box.getInstance().getPlant().getElement_N_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("N_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_N_problem_points() >= 100 && Box.getInstance().getPlant().getElement_N_problem_points() <= 200)
                        ||
                (Box.getInstance().getPlant().getElement_N_problem_points() <= -100 && Box.getInstance().getPlant().getElement_N_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("N_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_N_problem_points() >= 200 && Box.getInstance().getPlant().getElement_N_problem_points() <= 300)
                        ||
                (Box.getInstance().getPlant().getElement_N_problem_points() <= -200 && Box.getInstance().getPlant().getElement_N_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("N_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_N_problem_points() >= 300 && Box.getInstance().getPlant().getElement_N_problem_points() <= 400)
                        ||
                (Box.getInstance().getPlant().getElement_N_problem_points() <= -300 && Box.getInstance().getPlant().getElement_N_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("N_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_N_problem_points() >= 400
                        ||
                Box.getInstance().getPlant().getElement_N_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("N_5_icon"));
        }else out = new Image(atlas.findRegion("N_disabled_icon"));

        return out;
    }
    public Image generate_P(){
        Image out;
        if(Box.getInstance().getPlant().getElement_P_problem_points() == 0){
            out = new Image(atlas.findRegion("P_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_P_problem_points() >= 0 && Box.getInstance().getPlant().getElement_P_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_P_problem_points() <= 0 && Box.getInstance().getPlant().getElement_P_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("P_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_P_problem_points() >= 100 && Box.getInstance().getPlant().getElement_P_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_P_problem_points() <= -100 && Box.getInstance().getPlant().getElement_P_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("P_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_P_problem_points() >= 200 && Box.getInstance().getPlant().getElement_P_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_P_problem_points() <= -200 && Box.getInstance().getPlant().getElement_P_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("P_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_P_problem_points() >= 300 && Box.getInstance().getPlant().getElement_P_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_P_problem_points() <= -300 && Box.getInstance().getPlant().getElement_P_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("P_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_P_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_P_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("P_5_icon"));
        }else out = new Image(atlas.findRegion("P_disabled_icon"));

        return out;
    }
    public Image generate_K(){
        Image out;
        if(Box.getInstance().getPlant().getElement_K_problem_points() == 0){
            out = new Image(atlas.findRegion("K_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_K_problem_points() >= 0 && Box.getInstance().getPlant().getElement_K_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_K_problem_points() <= 0 && Box.getInstance().getPlant().getElement_K_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("K_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_K_problem_points() >= 100 && Box.getInstance().getPlant().getElement_K_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_K_problem_points() <= -100 && Box.getInstance().getPlant().getElement_K_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("K_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_K_problem_points() >= 200 && Box.getInstance().getPlant().getElement_K_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_K_problem_points() <= -200 && Box.getInstance().getPlant().getElement_K_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("K_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_K_problem_points() >= 300 && Box.getInstance().getPlant().getElement_K_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_K_problem_points() <= -300 && Box.getInstance().getPlant().getElement_K_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("K_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_K_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_K_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("K_5_icon"));
        }else out = new Image(atlas.findRegion("K_disabled_icon"));

        return out;
    }
    public Image generate_S(){
        Image out;
        if(Box.getInstance().getPlant().getElement_S_problem_points() == 0){
            out = new Image(atlas.findRegion("S_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_S_problem_points() >= 0 && Box.getInstance().getPlant().getElement_S_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_S_problem_points() <= 0 && Box.getInstance().getPlant().getElement_S_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("S_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_S_problem_points() >= 100 && Box.getInstance().getPlant().getElement_S_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_S_problem_points() <= -100 && Box.getInstance().getPlant().getElement_S_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("S_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_S_problem_points() >= 200 && Box.getInstance().getPlant().getElement_S_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_S_problem_points() <= -200 && Box.getInstance().getPlant().getElement_S_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("S_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_S_problem_points() >= 300 && Box.getInstance().getPlant().getElement_S_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_S_problem_points() <= -300 && Box.getInstance().getPlant().getElement_S_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("S_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_S_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_S_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("S_5_icon"));
        }else out = new Image(atlas.findRegion("S_disabled_icon"));

        return out;
    }
    public Image generate_Mg(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Mg_problem_points() == 0){
            out = new Image(atlas.findRegion("Mg_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mg_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Mg_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Mg_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Mg_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Mg_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mg_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Mg_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Mg_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Mg_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Mg_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mg_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Mg_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Mg_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Mg_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Mg_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mg_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Mg_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Mg_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Mg_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Mg_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Mg_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Mg_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Mg_5_icon"));
        }else out = new Image(atlas.findRegion("Mg_disabled_icon"));

        return out;
    }
    public Image generate_Ca(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Ca_problem_points() == 0){
            out = new Image(atlas.findRegion("Ca_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Ca_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Ca_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Ca_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Ca_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Ca_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Ca_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Ca_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Ca_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Ca_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Ca_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Ca_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Ca_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Ca_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Ca_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Ca_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Ca_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Ca_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Ca_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Ca_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Ca_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Ca_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Ca_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Ca_5_icon"));
        }else out = new Image(atlas.findRegion("Ca_disabled_icon"));

        return out;
    }
    public Image generate_B(){
        Image out;
        if(Box.getInstance().getPlant().getElement_B_problem_points() == 0){
            out = new Image(atlas.findRegion("B_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_B_problem_points() >= 0 && Box.getInstance().getPlant().getElement_B_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_B_problem_points() <= 0 && Box.getInstance().getPlant().getElement_B_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("B_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_B_problem_points() >= 100 && Box.getInstance().getPlant().getElement_B_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_B_problem_points() <= -100 && Box.getInstance().getPlant().getElement_B_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("B_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_B_problem_points() >= 200 && Box.getInstance().getPlant().getElement_B_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_B_problem_points() <= -200 && Box.getInstance().getPlant().getElement_B_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("B_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_B_problem_points() >= 300 && Box.getInstance().getPlant().getElement_B_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_B_problem_points() <= -300 && Box.getInstance().getPlant().getElement_B_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("B_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_B_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_B_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("B_5_icon"));
        }else out = new Image(atlas.findRegion("B_disabled_icon"));

        return out;
    }
    public Image generate_Cu(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Cu_problem_points() == 0){
            out = new Image(atlas.findRegion("Cu_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Cu_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Cu_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Cu_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Cu_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Cu_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Cu_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Cu_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Cu_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Cu_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Cu_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Cu_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Cu_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Cu_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Cu_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Cu_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Cu_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Cu_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Cu_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Cu_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Cu_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Cu_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Cu_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Cu_5_icon"));
        }else out = new Image(atlas.findRegion("Cu_disabled_icon"));

        return out;
    }
    public Image generate_Fe(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Fe_problem_points() == 0){
            out = new Image(atlas.findRegion("Fe_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Fe_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Fe_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Fe_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Fe_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Fe_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Fe_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Fe_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Fe_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Fe_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Fe_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Fe_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Fe_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Fe_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Fe_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Fe_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Fe_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Fe_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Fe_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Fe_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Fe_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Fe_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Fe_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Fe_5_icon"));
        }else out = new Image(atlas.findRegion("Fe_disabled_icon"));

        return out;
    }
    public Image generate_Mn(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Mn_problem_points() == 0){
            out = new Image(atlas.findRegion("Mn_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mn_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Mn_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Mn_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Mn_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Mn_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mn_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Mn_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Mn_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Mn_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Mn_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mn_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Mn_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Mn_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Mn_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Mn_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mn_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Mn_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Mn_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Mn_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Mn_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Mn_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Mn_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Mn_5_icon"));
        }else out = new Image(atlas.findRegion("Mn_disabled_icon"));

        return out;
    }
    public Image generate_Mo(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Mo_problem_points() == 0){
            out = new Image(atlas.findRegion("Mo_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mo_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Mo_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Mo_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Mo_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Mo_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mo_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Mo_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Mo_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Mo_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Mo_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mo_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Mo_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Mo_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Mo_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Mo_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mo_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Mo_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Mo_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Mo_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Mo_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Mo_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Mo_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Mo_5_icon"));
        }else out = new Image(atlas.findRegion("Mo_disabled_icon"));

        return out;
    }
    public Image generate_Zn(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Zn_problem_points() == 0){
            out = new Image(atlas.findRegion("Zn_0_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Zn_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Zn_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Zn_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Zn_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Zn_1_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Zn_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Zn_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Zn_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Zn_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Zn_2_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Zn_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Zn_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Zn_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Zn_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Zn_3_icon"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Zn_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Zn_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Zn_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Zn_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Zn_4_icon"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Zn_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Zn_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Zn_5_icon"));
        }else out = new Image(atlas.findRegion("Zn_disabled_icon"));

        return out;
    }
    public Group generate_stage_pane(){
        Group out = new Group();

        List<PlantStage> list = Box.getInstance().getPlant().getStages();

        int x = 0;
        for(PlantStage stage : list){
            Image stage_image = null;
            if(Box.getInstance().getPlant().get_current_stage().equals(stage)){
                switch (stage.getType()){
                    case SEED: stage_image = new Image(atlas.findRegion("seed_stage_current")); break;
                    case SOAKING: stage_image = new Image(atlas.findRegion("soaking_stage_current")); break;
                    case PRE_VEGETATION: stage_image = new Image(atlas.findRegion("pre_vegetation_stage_current")); break;
                    case VEGETATION: stage_image = new Image(atlas.findRegion("vegetation_stage_current")); break;
                    case POST_VEGETATION: stage_image = new Image(atlas.findRegion("post_vegetation_stage_current")); break;
                    case PRE_BLOOM: stage_image = new Image(atlas.findRegion("pre_bloom_stage_current")); break;
                    case BLOOM: stage_image = new Image(atlas.findRegion("bloom_stage_current")); break;
                    case POST_BLOOM: stage_image = new Image(atlas.findRegion("post_bloom_stage_current")); break;
                    case HARVEST: stage_image = new Image(atlas.findRegion("harvest_stage_current")); break;
                }
            }else
            if(stage.isActive()){
                switch (stage.getType()){
                    case SEED: stage_image = new Image(atlas.findRegion("seed_stage_enable")); break;
                    case SOAKING: stage_image = new Image(atlas.findRegion("soaking_stage_enable")); break;
                    case PRE_VEGETATION: stage_image = new Image(atlas.findRegion("pre_vegetation_stage_enable")); break;
                    case VEGETATION: stage_image = new Image(atlas.findRegion("vegetation_stage_enable")); break;
                    case POST_VEGETATION: stage_image = new Image(atlas.findRegion("post_vegetation_stage_enable")); break;
                    case PRE_BLOOM: stage_image = new Image(atlas.findRegion("pre_bloom_stage_enable")); break;
                    case BLOOM: stage_image = new Image(atlas.findRegion("bloom_stage_enable")); break;
                    case POST_BLOOM: stage_image = new Image(atlas.findRegion("post_bloom_stage_enable")); break;
                    case HARVEST: stage_image = new Image(atlas.findRegion("harvest_stage_enable")); break;
                }
            }else{
                switch (stage.getType()){
                    case SEED: stage_image = new Image(atlas.findRegion("seed_stage_disable")); break;
                    case SOAKING: stage_image = new Image(atlas.findRegion("soaking_stage_disable")); break;
                    case PRE_VEGETATION: stage_image = new Image(atlas.findRegion("pre_vegetation_stage_disable")); break;
                    case VEGETATION: stage_image = new Image(atlas.findRegion("vegetation_stage_disable")); break;
                    case POST_VEGETATION: stage_image = new Image(atlas.findRegion("post_vegetation_stage_disable")); break;
                    case PRE_BLOOM: stage_image = new Image(atlas.findRegion("pre_bloom_stage_disable")); break;
                    case BLOOM: stage_image = new Image(atlas.findRegion("bloom_stage_disable")); break;
                    case POST_BLOOM: stage_image = new Image(atlas.findRegion("post_bloom_stage_disable")); break;
                    case HARVEST: stage_image = new Image(atlas.findRegion("harvest_stage_disable")); break;
                }
            }
            stage_image.setBounds(x, 0, 100, 100);
            out.addActor(stage_image);
            x+=100;
        }


        return out;
    }

    public Group generate_leaves_pane(){
           Group out = new Group();


        Image background = new Image(atlas.findRegion("leaves_pane_background"));
        background.setPosition(0, 0);
        background.setName("leaves_pane_background");
        out.addActor(background);

        ImageButton leaves_buy_button = new ImageButton(skin, "buy_button");
        leaves_buy_button.setBounds(1080-20-250, 415-20-125, 250, 125);
        leaves_buy_button.setName("leaves_buy_button");
        leaves_buy_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                leave_buy_button_click();
            }
        });
        out.addActor(leaves_buy_button);

        ImageButton leaves_coin_heal_button = new ImageButton(skin, "coin_heal_button");
        leaves_coin_heal_button.setBounds(1080-20-250, 415-20-125-125, 250, 125);
        leaves_coin_heal_button.setName("leaves_coin_heal_button");
        leaves_coin_heal_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                leave_coin_heal_button_click();
            }
        });
        out.addActor(leaves_coin_heal_button);

        ImageButton leaves_ad_heal_button = new ImageButton(skin, "ad_heal_button");
        leaves_ad_heal_button.setBounds(1080-20-250, 415-20-125-125-125, 250, 125);
        leaves_ad_heal_button.setName("leaves_ad_heal_button");
        leaves_ad_heal_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                leave_ad_heal_button_click();
            }
        });
        out.addActor(leaves_ad_heal_button);

        Table table = new Table();
        table.defaults().width(250).height(375);

        for (Leave leave : Box.getInstance().getPlant().getLeaves()){
            table.add(generate_leave(leave));
        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(false, true);
        pane.setBounds(20 ,20 ,1080-20-20-250-20 , 375);
        out.addActor(pane);


        out.setPosition(20+20, 1920-500-415);
        out.setName("leaves_pane");
        return out;

    }
    public Group generate_leave(Leave leave){
        Group out = new Group();

        Image pane = new Image(atlas.findRegion("leave_pane"));
        pane.setBounds(0, 0, 250, 375);
        out.addActor(pane);

        Image hp;

        if(leave.isAlive()){

            int percent = (int)(((double)leave.getCurrent_health()/(double)leave.getMaximum_health())*100);

            if(percent==0){
                hp = new Image(atlas.findRegion("item_hp_bar_0_image"));
            }else
            if(percent>=0&&percent<=10){
                hp = new Image(atlas.findRegion("item_hp_bar_10_image"));
            }else
            if(percent>=10&&percent<=20){
                hp = new Image(atlas.findRegion("item_hp_bar_20_image"));
            }else
            if(percent>=20&&percent<=30){
                hp = new Image(atlas.findRegion("item_hp_bar_30_image"));
            }else
            if(percent>=30&&percent<=40){
                hp = new Image(atlas.findRegion("item_hp_bar_40_image"));
            }else
            if(percent>=40&&percent<=50){
                hp = new Image(atlas.findRegion("item_hp_bar_50_image"));
            }else
            if(percent>=50&&percent<=60){
                hp = new Image(atlas.findRegion("item_hp_bar_60_image"));
            }else
            if(percent>=60&&percent<=70){
                hp = new Image(atlas.findRegion("item_hp_bar_70_image"));
            }else
            if(percent>=70&&percent<=80){
                hp = new Image(atlas.findRegion("item_hp_bar_80_image"));
            }else
            if(percent>=80&&percent<=90){
                hp = new Image(atlas.findRegion("item_hp_bar_90_image"));
            }else
            if(percent>=90){
                hp = new Image(atlas.findRegion("item_hp_bar_100_image"));
            }else{
                hp = null;
            }

            hp.setBounds(25, 375-20-50, 200, 50);
            out.addActor(hp);


        }else{

        }

        Label height = new Label(
                leave.getHeight()+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        height.setAlignment(Align.center);
        height.setWrap(true);
        height.setBounds(25, 375-20-50-86.5f, 86.5f, 86.5f);
        out.addActor(height);

        Label width = new Label(
                leave.getWidth()+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        width.setAlignment(Align.center);
        width.setWrap(true);
        width.setBounds(250-25-86.5f, 375-20-50-86.5f, 86.5f, 86.5f);
        out.addActor(width);

        Label light = new Label(
                (int)(leave.getLight_energy_production()*(leave.getHeight()*leave.getWidth()))+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        light.setAlignment(Align.center);
        light.setWrap(false);
        light.setBounds(25, 25, 86.5f, 86.5f);
        out.addActor(light);

        Label dark = new Label(
                (int)(leave.getDark_energy_production()*(leave.getHeight()*leave.getWidth()))+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        dark.setAlignment(Align.center);
        dark.setWrap(false);
        dark.setBounds(250-25-86.5f, 25, 86.5f, 86.5f);
        out.addActor(dark);

        return out;
    }

    public Group generate_roots_pane(){

        Group out = new Group();

        Image background = new Image(atlas.findRegion("roots_pane_background"));
        background.setPosition(0, 0);
        background.setName("roots_pane_background");
        out.addActor(background);

        ImageButton roots_buy_button = new ImageButton(skin, "buy_button");
        roots_buy_button.setBounds(1080-20-250, 415-20-125, 250, 125);
        roots_buy_button.setName("roots_buy_button");
        roots_buy_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                root_buy_button_click();
            }
        });
        out.addActor(roots_buy_button);

        ImageButton roots_coin_heal_button = new ImageButton(skin, "coin_heal_button");
        roots_coin_heal_button.setBounds(1080-20-250, 415-20-125-125, 250, 125);
        roots_coin_heal_button.setName("roots_coin_heal_button");
        roots_coin_heal_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                root_coin_heal_button_click();
            }
        });
        out.addActor(roots_coin_heal_button);

        ImageButton roots_ad_heal_button = new ImageButton(skin, "ad_heal_button");
        roots_ad_heal_button.setBounds(1080-20-250, 415-20-125-125-125, 250, 125);
        roots_ad_heal_button.setName("roots_ad_heal_button");
        roots_ad_heal_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                root_ad_heal_button_click();
            }
        });
        out.addActor(roots_ad_heal_button);

        Table table = new Table();
        table.defaults().width(250).height(375);

        for (Root root : Box.getInstance().getPlant().getRoots()){
            table.add(generate_root(root));
        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(false, true);
        pane.setBounds(20 ,20 ,1080-20-20-250-20 , 375);
        out.addActor(pane);


        out.setPosition(20+20, 1920-500-415-415);
        out.setName("roots_pane");
        return out;

    }
    public Group generate_root(Root root){
        Group out = new Group();

        Image pane = new Image(atlas.findRegion("root_pane"));
        pane.setBounds(0, 0, 250, 375);
        out.addActor(pane);

        Image hp;

        if(root.isAlive()){

            int percent = (int)(((double)root.getCurrent_health()/(double)root.getMaximum_health())*100);

            if(percent==0){
                hp = new Image(atlas.findRegion("item_hp_bar_0_image"));
            }else
            if(percent>=0&&percent<=10){
                hp = new Image(atlas.findRegion("item_hp_bar_10_image"));
            }else
            if(percent>=10&&percent<=20){
                hp = new Image(atlas.findRegion("item_hp_bar_20_image"));
            }else
            if(percent>=20&&percent<=30){
                hp = new Image(atlas.findRegion("item_hp_bar_30_image"));
            }else
            if(percent>=30&&percent<=40){
                hp = new Image(atlas.findRegion("item_hp_bar_40_image"));
            }else
            if(percent>=40&&percent<=50){
                hp = new Image(atlas.findRegion("item_hp_bar_50_image"));
            }else
            if(percent>=50&&percent<=60){
                hp = new Image(atlas.findRegion("item_hp_bar_60_image"));
            }else
            if(percent>=60&&percent<=70){
                hp = new Image(atlas.findRegion("item_hp_bar_70_image"));
            }else
            if(percent>=70&&percent<=80){
                hp = new Image(atlas.findRegion("item_hp_bar_80_image"));
            }else
            if(percent>=80&&percent<=90){
                hp = new Image(atlas.findRegion("item_hp_bar_90_image"));
            }else
            if(percent>=90){
                hp = new Image(atlas.findRegion("item_hp_bar_100_image"));
            }else{
                hp = null;
            }

            hp.setBounds(25, 375-20-50, 200 ,50);
            out.addActor(hp);


        }else{

        }

        Label length = new Label(
                root.getLength()+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        length.setAlignment(Align.center);
        length.setWrap(true);
        length.setBounds(25, 375-20-50-86.5f, 86.5f, 86.5f);
        out.addActor(length);

        Label water = new Label(
                root.getWater_volume_multiplier()*root.getLength()+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        water.setAlignment(Align.center);
        water.setWrap(true);
        water.setBounds(250-25-86.5f, 25, 86.5f, 86.5f);
        out.addActor(water);

        return out;
    }

    public Group generate_products_pane(){

            Group out = new Group();


        Image background = new Image(atlas.findRegion("products_pane_background"));
        background.setPosition(0, 0);
        background.setName("products_pane_background");
        out.addActor(background);

        ImageButton products_buy_button = new ImageButton(skin, "buy_button");
        products_buy_button.setBounds(1080-20-250, 415-20-125, 250, 125);
        products_buy_button.setName("products_buy_button");
        products_buy_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                product_buy_button_click();
            }
        });
        out.addActor(products_buy_button);

        ImageButton products_coin_heal_button = new ImageButton(skin, "coin_heal_button");
        products_coin_heal_button.setBounds(1080-20-250, 415-20-125-125, 250, 125);
        products_coin_heal_button.setName("products_coin_heal_button");
        products_coin_heal_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                product_coin_heal_button_click();
            }
        });
        out.addActor(products_coin_heal_button);

        ImageButton products_ad_heal_button = new ImageButton(skin, "ad_heal_button");
        products_ad_heal_button.setBounds(1080-20-250, 415-20-125-125-125, 250, 125);
        products_ad_heal_button.setName("products_ad_heal_button");
        products_ad_heal_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                product_ad_heal_button_click();
            }
        });
        out.addActor(products_ad_heal_button);

        Table table = new Table();
        table.defaults().width(250).height(375);

        for (Product product : Box.getInstance().getPlant().getProducts()){
            table.add(generate_product(product));
        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(false, true);
        pane.setBounds(20 ,20 ,1080-20-20-250-20 , 375);
        out.addActor(pane);


        out.setPosition(20+20, 1920-500-415-415-415);
        out.setName("products_pane");
        return out;

    }
    public Group generate_product(Product product){
        Group out = new Group();

        Image pane = new Image(atlas.findRegion("product_pane"));
        pane.setBounds(0, 0, 250, 375);
        out.addActor(pane);
//        Image hp;
//
//
//
//            int percent = (int)((product.getCurrent_health()/product.getMaximum_health())*10);
//
//            if(percent==0){
//                hp = new Image(atlas.findRegion("item_hp_bar_0"));
//            }else
//            if(percent>=0&&percent<=10){
//                hp = new Image(atlas.findRegion("item_hp_bar_10"));
//            }else
//            if(percent>=10&&percent<=20){
//                hp = new Image(atlas.findRegion("item_hp_bar_20"));
//            }else
//            if(percent>=20&&percent<=30){
//                hp = new Image(atlas.findRegion("item_hp_bar_30"));
//            }else
//            if(percent>=30&&percent<=40){
//                hp = new Image(atlas.findRegion("item_hp_bar_40"));
//            }else
//            if(percent>=40&&percent<=50){
//                hp = new Image(atlas.findRegion("item_hp_bar_50"));
//            }else
//            if(percent>=50&&percent<=60){
//                hp = new Image(atlas.findRegion("item_hp_bar_60"));
//            }else
//            if(percent>=60&&percent<=70){
//                hp = new Image(atlas.findRegion("item_hp_bar_70"));
//            }else
//            if(percent>=70&&percent<=80){
//                hp = new Image(atlas.findRegion("item_hp_bar_80"));
//            }else
//            if(percent>=80&&percent<=90){
//                hp = new Image(atlas.findRegion("item_hp_bar_90"));
//            }else
//            if(percent>=90){
//                hp = new Image(atlas.findRegion("item_hp_bar_100"));
//            }else{
//                hp = null;
//            }
//
//            hp.setPosition(20, 375-20-200);
//            out.addActor(hp);

        Label lvl = new Label(
                product.getLvl()+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        lvl.setAlignment(Align.center);
        lvl.setWrap(false);
        lvl.setBounds(25, 375-20-50-86.5f, 86.5f, 86.5f);
        out.addActor(lvl);

        Label price = new Label(
                product.getPrice()+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        price.setAlignment(Align.center);
        price.setWrap(false);
        price.setBounds(250-25-86.5f, 25, 86.5f, 86.5f);
        out.addActor(price);

        return out;
    }

    public Group generate_buttons_pane(){

            Group out = new Group();


        Image background = new Image(atlas.findRegion("buttons_pane_background"));
        background.setPosition(0, 0);
        background.setName("buttons_pane_background");
        out.addActor(background);

        ImageButton harvest_button = new ImageButton(skin, "harvest_button");
        harvest_button.setBounds(20, 20, 250, 125);
        harvest_button.setName("harvest_buy_button");
        harvest_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                harvest_button_click();
            }
        });
        out.addActor(harvest_button);

        ImageButton kill_button = new ImageButton(skin, "kill_button");
        kill_button.setBounds(20+250+20, 20, 250, 125);
        kill_button.setName("kill_button");
        kill_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                kill_button_click();
            }
        });
        out.addActor(kill_button);

        ImageButton back_button = new ImageButton(skin, "back_button");
        back_button.setBounds(1080-20-500, 20, 500, 125);
        back_button.setName("back_button");
        back_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                back_button_click();
            }
        });
        out.addActor(back_button);

        out.setName("buttons_pane");
        out.setPosition(20+20, 0);
        return out;

    }


    @Override
    public void show() {
        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = ScreenAssets.getInstance().getPlantScreen_atlas();
        skin = ScreenAssets.getInstance().getPlantScreen_skin();
        Gdx.input.setInputProcessor(stage);

        alice_144_green = ScreenAssets.getInstance().alice_144_green;
        alice_64_black = ScreenAssets.getInstance().alice_64_black;

        Image background = new Image(atlas.findRegion("background"));
        background.setName("background");
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());

        stage.addActor(background);

        stage.addActor(generate_info_pane());
        stage.addActor(generate_leaves_pane());
        stage.addActor(generate_roots_pane());
        stage.addActor(generate_products_pane());
        stage.addActor(generate_buttons_pane());

    }

    @Override
    public void render(float delta) {
//        if(last_update!=Box.get_last_update()){
//
//            stage.getRoot().findActor("info_pane").clear();
//            stage.getRoot().removeActor(stage.getRoot().findActor("info_pane"));
//            stage.getRoot().addActor(generate_info_pane());
//
//            stage.getRoot().findActor("leaves_pane").clear();
//            stage.getRoot().removeActor(stage.getRoot().findActor("leaves_pane"));
//            stage.getRoot().addActor(generate_leaves_pane());
//
//            stage.getRoot().findActor("roots_pane").clear();
//            stage.getRoot().removeActor(stage.getRoot().findActor("roots_pane"));
//            stage.getRoot().addActor(generate_roots_pane());
//
//            stage.getRoot().findActor("products_pane").clear();
//            stage.getRoot().removeActor(stage.getRoot().findActor("products_pane"));
//            stage.getRoot().addActor(generate_products_pane());
//
//            stage.getRoot().findActor("buttons_pane").clearListeners();
//            stage.getRoot().removeActor(stage.getRoot().findActor("buttons_pane"));
//            stage.getRoot().addActor( generate_buttons_pane());
//
//            last_update = Box.get_last_update();
//        }
//
//
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
