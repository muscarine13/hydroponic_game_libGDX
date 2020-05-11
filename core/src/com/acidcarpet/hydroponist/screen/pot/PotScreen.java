package com.acidcarpet.hydroponist.screen.pot;


import com.acidcarpet.hydroponist.bottle.Bottle;
import com.acidcarpet.hydroponist.box.Box;
import com.acidcarpet.hydroponist.pot.Pot;
import com.acidcarpet.hydroponist.screen.box.BoxScreen;
import com.acidcarpet.hydroponist.storage.Inventory;
import com.acidcarpet.hydroponist.storage.Storable;
import com.acidcarpet.hydroponist.storage.Type;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.Date;


public class PotScreen implements Screen {
    private static boolean refresh;
    public static void update(){
        refresh = true;
    }

    Thread fil_thread;

    Game game;



    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    BitmapFont alice_72_8F51F5;
    BitmapFont alice_62_797E55;

    BitmapFont alice_72_30155B;


    public PotScreen(Game game){
        this.game = game;
    }

    public void take_off_button_click(){
        ///

    }
    public void pot_fil_button_click(ImageButton button){




    }
    public void pot_drop_button_click(ImageButton button){



    }
    public void pro_help_button_click(){

        if(Box.getInstance().getPot()==null)return;
        if(Box.getInstance().getPlant()==null) return;

        Box.getInstance().getPot().drain(Box.getInstance().getPot().get_current_volume());

        Box.getInstance().getPot().pro_help();
    }



    public void bottle_fil_button_click(Bottle bottle){
        bottle.drain();
        Pot.getInstance().fil(
                1,
                bottle.getpH(),
                bottle.getPpm_N(),
                bottle.getPpm_P(),
                bottle.getPpm_K(),
                bottle.getPpm_S(),
                bottle.getPpm_Mg(),
                bottle.getPpm_Ca(),
                bottle.getPpm_B(),
                bottle.getPpm_Cu(),
                bottle.getPpm_Fe(),
                bottle.getPpm_Mn(),
                bottle.getPpm_Mo(),
                bottle.getPpm_Zn()
        );
    }

    public void delete_button_clicked(Pot pot){
        ///

    }
    public void equip_button_clicked(Pot pot){
      ///

    }
    public void delete_button_clicked(Bottle bottle){
        Inventory.getInstance().delete(bottle);
    }

    void back_button_click(){
        game.setScreen(new BoxScreen(game));
    }

    @Override
    public void show() {

        stage = new Stage(new ExtendViewport(1080, 1920));

        PotResources.set_all();

        atlas = PotResources.getAtlas();
        skin = PotResources.getSkin();
        Gdx.input.setInputProcessor(stage);

        alice_72_8F51F5 = PotResources.getAlice_72_8F51F5();
        alice_62_797E55 = PotResources.getAlice_62_797E55();

        alice_72_30155B = PotResources.getAlice_72_30155B();

        Image background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        background.setName("background");
        stage.addActor(background);

        stage.addActor(generate_pot_pane());
        stage.addActor(generate_items_pane());

        stage.addActor(generate_buttons_pane());

    }

    @Override
    public void render(float delta) {
        if(refresh){

            try{    stage.getRoot().findActor("pot_pane").clearListeners();                }catch (Exception e){ e.printStackTrace();}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("pot_pane"));    }catch (Exception e){ e.printStackTrace();}

            try{    stage.addActor(generate_pot_pane());                                          }catch (Exception e){ e.printStackTrace();}


