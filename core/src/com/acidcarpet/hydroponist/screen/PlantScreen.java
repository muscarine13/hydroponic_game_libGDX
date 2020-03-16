package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.plant.Leave;
import com.acidcarpet.hydroponist.plant.PlantStage;
import com.acidcarpet.hydroponist.plant.Product;
import com.acidcarpet.hydroponist.plant.Root;
import com.badlogic.gdx.Game;
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

import java.util.List;

public class PlantScreen implements Screen {

    Game game;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    long last_refresh;

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
    //
    public Group generate_info_pane(){
        Group out = new Group();


        Image background = new Image(atlas.findRegion("info_pane_background"));
        background.setPosition(0, 0);
        background.setName("info_pane_background");
        out.addActor(background);

        if(Box.getInstance().getPlant()!=null) {
            Image hp_bar = generate_plant_hp_bar();
            hp_bar.setPosition(20, 500-20);
            hp_bar.setName("plant_hp_bar");
            out.addActor(hp_bar);

            Group element_pane = generate_element_pane();
            element_pane.setPosition(20, 500-20-100-20);
            element_pane.setName("element_pane");

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

        out.setPosition(20, 1920-20-500);
        out.setName("info_pane");
        return out;
    }
    public Image generate_plant_hp_bar(){
        Image hp_bar;
        int percent_hp = (int) ((Box.getInstance().getPlant().getCurrent_health()/Box.getInstance().getPlant().getMaximum_health())*100);

        if(percent_hp<=0){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_0"));
        }else
        if(percent_hp>=0&&percent_hp<=10){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_10"));
        }else
        if(percent_hp>=10&&percent_hp<=20){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_20"));
        }else
        if(percent_hp>=20&&percent_hp<=30){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_30"));
        }else
        if(percent_hp>=30&&percent_hp<=40){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_40"));
        }else
        if(percent_hp>=40&&percent_hp<=50){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_50"));
        }else
        if(percent_hp>=50&&percent_hp<=60){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_60"));
        }else
        if(percent_hp>=60&&percent_hp<=70){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_70"));
        }else
        if(percent_hp>=70&&percent_hp<=80){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_80"));
        }else
        if(percent_hp>=80&&percent_hp<=90){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_90"));
        }else
        if(percent_hp>=90&&percent_hp<=100){
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_100"));
        }else
            hp_bar = new Image(atlas.findRegion("plant_hp_bar_100"));
        return hp_bar;
    }
    public Group generate_element_pane(){
        Group out = new Group();

        Image N = generate_N();
        N.setBounds(0, 0, 86.6f, 86.66f);
        out.addActor(N);

        Image P= generate_P();
        P.setBounds(0+(86.6f*1), 0, 86.6f, 86.66f);
        out.addActor(P);

        Image K= generate_K();
        K.setBounds(0+(86.6f*2), 0, 86.6f, 86.66f);
        out.addActor(K);

        Image S= generate_S();
        S.setBounds(0+(86.6f*3), 0, 86.6f, 86.66f);
        out.addActor(S);

        Image Mg= generate_Mg();
        Mg.setBounds(0+(86.6f*4), 0, 86.6f, 86.66f);
        out.addActor(Mg);

        Image Ca= generate_Ca();
        Ca.setBounds(0+(86.6f*5), 0, 86.6f, 86.66f);
        out.addActor(Ca);

        Image B= generate_B();
        B.setBounds(0+(86.6f*6), 0, 86.6f, 86.66f);
        out.addActor(B);

        Image Cu= generate_Cu();
        Cu.setBounds(0+(86.6f*7), 0, 86.6f, 86.66f);
        out.addActor(Cu);

        Image Fe= generate_Fe();
        Fe.setBounds(0+(86.6f*8), 0, 86.6f, 86.66f);
        out.addActor(Fe);

        Image Mn= generate_Mn();
        Mn.setBounds(0+(86.6f*9), 0, 86.6f, 86.66f);
        out.addActor(Mn);

        Image Mo= generate_Mo();
        Mo.setBounds(0+(86.6f*10), 0, 86.6f, 86.66f);
        out.addActor(Mo);

        Image Zn= generate_Zn();
        Zn.setBounds(0+(86.6f*11), 0, 86.6f, 86.66f);
        out.addActor(Zn);

        return out;

    }
    public Image generate_N(){
        Image out;
        if(Box.getInstance().getPlant().getElement_N_problem_points() == 0){
            out = new Image(atlas.findRegion("N_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_N_problem_points() >= 0 && Box.getInstance().getPlant().getElement_N_problem_points() <= 100)
                        ||
                (Box.getInstance().getPlant().getElement_N_problem_points() <= 0 && Box.getInstance().getPlant().getElement_N_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("N_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_N_problem_points() >= 100 && Box.getInstance().getPlant().getElement_N_problem_points() <= 200)
                        ||
                (Box.getInstance().getPlant().getElement_N_problem_points() <= -100 && Box.getInstance().getPlant().getElement_N_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("N_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_N_problem_points() >= 200 && Box.getInstance().getPlant().getElement_N_problem_points() <= 300)
                        ||
                (Box.getInstance().getPlant().getElement_N_problem_points() <= -200 && Box.getInstance().getPlant().getElement_N_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("N_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_N_problem_points() >= 300 && Box.getInstance().getPlant().getElement_N_problem_points() <= 400)
                        ||
                (Box.getInstance().getPlant().getElement_N_problem_points() <= -300 && Box.getInstance().getPlant().getElement_N_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("N_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_N_problem_points() >= 400
                        ||
                Box.getInstance().getPlant().getElement_N_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("N_5"));
        }else out = new Image(atlas.findRegion("N_disabled"));

        return out;
    }
    public Image generate_P(){
        Image out;
        if(Box.getInstance().getPlant().getElement_P_problem_points() == 0){
            out = new Image(atlas.findRegion("P_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_P_problem_points() >= 0 && Box.getInstance().getPlant().getElement_P_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_P_problem_points() <= 0 && Box.getInstance().getPlant().getElement_P_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("P_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_P_problem_points() >= 100 && Box.getInstance().getPlant().getElement_P_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_P_problem_points() <= -100 && Box.getInstance().getPlant().getElement_P_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("P_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_P_problem_points() >= 200 && Box.getInstance().getPlant().getElement_P_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_P_problem_points() <= -200 && Box.getInstance().getPlant().getElement_P_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("P_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_P_problem_points() >= 300 && Box.getInstance().getPlant().getElement_P_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_P_problem_points() <= -300 && Box.getInstance().getPlant().getElement_P_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("P_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_P_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_P_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("P_5"));
        }else out = new Image(atlas.findRegion("P_disabled"));

        return out;
    }
    public Image generate_K(){
        Image out;
        if(Box.getInstance().getPlant().getElement_K_problem_points() == 0){
            out = new Image(atlas.findRegion("K_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_K_problem_points() >= 0 && Box.getInstance().getPlant().getElement_K_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_K_problem_points() <= 0 && Box.getInstance().getPlant().getElement_K_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("K_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_K_problem_points() >= 100 && Box.getInstance().getPlant().getElement_K_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_K_problem_points() <= -100 && Box.getInstance().getPlant().getElement_K_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("K_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_K_problem_points() >= 200 && Box.getInstance().getPlant().getElement_K_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_K_problem_points() <= -200 && Box.getInstance().getPlant().getElement_K_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("K_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_K_problem_points() >= 300 && Box.getInstance().getPlant().getElement_K_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_K_problem_points() <= -300 && Box.getInstance().getPlant().getElement_K_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("K_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_K_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_K_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("K_5"));
        }else out = new Image(atlas.findRegion("K_disabled"));

        return out;
    }
    public Image generate_S(){
        Image out;
        if(Box.getInstance().getPlant().getElement_S_problem_points() == 0){
            out = new Image(atlas.findRegion("S_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_S_problem_points() >= 0 && Box.getInstance().getPlant().getElement_S_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_S_problem_points() <= 0 && Box.getInstance().getPlant().getElement_S_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("S_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_S_problem_points() >= 100 && Box.getInstance().getPlant().getElement_S_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_S_problem_points() <= -100 && Box.getInstance().getPlant().getElement_S_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("S_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_S_problem_points() >= 200 && Box.getInstance().getPlant().getElement_S_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_S_problem_points() <= -200 && Box.getInstance().getPlant().getElement_S_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("S_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_S_problem_points() >= 300 && Box.getInstance().getPlant().getElement_S_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_S_problem_points() <= -300 && Box.getInstance().getPlant().getElement_S_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("S_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_S_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_S_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("S_5"));
        }else out = new Image(atlas.findRegion("S_disabled"));

        return out;
    }
    public Image generate_Mg(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Mg_problem_points() == 0){
            out = new Image(atlas.findRegion("Mg_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mg_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Mg_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Mg_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Mg_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Mg_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mg_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Mg_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Mg_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Mg_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Mg_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mg_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Mg_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Mg_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Mg_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Mg_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mg_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Mg_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Mg_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Mg_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Mg_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Mg_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Mg_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Mg_5"));
        }else out = new Image(atlas.findRegion("Mg_disabled"));

        return out;
    }
    public Image generate_Ca(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Ca_problem_points() == 0){
            out = new Image(atlas.findRegion("Ca_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Ca_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Ca_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Ca_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Ca_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Ca_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Ca_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Ca_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Ca_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Ca_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Ca_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Ca_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Ca_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Ca_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Ca_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Ca_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Ca_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Ca_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Ca_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Ca_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Ca_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Ca_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Ca_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Ca_5"));
        }else out = new Image(atlas.findRegion("Ca_disabled"));

        return out;
    }
    public Image generate_B(){
        Image out;
        if(Box.getInstance().getPlant().getElement_B_problem_points() == 0){
            out = new Image(atlas.findRegion("B_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_B_problem_points() >= 0 && Box.getInstance().getPlant().getElement_B_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_B_problem_points() <= 0 && Box.getInstance().getPlant().getElement_B_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("B_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_B_problem_points() >= 100 && Box.getInstance().getPlant().getElement_B_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_B_problem_points() <= -100 && Box.getInstance().getPlant().getElement_B_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("B_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_B_problem_points() >= 200 && Box.getInstance().getPlant().getElement_B_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_B_problem_points() <= -200 && Box.getInstance().getPlant().getElement_B_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("B_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_B_problem_points() >= 300 && Box.getInstance().getPlant().getElement_B_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_B_problem_points() <= -300 && Box.getInstance().getPlant().getElement_B_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("B_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_B_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_B_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("B_5"));
        }else out = new Image(atlas.findRegion("B_disabled"));

        return out;
    }
    public Image generate_Cu(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Cu_problem_points() == 0){
            out = new Image(atlas.findRegion("Cu_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Cu_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Cu_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Cu_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Cu_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Cu_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Cu_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Cu_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Cu_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Cu_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Cu_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Cu_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Cu_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Cu_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Cu_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Cu_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Cu_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Cu_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Cu_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Cu_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Cu_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Cu_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Cu_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Cu_5"));
        }else out = new Image(atlas.findRegion("Cu_disabled"));

        return out;
    }
    public Image generate_Fe(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Fe_problem_points() == 0){
            out = new Image(atlas.findRegion("Fe_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Fe_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Fe_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Fe_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Fe_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Fe_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Fe_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Fe_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Fe_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Fe_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Fe_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Fe_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Fe_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Fe_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Fe_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Fe_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Fe_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Fe_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Fe_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Fe_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Fe_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Fe_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Fe_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Fe_5"));
        }else out = new Image(atlas.findRegion("Fe_disabled"));

        return out;
    }
    public Image generate_Mn(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Mn_problem_points() == 0){
            out = new Image(atlas.findRegion("Mn_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mn_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Mn_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Mn_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Mn_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Mn_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mn_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Mn_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Mn_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Mn_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Mn_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mn_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Mn_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Mn_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Mn_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Mn_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mn_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Mn_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Mn_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Mn_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Mn_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Mn_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Mn_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Mn_5"));
        }else out = new Image(atlas.findRegion("Mn_disabled"));

        return out;
    }
    public Image generate_Mo(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Mo_problem_points() == 0){
            out = new Image(atlas.findRegion("Mo_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mo_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Mo_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Mo_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Mo_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Mo_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mo_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Mo_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Mo_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Mo_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Mo_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mo_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Mo_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Mo_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Mo_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Mo_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Mo_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Mo_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Mo_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Mo_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Mo_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Mo_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Mo_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Mo_5"));
        }else out = new Image(atlas.findRegion("Mo_disabled"));

        return out;
    }
    public Image generate_Zn(){
        Image out;
        if(Box.getInstance().getPlant().getElement_Zn_problem_points() == 0){
            out = new Image(atlas.findRegion("Zn_0"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Zn_problem_points() >= 0 && Box.getInstance().getPlant().getElement_Zn_problem_points() <= 100)
                        ||
                        (Box.getInstance().getPlant().getElement_Zn_problem_points() <= 0 && Box.getInstance().getPlant().getElement_Zn_problem_points() >= -100)
        ){
            out= new Image(atlas.findRegion("Zn_1"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Zn_problem_points() >= 100 && Box.getInstance().getPlant().getElement_Zn_problem_points() <= 200)
                        ||
                        (Box.getInstance().getPlant().getElement_Zn_problem_points() <= -100 && Box.getInstance().getPlant().getElement_Zn_problem_points() >= -200)
        ){
            out = new Image(atlas.findRegion("Zn_2"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Zn_problem_points() >= 200 && Box.getInstance().getPlant().getElement_Zn_problem_points() <= 300)
                        ||
                        (Box.getInstance().getPlant().getElement_Zn_problem_points() <= -200 && Box.getInstance().getPlant().getElement_Zn_problem_points() >= -300)
        ){
            out = new Image(atlas.findRegion("Zn_3"));
        }else
        if(
                (Box.getInstance().getPlant().getElement_Zn_problem_points() >= 300 && Box.getInstance().getPlant().getElement_Zn_problem_points() <= 400)
                        ||
                        (Box.getInstance().getPlant().getElement_Zn_problem_points() <= -300 && Box.getInstance().getPlant().getElement_Zn_problem_points() >= -400)
        ){
            out = new Image(atlas.findRegion("Zn_4"));
        }else
        if(
                Box.getInstance().getPlant().getElement_Zn_problem_points() >= 400
                        ||
                        Box.getInstance().getPlant().getElement_Zn_problem_points() <= -400
        ){
            out = new Image(atlas.findRegion("Zn_5"));
        }else out = new Image(atlas.findRegion("Zn_disabled"));

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


        Image background = new Image(atlas.findRegion("leave_pane_background"));
        background.setPosition(0, 0);
        background.setName("leave_pane_background");
        out.addActor(background);


        ImageButton leaves_buy_button = new ImageButton(skin, "buy_button");
        leaves_buy_button.setBounds(1080-20-250, 415-20-125, 250, 150);
        leaves_buy_button.setName("leaves_buy_button");
        leaves_buy_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                leave_buy_button_click();
            }
        });
        out.addActor(leaves_buy_button);

        ImageButton leaves_coin_heal_button = new ImageButton(skin, "coin_heal_button");
        leaves_coin_heal_button.setBounds(1080-20-250, 415-20-125-125, 250, 150);
        leaves_coin_heal_button.setName("leaves_coin_heal_button");
        leaves_coin_heal_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                leave_coin_heal_button_click();
            }
        });
        out.addActor(leaves_coin_heal_button);

        ImageButton leaves_ad_heal_button = new ImageButton(skin, "ad_heal_button");
        leaves_ad_heal_button.setBounds(1080-20-250, 415-20-125-125-125, 250, 150);
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


        out.setPosition(20, 1920-20-500-20-415);
        out.setName("leave_pane");
        return out;
    }
    public Group generate_leave(Leave leave){
        Group out = new Group();

        Image pane = new Image(atlas.findRegion("leave_pane"));
        pane.setBounds(0, 0, 250, 375);
        out.addActor(pane);

        Image hp;

        if(leave.isAlive()){

            int percent = (int)((leave.getCurrent_health()/leave.getMaximum_health())*10);

            if(percent==0){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_0"));
            }else
            if(percent>=0&&percent<=10){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_10"));
            }else
            if(percent>=10&&percent<=20){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_20"));
            }else
            if(percent>=20&&percent<=30){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_30"));
            }else
            if(percent>=30&&percent<=40){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_40"));
            }else
            if(percent>=40&&percent<=50){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_50"));
            }else
            if(percent>=50&&percent<=60){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_60"));
            }else
            if(percent>=60&&percent<=70){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_70"));
            }else
            if(percent>=70&&percent<=80){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_80"));
            }else
            if(percent>=80&&percent<=90){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_90"));
            }else
            if(percent>=90){
                hp = new Image(atlas.findRegion("item_plant_hp_bar_100"));
            }else{
                hp = null;
            }

            hp.setPosition(20, 375-20-200);
            out.addActor(hp);


        }else{

        }

        Label height = new Label(
                leave.getHeight()+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        height.setAlignment(Align.center);
        height.setWrap(true);
        height.setBounds(25, 375-20-200-20-86.5f, 86.5f, 86.5f);
        out.addActor(height);

        Label width = new Label(
                leave.getWidth()+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        width.setAlignment(Align.center);
        width.setWrap(true);
        width.setBounds(250-25-86.5f, 375-20-200-20-86.5f, 86.5f, 86.5f);
        out.addActor(width);

        Label light = new Label(
                leave.getLight_energy_production()*(leave.getHeight()*leave.getWidth())+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        light.setAlignment(Align.center);
        light.setWrap(true);
        light.setBounds(25, 25, 86.5f, 86.5f);
        out.addActor(light);

        Label dark = new Label(
                leave.getDark_energy_production()*(leave.getHeight()*leave.getWidth())+"",
                new Label.LabelStyle(alice_64_black, Color.BLACK)
        );
        dark.setAlignment(Align.center);
        dark.setWrap(true);
        dark.setBounds(250-25-86.5f, 25, 86.5f, 86.5f);
        out.addActor(dark);

        return out;
    }

    public Group generate_roots_pane(){}
    public Group generate_root(Root root){}

    public Group generate_products_pane(){}
    public Group generate_product(Product product){}

    public Group generate_buttons_pane(){}


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