            try {   stage.getRoot().findActor("items_pane").clearListeners();} catch (Exception e) { e.printStackTrace(); }
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("items_pane")); } catch (Exception e) { e.printStackTrace(); }


            try { stage.addActor(generate_items_pane()); } catch (Exception e) { e.printStackTrace(); }


            refresh = false;
        }

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
stage.dispose();
PotResources.dispose_all();
    }

    private Group generate_pot_pane(){

        Group out = new Group();

        Image background = new Image(atlas.findRegion("pot_background"));
        background.setPosition(0, 0);
        background.setName("pot_background");
        out.addActor(background);


        if(Box.getInstance().getPot()!=null){

            Image pane = new Image(atlas.findRegion("pot_pane"));
            pane.setPosition(0, 0);
            pane.setName("pot_pane");
            out.addActor(pane);

            //Название
            Label.LabelStyle title_style = new Label.LabelStyle();
            title_style.font = alice_72_8F51F5;
            Label name_label = new Label(
                      "ТЕКСТ КАКОЙ ТО",
                    title_style
            );
            name_label.setAlignment(Align.center);
            name_label.setName("title_label");
            name_label.setWrap(true);
            name_label.setBounds(0, 530-85, 1080, 85);
            out.addActor(name_label);

            //Объем горшка прогрессбар
            Image pot_bar;
            int pot_volume_percent =
                    (int)
                            ((Box.getInstance().getPot().get_current_volume()
                            /
                            Box.getInstance().getPot().get_maximum_volume())*100);

            if(pot_volume_percent<=0){
                pot_bar = new Image(atlas.findRegion("pot_0_bar"));
            }else if (pot_volume_percent>0&&pot_volume_percent<=10){
                pot_bar = new Image(atlas.findRegion("pot_10_bar"));
            }else if (pot_volume_percent>10&&pot_volume_percent<=20){
                pot_bar = new Image(atlas.findRegion("pot_20_bar"));
            }else if (pot_volume_percent>20&&pot_volume_percent<=30){
                pot_bar = new Image(atlas.findRegion("pot_30_bar"));
            }else if (pot_volume_percent>30&&pot_volume_percent<=40){
                pot_bar = new Image(atlas.findRegion("pot_40_bar"));
            }else if (pot_volume_percent>40&&pot_volume_percent<=50){
                pot_bar = new Image(atlas.findRegion("pot_50_bar"));
            }else if (pot_volume_percent>50&&pot_volume_percent<=60){
                pot_bar = new Image(atlas.findRegion("pot_60_bar"));
            }else if (pot_volume_percent>60&&pot_volume_percent<=70){
                pot_bar = new Image(atlas.findRegion("pot_70_bar"));
            }else if (pot_volume_percent>70&&pot_volume_percent<=80){
                pot_bar = new Image(atlas.findRegion("pot_80_bar"));
            }else if (pot_volume_percent>80&&pot_volume_percent<=90){
                pot_bar = new Image(atlas.findRegion("pot_90_bar"));
            }else if (pot_volume_percent>90&&pot_volume_percent<=100){
                pot_bar = new Image(atlas.findRegion("pot_100_bar"));
            }else
            {
                pot_bar = new Image(atlas.findRegion("pot_100_bar"));
            }

            pot_bar.setPosition(15, 15);
            pot_bar.setName("pot_bar");
            out.addActor(pot_bar);

            Label.LabelStyle elements_style = new Label.LabelStyle();
            elements_style.font = alice_72_30155B;

            Label maximum_label = new Label((int)(Box.getInstance().getPot().get_maximum_volume()*1000)+" ml",
                    elements_style);
            maximum_label.setAlignment(Align.center);
            maximum_label.setName("maximum_label");
            maximum_label.setWrap(false);
            maximum_label.setBounds(15, 15+350-80-80, 350, 80);
            out.addActor(maximum_label);

            Label current_label = new Label((int)(Box.getInstance().getPot().get_current_volume()*1000)+" ml",
                    elements_style);
            current_label.setAlignment(Align.center);
            current_label.setName("current_label");
            current_label.setWrap(false);
            current_label.setBounds(15, 15, 350, 80);
            out.addActor(current_label);

            Label N_label =
                    new Label(Box.getInstance().getPot().get_N()+" ", elements_style);
            N_label.setAlignment(Align.right);
            N_label.setName("N_label");
            N_label.setWrap(false);
            N_label.setBounds(15, 15+350, 175, 80);
            out.addActor(N_label);

            Label P_label =
                    new Label(Box.getInstance().getPot().get_P()+" ", elements_style);
            P_label.setAlignment(Align.right);
            P_label.setName("P_label");
            P_label.setWrap(false);
            P_label.setBounds(15+175, 15+350, 175, 80);
            out.addActor(P_label);

            Label K_label =
                    new Label(Box.getInstance().getPot().get_K()+" ", elements_style);
            K_label.setAlignment(Align.right);
            K_label.setName("K_label");
            K_label.setWrap(false);
            K_label.setBounds(15+175+175, 15+350, 175, 80);
            out.addActor(K_label);

            Label S_label =
                    new Label(Box.getInstance().getPot().get_S()+" ", elements_style);
            S_label.setAlignment(Align.right);
            S_label.setName("S_label");
            S_label.setWrap(false);
            S_label.setBounds(15+175+175+175, 15+350, 175, 80);
            out.addActor(S_label);

            Label Mg_label =
                    new Label(Box.getInstance().getPot().get_Mg()+" ", elements_style);
            Mg_label.setAlignment(Align.right);
            Mg_label.setName("Mg_label");
            Mg_label.setWrap(false);
            Mg_label.setBounds(15+175+175+175+175, 15+350, 175, 80);
            out.addActor(Mg_label);

            Label Ca_label =
                    new Label(Box.getInstance().getPot().get_Ca()+" ", elements_style);
            Ca_label.setAlignment(Align.right);
            Ca_label.setName("Ca_label");
            Ca_label.setWrap(false);
            Ca_label.setBounds(15+175+175+175+175+175, 15+350, 175, 80);
            out.addActor(Ca_label);

            Label B_label =
                    new Label(Box.getInstance().getPot().get_B()+" ", elements_style);
            B_label.setAlignment(Align.right);
            B_label.setName("B_label");
            B_label.setWrap(false);
            B_label.setBounds(15, 15+350-80, 175, 80);
            out.addActor(B_label);

            Label Cu_label =
                    new Label(Box.getInstance().getPot().get_Cu()+" ", elements_style);
            Cu_label.setAlignment(Align.right);
            Cu_label.setName("Cu_label");
            Cu_label.setWrap(false);
            Cu_label.setBounds(15+175, 15+350-80, 175, 80);
            out.addActor(Cu_label);

            Label Fe_label =
                    new Label(Box.getInstance().getPot().get_Fe()+" ", elements_style);
            Fe_label.setAlignment(Align.right);
            Fe_label.setName("Fe_label");
            Fe_label.setWrap(false);
            Fe_label.setBounds(15+175+175, 15+350-80, 175, 80);
            out.addActor(Fe_label);

            Label Mn_label =
                    new Label(Box.getInstance().getPot().get_Mn()+" ", elements_style);
            Mn_label.setAlignment(Align.right);
            Mn_label.setName("Mn_label");
            Mn_label.setWrap(false);
            Mn_label.setBounds(15+175+175+175, 15+350-80, 175, 80);
            out.addActor(Mn_label);

            Label Mo_label =
                    new Label(Box.getInstance().getPot().get_Mo()+" ", elements_style);
            Mo_label.setAlignment(Align.right);
            Mo_label.setName("Mo_label");
            Mo_label.setWrap(false);
            Mo_label.setBounds(15+175+175+175+175, 15+350-80, 175, 80);
            out.addActor(Mo_label);

            Label Zn_label =
                    new Label(Box.getInstance().getPot().get_Zn()+" ", elements_style);
            Zn_label.setAlignment(Align.right);
            Zn_label.setName("Zn_label");
            Zn_label.setWrap(false);
            Zn_label.setBounds(15+175+175+175+175+175, 15+350-80, 175, 80);
            out.addActor(Zn_label);

            Image pH_bar;
            if(Box.getInstance().getPot().getpH()<=0){
                pH_bar = new Image(atlas.findRegion("pH_0_bar"));
            }else if(Box.getInstance().getPot().getpH()>0&&Box.getInstance().getPot().getpH()<=1){
                pH_bar = new Image(atlas.findRegion("pH_1_bar"));
            }else if(Box.getInstance().getPot().getpH()>1&&Box.getInstance().getPot().getpH()<=2){
                pH_bar = new Image(atlas.findRegion("pH_2_bar"));
            }else if(Box.getInstance().getPot().getpH()>2&&Box.getInstance().getPot().getpH()<=3){
                pH_bar = new Image(atlas.findRegion("pH_3_bar"));
            }else if(Box.getInstance().getPot().getpH()>3&&Box.getInstance().getPot().getpH()<=4){
                pH_bar = new Image(atlas.findRegion("pH_4_bar"));
            }else if(Box.getInstance().getPot().getpH()>4&&Box.getInstance().getPot().getpH()<=5){
                pH_bar = new Image(atlas.findRegion("pH_5_bar"));
            }else if(Box.getInstance().getPot().getpH()>5&&Box.getInstance().getPot().getpH()<=6){
                pH_bar = new Image(atlas.findRegion("pH_6_bar"));
            }else if(Box.getInstance().getPot().getpH()>6&&Box.getInstance().getPot().getpH()<=7){
                pH_bar = new Image(atlas.findRegion("pH_7_bar"));
            }else if(Box.getInstance().getPot().getpH()>7&&Box.getInstance().getPot().getpH()<=8){
                pH_bar = new Image(atlas.findRegion("pH_8_bar"));
            }else if(Box.getInstance().getPot().getpH()>8&&Box.getInstance().getPot().getpH()<=9){
                pH_bar = new Image(atlas.findRegion("pH_9_bar"));
            }else if(Box.getInstance().getPot().getpH()>9&&Box.getInstance().getPot().getpH()<=10){
                pH_bar = new Image(atlas.findRegion("pH_10_bar"));
            }else if(Box.getInstance().getPot().getpH()>10&&Box.getInstance().getPot().getpH()<=11){
                pH_bar = new Image(atlas.findRegion("pH_11_bar"));
            }else if(Box.getInstance().getPot().getpH()>11&&Box.getInstance().getPot().getpH()<=12){
                pH_bar = new Image(atlas.findRegion("pH_12_bar"));
            }else if(Box.getInstance().getPot().getpH()>12&&Box.getInstance().getPot().getpH()<=13){
                pH_bar = new Image(atlas.findRegion("pH_13_bar"));
            }else if(Box.getInstance().getPot().getpH()>13&&Box.getInstance().getPot().getpH()<=14){
                pH_bar = new Image(atlas.findRegion("pH_14_bar"));
            }else
            {
                pH_bar = new Image(atlas.findRegion("pH_14_bar"));
            }
            pH_bar.setPosition(15+350, 15);
            pH_bar.setName("pH_bar");
            out.addActor(pH_bar);

            Image ppm_bar;
            if(Box.getInstance().getPot().get_all_ppm()<=0){
                ppm_bar = new Image(atlas.findRegion("ppm_0_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>0&&Box.getInstance().getPot().get_all_ppm()<=100){
                ppm_bar = new Image(atlas.findRegion("ppm_100_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>100&&Box.getInstance().getPot().get_all_ppm()<=200){
                ppm_bar = new Image(atlas.findRegion("ppm_200_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>200&&Box.getInstance().getPot().get_all_ppm()<=300){
                ppm_bar = new Image(atlas.findRegion("ppm_300_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>300&&Box.getInstance().getPot().get_all_ppm()<=400){
                ppm_bar = new Image(atlas.findRegion("ppm_400_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>400&&Box.getInstance().getPot().get_all_ppm()<=500){
                ppm_bar = new Image(atlas.findRegion("ppm_500_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>500&&Box.getInstance().getPot().get_all_ppm()<=600){
                ppm_bar = new Image(atlas.findRegion("ppm_600_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>600&&Box.getInstance().getPot().get_all_ppm()<=700){
                ppm_bar = new Image(atlas.findRegion("ppm_700_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>700&&Box.getInstance().getPot().get_all_ppm()<=800){
                ppm_bar = new Image(atlas.findRegion("ppm_800_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>800&&Box.getInstance().getPot().get_all_ppm()<=900){
                ppm_bar = new Image(atlas.findRegion("ppm_900_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>900&&Box.getInstance().getPot().get_all_ppm()<=1000){
                ppm_bar = new Image(atlas.findRegion("ppm_1000_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1000&&Box.getInstance().getPot().get_all_ppm()<=1100){
                ppm_bar = new Image(atlas.findRegion("ppm_1100_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1100&&Box.getInstance().getPot().get_all_ppm()<=1200){
                ppm_bar = new Image(atlas.findRegion("ppm_1200_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1200&&Box.getInstance().getPot().get_all_ppm()<=1300){
                ppm_bar = new Image(atlas.findRegion("ppm_1300_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1300&&Box.getInstance().getPot().get_all_ppm()<=1400){
                ppm_bar = new Image(atlas.findRegion("ppm_1400_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1400&&Box.getInstance().getPot().get_all_ppm()<=1500){
                ppm_bar = new Image(atlas.findRegion("ppm_1500_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1500&&Box.getInstance().getPot().get_all_ppm()<=1600){
                ppm_bar = new Image(atlas.findRegion("ppm_1600_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1600&&Box.getInstance().getPot().get_all_ppm()<=1700){
                ppm_bar = new Image(atlas.findRegion("ppm_1600_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1700&&Box.getInstance().getPot().get_all_ppm()<=1800){
                ppm_bar = new Image(atlas.findRegion("ppm_1800_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1800&&Box.getInstance().getPot().get_all_ppm()<=1900){
                ppm_bar = new Image(atlas.findRegion("ppm_1900_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>1900&&Box.getInstance().getPot().get_all_ppm()<=2000){
                ppm_bar = new Image(atlas.findRegion("ppm_2000_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2000&&Box.getInstance().getPot().get_all_ppm()<=2100){
                ppm_bar = new Image(atlas.findRegion("ppm_2100_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2100&&Box.getInstance().getPot().get_all_ppm()<=2200){
                ppm_bar = new Image(atlas.findRegion("ppm_2200_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2200&&Box.getInstance().getPot().get_all_ppm()<=2300){
                ppm_bar = new Image(atlas.findRegion("ppm_2300_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2300&&Box.getInstance().getPot().get_all_ppm()<=2400){
                ppm_bar = new Image(atlas.findRegion("ppm_2400_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2400&&Box.getInstance().getPot().get_all_ppm()<=2500){
                ppm_bar = new Image(atlas.findRegion("ppm_2500_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2500&&Box.getInstance().getPot().get_all_ppm()<=2600){
                ppm_bar = new Image(atlas.findRegion("ppm_2600_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2600&&Box.getInstance().getPot().get_all_ppm()<=2700){
                ppm_bar = new Image(atlas.findRegion("ppm_2700_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2700&&Box.getInstance().getPot().get_all_ppm()<=2800){
                ppm_bar = new Image(atlas.findRegion("ppm_2800_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2800&&Box.getInstance().getPot().get_all_ppm()<=2900){
                ppm_bar = new Image(atlas.findRegion("ppm_2900_bar"));
            }else if(Box.getInstance().getPot().get_all_ppm()>2900&&Box.getInstance().getPot().get_all_ppm()<=3000){
                ppm_bar = new Image(atlas.findRegion("ppm_3000_bar"));
            }else
                {
                ppm_bar = new Image(atlas.findRegion("ppm_3000_bar"));
            }
            ppm_bar.setPosition(15+350, 15+80);
            ppm_bar.setName("ppm_bar");
            out.addActor(ppm_bar);

            ImageButton pro_help_button = new ImageButton(skin, "pro_help_button");
            pro_help_button.setPosition(350+15, 260+15-80);
            pro_help_button.setName("pro_help_button");
            pro_help_button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    pro_help_button_click();
                }
            });
            out.addActor(pro_help_button);

            ImageButton take_off_button = new ImageButton(skin, "take_off_button");
            take_off_button.setPosition(350+175+15, 15);
            take_off_button.setName("take_off_button");
            take_off_button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    take_off_button_click();
                }
            });
            out.addActor(take_off_button);

            final ImageButton pot_fil_button = new ImageButton(skin, "pot_fil_button");
            pot_fil_button.setPosition(1080-15-200, 15+100);
            pot_fil_button.setName("pot_fil_button");
            pot_fil_button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    pot_fil_button_click(pot_fil_button);
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                    return super.touchDown(event, x, y, pointer, button);
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                    super.touchUp(event, x, y, pointer, button);
                }
            });
            out.addActor(pot_fil_button);

            final ImageButton pot_drop_button = new ImageButton(skin, "pot_drop_button");
            pot_drop_button.setPosition(1080-15-200, 15);
            pot_drop_button.setName("pot_drop_button");
            pot_drop_button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    pot_drop_button_click(pot_drop_button);
                }
            });
            out.addActor(pot_drop_button);
        }

        out.setName("pot_pane");
        out.setPosition(0+40, 1920-530);
        return out;
    }

    private Group generate_items_pane() {

        Group out = new Group();

        Image background = new Image(atlas.findRegion("items_background"));
        background.setPosition(0, 0);
        background.setName("items_background");
        out.addActor(background);

        Table table;
        table = new Table();


            table.defaults().width(1080).height(300);

            for(Storable current_bottle : Inventory.getInstance().get_list(Type.BOTTLE)){
                table.add(generate_item((Bottle)current_bottle));
                table.row();
            }






        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(true, false);
        pane.setBounds(0 ,0 ,1080 , 1080);
        out.addActor(pane);

        out.setName("items_pane");
        out.setPosition(40, 1920-530-1080);
        return out;
    }
    private Group generate_item(final Pot pot){
        Group out = new Group();



        Image background = new Image(atlas.findRegion("sub_pot_pane"));
        background.setPosition(0, 0);
        background.setName("sub_pot_pane");
        out.addActor(background);

        Label.LabelStyle title_style = new Label.LabelStyle();
        title_style.font = alice_62_797E55;
        Label name_label = new Label(
                "YTGJYZNYSQ NYTRCN 2",
                title_style
        );
        name_label.setAlignment(Align.center);
        name_label.setName("title_label");
        name_label.setWrap(true);
        name_label.setBounds(0, 230-120, 1080, 120);
        out.addActor(name_label);

        ImageButton delete_button = new ImageButton(skin, "delete_button");
        delete_button.setPosition(15, 15);
        delete_button.setName("delete_button");
        delete_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                delete_button_clicked(pot);
            }
        });
        out.addActor(delete_button);

        ImageButton equip_button = new ImageButton(skin, "equip_button");
        equip_button.setPosition(1080-15-200, 15);
        equip_button.setName("equip_button");
        equip_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                equip_button_clicked(pot);
            }
        });
        out.addActor(equip_button);

        Image pot_bar;
        double percent = ((double)pot.get_current_volume()/pot.get_maximum_volume())*100;

        if(percent<=0){
            pot_bar = new Image(atlas.findRegion("sub_pot_0_bar"));
        }else if(percent>0&&percent<=10){
            pot_bar = new Image(atlas.findRegion("sub_pot_10_bar"));
        }else if(percent>10&&percent<=20){
            pot_bar = new Image(atlas.findRegion("sub_pot_20_bar"));
        }else if(percent>20&&percent<=30){
            pot_bar = new Image(atlas.findRegion("sub_pot_30_bar"));
        }else if(percent>30&&percent<=40){
            pot_bar = new Image(atlas.findRegion("sub_pot_40_bar"));
        }else if(percent>40&&percent<=50){
            pot_bar = new Image(atlas.findRegion("sub_pot_50_bar"));
        }else if(percent>50&&percent<=60){
            pot_bar = new Image(atlas.findRegion("sub_pot_60_bar"));
        }else if(percent>60&&percent<=70){
            pot_bar = new Image(atlas.findRegion("sub_pot_70_bar"));
        }else if(percent>70&&percent<=80){
            pot_bar = new Image(atlas.findRegion("sub_pot_80_bar"));
        }else if(percent>80&&percent<=90){
            pot_bar = new Image(atlas.findRegion("sub_pot_90_bar"));
        }else if(percent>90&&percent<=100){
            pot_bar = new Image(atlas.findRegion("sub_pot_100_bar"));
        }else
            {
            pot_bar = new Image(atlas.findRegion("sub_pot_100_bar"));
        }

        pot_bar.setPosition(15+200, 15);
        pot_bar.setName("pot_bar");
        out.addActor(pot_bar);

        return out;
    }
    private Group generate_item(final Bottle bottle){
        Group out = new Group();



        Image background = new Image(atlas.findRegion("bottle_pane"));
        background.setPosition(0, 0);
        background.setName("bottle_pane");
        out.addActor(background);

        Label.LabelStyle title_style = new Label.LabelStyle();
        title_style.font = alice_62_797E55;
        Label name_label = new Label(
                bottle.name() + "",
                title_style
        );
        name_label.setAlignment(Align.center);
        name_label.setName("title_label");
        name_label.setWrap(true);
        name_label.setBounds(0, 300-120, 1080, 120);
        out.addActor(name_label);

        ImageButton delete_button = new ImageButton(skin, "delete_button");
        delete_button.setPosition(15, 15);
        delete_button.setName("delete_button");
        delete_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                delete_button_clicked(bottle);
            }
        });
        out.addActor(delete_button);

        ImageButton bottle_fil_button = new ImageButton(skin, "bottle_fil_button");
        bottle_fil_button.setPosition(1080-15-200, 15+80);
        bottle_fil_button.setName("bottle_fil_button");
        bottle_fil_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                bottle_fil_button_click(bottle);
            }
        });
        out.addActor(bottle_fil_button);

        Image bottle_bar;
        double percent = (bottle.getCurrent_volume()/bottle.getVolumeType().getVolume())*100;

        if(percent<=0){
            bottle_bar = new Image(atlas.findRegion("bottle_0_bar"));
        }else if(percent>0&&percent<=10){
            bottle_bar = new Image(atlas.findRegion("bottle_10_bar"));
        }else if(percent>10&&percent<=20){
            bottle_bar = new Image(atlas.findRegion("bottle_20_bar"));
        }else if(percent>20&&percent<=30){
            bottle_bar = new Image(atlas.findRegion("bottle_30_bar"));
        }else if(percent>30&&percent<=40){
            bottle_bar = new Image(atlas.findRegion("bottle_40_bar"));
        }else if(percent>40&&percent<=50){
            bottle_bar = new Image(atlas.findRegion("bottle_50_bar"));
        }else if(percent>50&&percent<=60){
            bottle_bar = new Image(atlas.findRegion("bottle_60_bar"));
        }else if(percent>60&&percent<=70){
            bottle_bar = new Image(atlas.findRegion("bottle_70_bar"));
        }else if(percent>70&&percent<=80){
            bottle_bar = new Image(atlas.findRegion("bottle_80_bar"));
        }else if(percent>80&&percent<=90){
            bottle_bar = new Image(atlas.findRegion("bottle_90_bar"));
        }else if(percent>90&&percent<=100){
            bottle_bar = new Image(atlas.findRegion("bottle_100_bar"));
        }else
        {
            bottle_bar = new Image(atlas.findRegion("bottle_100_bar"));
        }
        bottle_bar.setPosition(15+200+175, 15+80);
        bottle_bar.setName("bottle_bar");
        out.addActor(bottle_bar);


        Image pH_bar;
        if(bottle.getpH()<=0){
            pH_bar = new Image(atlas.findRegion("pH_0_bar"));
        }else if(bottle.getpH()>0&&bottle.getpH()<=1){
            pH_bar = new Image(atlas.findRegion("pH_1_bar"));
        }else if(bottle.getpH()>1&&bottle.getpH()<=2){
            pH_bar = new Image(atlas.findRegion("pH_2_bar"));
        }else if(bottle.getpH()>2&&bottle.getpH()<=3){
            pH_bar = new Image(atlas.findRegion("pH_3_bar"));
        }else if(bottle.getpH()>3&&bottle.getpH()<=4){
            pH_bar = new Image(atlas.findRegion("pH_4_bar"));
        }else if(bottle.getpH()>4&&bottle.getpH()<=5){
            pH_bar = new Image(atlas.findRegion("pH_5_bar"));
        }else if(bottle.getpH()>5&&bottle.getpH()<=6){
            pH_bar = new Image(atlas.findRegion("pH_6_bar"));
        }else if(bottle.getpH()>6&&bottle.getpH()<=7){
            pH_bar = new Image(atlas.findRegion("pH_7_bar"));
        }else if(bottle.getpH()>7&&bottle.getpH()<=8){
            pH_bar = new Image(atlas.findRegion("pH_8_bar"));
        }else if(bottle.getpH()>8&&bottle.getpH()<=9){
            pH_bar = new Image(atlas.findRegion("pH_9_bar"));
        }else if(bottle.getpH()>9&&bottle.getpH()<=10){
            pH_bar = new Image(atlas.findRegion("pH_10_bar"));
        }else if(bottle.getpH()>10&&bottle.getpH()<=11){
            pH_bar = new Image(atlas.findRegion("pH_11_bar"));
        }else if(bottle.getpH()>11&&bottle.getpH()<=12){
            pH_bar = new Image(atlas.findRegion("pH_12_bar"));
        }else if(bottle.getpH()>12&&bottle.getpH()<=13){
            pH_bar = new Image(atlas.findRegion("pH_13_bar"));
        }else if(bottle.getpH()>13&&bottle.getpH()<=14){
            pH_bar = new Image(atlas.findRegion("pH_14_bar"));
        }else
        {
            pH_bar = new Image(atlas.findRegion("pH_14_bar"));
        }
        pH_bar.setPosition(15+200, 15+80);
        pH_bar.setName("pH_bar");
        out.addActor(pH_bar);

        Image macro_main;
        switch (bottle.getMacroPrimaryType()){
            case N: macro_main = new Image(atlas.findRegion("N_icon")); break;
            case P: macro_main = new Image(atlas.findRegion("P_icon")); break;
            case K: macro_main = new Image(atlas.findRegion("K_icon")); break;
            default: macro_main = new Image(atlas.findRegion("empty_element_icon"));
        }
        macro_main.setPosition(15+200, 15);
        macro_main.setName("macro_main");
        out.addActor(macro_main);

        Image macro_secondary;
        switch (bottle.getMacroSecondaryType()){
            case S: macro_secondary = new Image(atlas.findRegion("S_icon")); break;
            case Mg: macro_secondary = new Image(atlas.findRegion("Mg_icon")); break;
            case Ca: macro_secondary = new Image(atlas.findRegion("Ca_icon")); break;
            default: macro_secondary = new Image(atlas.findRegion("empty_element_icon"));
        }
        macro_secondary.setPosition(15+200+175, 15);
        macro_secondary.setName("macro_secondary");
        out.addActor(macro_secondary);

        Image micro_main;
        switch (bottle.getMicroPrimaryType()){
            case B: micro_main = new Image(atlas.findRegion("B_icon")); break;
            case Cu: micro_main = new Image(atlas.findRegion("Cu_icon")); break;
            case Fe: micro_main = new Image(atlas.findRegion("Fe_icon")); break;
            default: micro_main = new Image(atlas.findRegion("empty_element_icon"));
        }
        micro_main.setPosition(15+200+175+175, 15);
        micro_main.setName("micro_main");
        out.addActor(micro_main);

        Image micro_secondary;
        switch (bottle.getMicroSecondaryType()){
            case Mn: micro_secondary = new Image(atlas.findRegion("Mn_icon")); break;
            case Mo: micro_secondary = new Image(atlas.findRegion("Mo_icon")); break;
            case Zn: micro_secondary = new Image(atlas.findRegion("Zn_icon")); break;
            default: micro_secondary = new Image(atlas.findRegion("empty_element_icon"));
        }
        micro_secondary.setPosition(15+200+175+175+175, 15);
        micro_secondary.setName("micro_secondary");
        out.addActor(micro_secondary);
        return out;
    }



    private Group generate_buttons_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("buttons_background"));
        background.setPosition(0 , 0);
        background.setName("buttons_background");
        out.addActor(background);

        ImageButton back_button = new ImageButton(skin, "back_button");
        back_button.setPosition(1080/2-560/2, 20);
        back_button.setName("back_button");
        back_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                back_button_click();
            }
        });
        out.addActor(back_button);

        out.setName("buttons_pane");
        out.setPosition(40, 0);
        return out;
    }



}
