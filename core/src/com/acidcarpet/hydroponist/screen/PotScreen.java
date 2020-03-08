package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Bottle;
import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.Pot;
import com.acidcarpet.hydroponist.storage.Inventory;
import com.acidcarpet.hydroponist.storage.Storable;
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


public class PotScreen implements Screen {

    Game game;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    long last_refresh;

    BitmapFont alice_48_green;
    BitmapFont alice_48_black;
    BitmapFont alice_72_8F8F8F_stroke_black;

    PotScreen(Game game){
        this.game = game;
    }

    public void take_off_button_click(){
        Box.getInstance().take_off_pot();

    }
    public void drop_100ml_button_click(){
        if(Box.getInstance().getPot()!=null){
            Box.getInstance().getPot().drain(0.1f);
        }

    }
    public void drop_1l_button_click(){
        if(Box.getInstance().getPot()!=null){
            Box.getInstance().getPot().drain(1.0f);
        }
    }
    public void drop_10l_button_click(){
        if(Box.getInstance().getPot()!=null){
            Box.getInstance().getPot().drain(10.0f);
        }
    }
    public void drop_all2_button_click(){
        if(Box.getInstance().getPot()!=null){
            Box.getInstance().getPot().drain(Box.getInstance().getPot().getCurrent_volume());
        }
    }
    public void pro_help_button_click(){

    }

    public void delete_button_clicked(Pot pot){
        Inventory.getInstance().delete(pot);
        Box.update();

    }
    public void equip_button_clicked(Pot pot){
        Box.getInstance().equip(pot);

    }

    public void drop_1ml_button_click(Bottle bottle){
        bottle.drop(0.001f);
    }
    public void drop_10ml_button_click(Bottle bottle){
        bottle.drop(0.01f);
    }
    public void drop_all_button_click(Bottle bottle){
        bottle.drop(bottle.getCurrent_volume());
    }
    public  void delete2_button_click(Bottle bottle){
        Inventory.getInstance().delete(bottle);
        Box.update();
    }

    void back_button_click(){
        game.setScreen(new BoxScreen(game));
    }

    @Override
    public void show() {
        this.game = game;

        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = ScreenAssets.getInstance().getPotScreen_atlas();
        skin = ScreenAssets.getInstance().getPotScreen_skin();
        Gdx.input.setInputProcessor(stage);

        alice_48_green = ScreenAssets.getInstance().getAlice_48_green();
        alice_48_black = ScreenAssets.getInstance().getAlice_48_green();
        alice_72_8F8F8F_stroke_black = ScreenAssets.getInstance().getAlice_72_8F8F8F_stroke_black();

        Image background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        background.setName("background");
        stage.addActor(background);

        ImageButton back_button = new ImageButton(skin, "back_button");
        back_button.setPosition((1080/2)-350+40, 40);
        back_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                back_button_click();
            }
        });
        stage.addActor(back_button);

        Group info_pane = generate_info_pane();
        stage.addActor(info_pane);

        Group pot_pane = generate_pot_pane();
        stage.addActor(pot_pane);

        Group bottle_pane = generate_bottle_pane();
        stage.addActor(bottle_pane);


    }

    @Override
    public void render(float delta) {
        if(Box.get_last_update()!=last_refresh){

            stage.getRoot().findActor("info_pane").clearListeners();
            stage.getRoot().removeActor(stage.getRoot().findActor("info_pane"));
            stage.addActor(generate_info_pane());

            stage.getRoot().findActor("bottle_pane").clearListeners();
            stage.getRoot().removeActor(stage.getRoot().findActor("bottle_pane"));
            stage.addActor(generate_bottle_pane());

            stage.getRoot().findActor("pot_pane").clearListeners();
            stage.getRoot().removeActor(stage.getRoot().findActor("pot_pane"));
            stage.addActor(generate_pot_pane());

            last_refresh = Box.get_last_update();

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

    }

    private Group generate_info_pane(){

        Group out = new Group();

        Image background = new Image(atlas.findRegion("info_pane_background"));
        background.setPosition(0, 0);
        background.setName("info_pane_background");
        out.addActor(background);


        if(Box.getInstance().getPot()!=null){

            Label name_label = new Label(
                    Box.getInstance().getPot().getName() + "",
                    new Label.LabelStyle(alice_48_green, Color.GREEN)
            );
            name_label.setAlignment(Align.center);
            name_label.setName("info_pane_name");
            name_label.setWrap(true);
            name_label.setBounds(20, 670-20-117, 1040, 117);
            out.addActor(name_label);

            Group macro = generate_macro_sub_pane();
            macro.setPosition(20, 670-20-117-20-300);
            out.addActor(macro);

            Group micro = generate_micro_sub_pane();
            micro.setPosition(1080-20-300, 670-20-117-20-300);
            out.addActor(micro);

            Group pot = generate_pot_level_sub_pane();
            pot.setPosition((1080/2)-(350/2), 670-20-117-20-300);
            out.addActor(pot);

            Group buttons = generate_button_sub_pane();
            buttons.setPosition(30, 20);
            out.addActor(buttons);


        }else{

            Label name_label = new Label(
                    "ПУСТО",
                    new Label.LabelStyle(alice_48_green, Color.GREEN)
            );
            name_label.setAlignment(Align.center);
            name_label.setName("info_pane_name");
            name_label.setWrap(true);
            name_label.setBounds(20+40, 670-117-20, 1040, 117);
            out.addActor(name_label);
        }


        out.setName("info_pane");
        out.setPosition(0+40, 1920-40-670);
        return out;
    }

    private Group generate_macro_sub_pane(){

        Group out = new Group();

        Image macro_frame = new Image(atlas.findRegion("macro_frame"));
        macro_frame.setBounds(0, 0, 300, 300);
        macro_frame.setName("macro_frame");
        out.addActor(macro_frame);

        if(Box.getInstance().getPot()!=null){

            Label N_label = new Label(
                    Box.getInstance().getPot().getN() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            N_label.setAlignment(Align.center);
            N_label.setName("macro_frame_N");
            N_label.setWrap(true);
            N_label.setBounds(15, 150, 100, 100);
            out.addActor(N_label);

            Label P_label = new Label(
                    Box.getInstance().getPot().getP() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            P_label.setAlignment(Align.center);
            P_label.setName("macro_frame_P");
            P_label.setWrap(true);
            P_label.setBounds(100, 300-100, 100, 100);
            out.addActor(P_label);

            Label K_label = new Label(
                    Box.getInstance().getPot().getK() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            K_label.setAlignment(Align.center);
            K_label.setName("macro_frame_K");
            K_label.setWrap(true);
            K_label.setBounds(300-100-15, 150, 100, 100);
            out.addActor(K_label);

            Label S_label = new Label(
                    Box.getInstance().getPot().getS() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            S_label.setAlignment(Align.center);
            S_label.setName("macro_frame_S");
            S_label.setWrap(true);
            S_label.setBounds(15, 150-100, 100, 100);
            out.addActor(S_label);
            Label Mg_label = new Label(
                    Box.getInstance().getPot().getMg() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Mg_label.setAlignment(Align.center);
            Mg_label.setName("macro_frame_Mg");
            Mg_label.setWrap(true);
            Mg_label.setBounds(100, 0, 100, 100);
            out.addActor(Mg_label);

            Label Ca_label = new Label(
                    Box.getInstance().getPot().getCa() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Ca_label.setAlignment(Align.center);
            Ca_label.setName("macro_frame_Ca");
            Ca_label.setWrap(true);
            Ca_label.setBounds(300-100-15, 150-100, 100, 100);
            out.addActor(Ca_label);

        }

        out.setName("macro_sub_pane");
        return out;
    }
    private Group generate_micro_sub_pane(){
        Group out = new Group();

        Image macro_frame = new Image(atlas.findRegion("micro_frame"));
        macro_frame.setBounds(0, 0, 300, 300);
        macro_frame.setName("micro_frame");
        out.addActor(macro_frame);

        if(Box.getInstance().getPot()!=null){

            Label B_label = new Label(
                    Box.getInstance().getPot().getB() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            B_label.setAlignment(Align.center);
            B_label.setName("micro_frame_B");
            B_label.setWrap(true);
            B_label.setBounds(15, 150, 100, 100);
            out.addActor(B_label);

            Label Cu_label = new Label(
                    Box.getInstance().getPot().getCu() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Cu_label.setAlignment(Align.center);
            Cu_label.setName("micro_frame_Cu");
            Cu_label.setWrap(true);
            Cu_label.setBounds(100, 300-100, 100, 100);
            out.addActor(Cu_label);

            Label Fe_label = new Label(
                    Box.getInstance().getPot().getFe() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Fe_label.setAlignment(Align.center);
            Fe_label.setName("micro_frame_Fe");
            Fe_label.setWrap(true);
            Fe_label.setBounds(300-100-15, 150, 100, 100);
            out.addActor(Fe_label);

            Label Mn_label = new Label(
                    Box.getInstance().getPot().getMn() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Mn_label.setAlignment(Align.center);
            Mn_label.setName("micro_frame_Mn");
            Mn_label.setWrap(true);
            Mn_label.setBounds(15, 150-100, 100, 100);
            out.addActor(Mn_label);

            Label Mo_label = new Label(
                    Box.getInstance().getPot().getMo() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Mo_label.setAlignment(Align.center);
            Mo_label.setName("micro_frame_Mo");
            Mo_label.setWrap(true);
            Mo_label.setBounds(100, 0, 100, 100);
            out.addActor(Mo_label);

            Label Zn_label = new Label(
                    Box.getInstance().getPot().getZn() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Zn_label.setAlignment(Align.center);
            Zn_label.setName("micro_frame_Zn");
            Zn_label.setWrap(true);
            Zn_label.setBounds(300-100-15, 150-100, 100, 100);
            out.addActor(Zn_label);

        }

        out.setName("micro_sub_pane");
        return out;
    }
    private Group generate_pot_level_sub_pane(){

        Group out = new Group();

        if(Box.getInstance().getPot()!=null){

            int percent = (int) ((
                            Box.getInstance().getPot().getCurrent_volume()
                            /
                            Box.getInstance().getPot().getMaximum_volume()
                            )
                            *100)
                    ;

            if(percent==0){
                Image pot_level_pane = new Image(atlas.findRegion("volume_0%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=1&&percent<=10){
                Image pot_level_pane = new Image(atlas.findRegion("volume_10%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=11&&percent<=20){
                Image pot_level_pane = new Image(atlas.findRegion("volume_20%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=21&&percent<=30){
                Image pot_level_pane = new Image(atlas.findRegion("volume_30%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=31&&percent<=40){
                Image pot_level_pane = new Image(atlas.findRegion("volume_40%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=41&&percent<=50){
                Image pot_level_pane = new Image(atlas.findRegion("volume_50%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=51&&percent<=60){
                Image pot_level_pane = new Image(atlas.findRegion("volume_60%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=61&&percent<=70){
                Image pot_level_pane = new Image(atlas.findRegion("volume_70%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=71&&percent<=80){
                Image pot_level_pane = new Image(atlas.findRegion("volume_80%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=81&&percent<=90){
                Image pot_level_pane = new Image(atlas.findRegion("volume_90%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else
            if (percent>=91&&percent<=100){
                Image pot_level_pane = new Image(atlas.findRegion("volume_100%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }else{
                Image pot_level_pane = new Image(atlas.findRegion("volume_0%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }


            Image ph_icon = new Image(atlas.findRegion("ph_icon"));
            ph_icon.setPosition(0, 300-100);
            ph_icon.setName("ph_icon");
            out.addActor(ph_icon);

            Image ppm_icon = new Image(atlas.findRegion("ppm_icon"));
            ppm_icon.setPosition(350-100, 300-100);
            ppm_icon.setName("ppm_icon");
            out.addActor(ppm_icon);

            Label ph_label = new Label(
                    Box.getInstance().getPot().getCurrent_pH() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            ph_label.setAlignment(Align.center);
            ph_label.setName("ph_label");
            ph_label.setWrap(true);
            ph_label.setBounds(0, 300-100, 100, 100);
            out.addActor(ph_label);

            Label ppm_label = new Label(
                    Box.getInstance().getPot().get_all_ppm() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            ppm_label.setAlignment(Align.center);
            ppm_label.setName("ppm_label");
            ppm_label.setWrap(true);
            ppm_label.setBounds(350-100, 300-100, 100, 100);
            out.addActor(ppm_label);

            Label volume_label = new Label(
                    Box.getInstance().getPot().getCurrent_volume()+"/"+Box.getInstance().getPot().getMaximum_volume(),
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            volume_label.setAlignment(Align.center);
            volume_label.setName("volume_label");
            volume_label.setWrap(true);
            volume_label.setBounds(0, 0, 350, 120);
            out.addActor(volume_label);



        }else{
            Image pot_level_pane = new Image(atlas.findRegion("0%_pot_icon"));
            pot_level_pane.setPosition(0, 0);
            pot_level_pane.setName("pot_level_pane");
            out.addActor(pot_level_pane);

        }

        out.setName("pot_level_pane");
        return out;
    }
    private Group generate_button_sub_pane(){

        Group out = new Group();

        ImageButton takeoff_button = new ImageButton(skin, "takeoff_button");
        takeoff_button.setBounds(0, 0, 150, 150);
        takeoff_button.setName("take_off_button");
        takeoff_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                take_off_button_click();
            }
        });
        out.addActor(takeoff_button);

        ImageButton drop_100ml_button = new ImageButton(skin, "drop_100ml_button");
        drop_100ml_button.setBounds(150+20, 0, 150, 150);
        drop_100ml_button.setName("100ml_button");
        drop_100ml_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               drop_100ml_button_click();
            }
        });
        out.addActor(drop_100ml_button);

        ImageButton drop_1l_button = new ImageButton(skin, "drop_1l_button");
        drop_1l_button.setBounds(150+20+150+20, 0, 150, 150);
        drop_1l_button.setName("1l_button");
        drop_1l_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                drop_1l_button_click();
            }
        });
        out.addActor(drop_1l_button);

        ImageButton drop_10l_button = new ImageButton(skin, "drop_10l_button");
        drop_10l_button.setBounds(150+20+150+20+150+20, 0, 150, 150);
        drop_10l_button.setName("10l_button");
        drop_10l_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                drop_10l_button_click();
            }
        });
        out.addActor(drop_10l_button);

        ImageButton drop_all2_button = new ImageButton(skin, "drop_all2_button");
        drop_all2_button.setBounds(150+20+150+20+150+20+150+20, 0, 150, 150);
        drop_all2_button.setName("all2_button");
        drop_all2_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                drop_all2_button_click();
            }
        });
        out.addActor(drop_all2_button);

        ImageButton pro_help_button = new ImageButton(skin, "pro_help_button");
        pro_help_button.setBounds(150+20+150+20+150+20+150+20+150+20, 0, 150, 150);
        pro_help_button.setName("pro_help_button");
        pro_help_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               pro_help_button_click();
            }
        });
        out.addActor(pro_help_button);

        return out;
    }

    private Group generate_pot_pane() {

        Group out = new Group();

        Image background = new Image(atlas.findRegion("pot_pane_background"));
        background.setPosition(0, 0);
        background.setName("pot_pane_background");
        out.addActor(background);

        Table table = new Table();
        table.defaults().width(340).height(340);

        for(Storable current_pot : Inventory.getInstance().get_list(Inventory.Type.POT)){
            table.add(generate_pot_item_sub_pane((Pot)current_pot));
        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(false, true);
        pane.setBounds(0 ,0 ,1080 , 340);
        out.addActor(pane);

        out.setName("pot_pane");
        out.setPosition(0+40, 1920-40-670-20-340);
        return out;
    }
    private Group generate_pot_item_sub_pane(final Pot pot) {
        System.out.println(pot.getInfo());
        Group out = new Group();

        Image pot_image = pot.get_icon_pot();
        pot_image.setBounds(5, 5, 330, 330);
        pot_image.setName("item_icon");
        out.addActor(pot_image);

        Image front_pane = new Image(atlas.findRegion("small_front_pane"));
        front_pane.setBounds(0, 0, 340, 340);
        front_pane.setName("item_frame");
        out.addActor(front_pane);

        final ImageButton equip_button = new ImageButton(skin, "equip_button");
        equip_button.setBounds(0, 0, 120, 120);
        equip_button.setName("equip_button");
        equip_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                equip_button_clicked(pot);
            }
        });
        out.addActor(equip_button);

        final ImageButton delete_button = new ImageButton(skin, "delete_button");
        delete_button.setBounds(340 - 120, 0, 120, 120);
        delete_button.setName("delete_button");
        delete_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                delete_button_clicked(pot);
            }
        });
        out.addActor(delete_button);


            Label volume_label = new Label(
                    pot.getMaximum_volume() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );

        volume_label.setAlignment(Align.center);
        volume_label.setName("volume_label");
        volume_label.setWrap(true);
        volume_label.setBounds(0, 340 - 100, 100, 100);
        out.addActor(volume_label);



        return out;
    }

    private Group generate_bottle_pane() {

        Group out = new Group();

        Image background = new Image(atlas.findRegion("bottle_pane_background"));
        background.setPosition(0, 0);
        background.setName("bottle_pane_background");
        out.addActor(background);

        Table table = new Table();
        table.defaults().width(600).height(600);


        for(Storable current_bottle : Inventory.getInstance().get_list(Inventory.Type.BOTTLE)){
            table.add(generate_bottle_item_sub_pane((Bottle)current_bottle));
        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(false, true);
        pane.setBounds(0 ,0 ,1080 , 600);
        out.addActor(pane);

        out.setName("bottle_pane");
        out.setPosition(0+40, 1920-40-670-20-340-20-600);
        return out;
    }
    private Group generate_bottle_item_sub_pane(final Bottle bottle){
        Group out = new Group();

        Image bottle_icon = bottle.get_bottle_icon();
        bottle_icon.setBounds(0, 0, 600,600);
        bottle_icon.setName("bottle_icon");
        out.addActor(bottle_icon);

        Image front_pane = new Image(atlas.findRegion("big_front_pane"));
        front_pane.setBounds(0, 0, 600, 600);
        front_pane.setName("item_frame");
        out.addActor(front_pane);

        final ImageButton delete2_button = new ImageButton(skin, "delete2_button");
        delete2_button.setBounds(600-150, 150, 150, 150);
        delete2_button.setName("delete2_button");
        delete2_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                delete2_button_click(bottle);
            }
        });
        out.addActor(delete2_button);

        final ImageButton drop_all_button = new ImageButton(skin, "drop_all_button");
        drop_all_button.setBounds(600-150, 150+150, 150, 150);
        drop_all_button.setName("delete2_button");
        drop_all_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                drop_all_button_click(bottle);
            }
        });
        out.addActor(drop_all_button);

        final ImageButton drop_1ml_button = new ImageButton(skin, "drop_1ml_button");
        drop_1ml_button.setBounds(0, 150+150, 150, 150);
        drop_1ml_button.setName("drop_1ml_button");
        drop_1ml_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                drop_1ml_button_click(bottle);
            }
        });
        out.addActor(drop_1ml_button);

        final ImageButton drop_10ml_button = new ImageButton(skin, "drop_10ml_button");
        drop_10ml_button.setBounds(0, 150, 150, 150);
        drop_10ml_button.setName("drop_10ml_button");
        drop_10ml_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                drop_10ml_button_click(bottle);
            }
        });
        out.addActor(drop_10ml_button);



        Label N_label = new Label(
                bottle.getPercent_N() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        N_label.setAlignment(Align.center);
        N_label.setName("N_label");
        N_label.setWrap(true);
        N_label.setBounds(0, 500, 100, 100);
        out.addActor(N_label);

        Label P_label = new Label(
                bottle.getPercent_P() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        P_label.setAlignment(Align.center);
        P_label.setName("P_label");
        P_label.setWrap(true);
        P_label.setBounds(100, 500, 100, 100);
        out.addActor(P_label);

        Label K_label = new Label(
                bottle.getPercent_K() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        K_label.setAlignment(Align.center);
        K_label.setName("K_label");
        K_label.setWrap(true);
        K_label.setBounds(200, 500, 100, 100);
        out.addActor(K_label);

        Label S_label = new Label(
                bottle.getPercent_S() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        S_label.setAlignment(Align.center);
        S_label.setName("S_label");
        S_label.setWrap(true);
        S_label.setBounds(300, 500, 100, 100);
        out.addActor(S_label);

        Label Mg_label = new Label(
                bottle.getPercent_Mg() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        Mg_label.setAlignment(Align.center);
        Mg_label.setName("Mg_label");
        Mg_label.setWrap(true);
        Mg_label.setBounds(400, 500, 100, 100);
        out.addActor(Mg_label);

        Label Ca_label = new Label(
                bottle.getPercent_Ca() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        Ca_label.setAlignment(Align.center);
        Ca_label.setName("Ca_label");
        Ca_label.setWrap(true);
        Ca_label.setBounds(500, 500, 100, 100);
        out.addActor(Ca_label);



        Label B_label = new Label(
                bottle.getPercent_B() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        B_label.setAlignment(Align.center);
        B_label.setName("B_label");
        B_label.setWrap(true);
        B_label.setBounds(0, 0, 100, 100);
        out.addActor(B_label);

        Label Cu_label = new Label(
                bottle.getPercent_Cu() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        Cu_label.setAlignment(Align.center);
        Cu_label.setName("B_label");
        Cu_label.setWrap(true);
        Cu_label.setBounds(100, 0, 100, 100);
        out.addActor(Cu_label);

        Label Fe_label = new Label(
                bottle.getPercent_Fe() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        Fe_label.setAlignment(Align.center);
        Fe_label.setName("Fe_label");
        Fe_label.setWrap(true);
        Fe_label.setBounds(200, 0, 100, 100);
        out.addActor(Fe_label);

        Label Mn_label = new Label(
                bottle.getPercent_Mn() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        Mn_label.setAlignment(Align.center);
        Mn_label.setName("Mn_label");
        Mn_label.setWrap(true);
        Mn_label.setBounds(300, 0, 100, 100);
        out.addActor(Mn_label);

        Label Mo_label = new Label(
                bottle.getPercent_Mo() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        Mo_label.setAlignment(Align.center);
        Mo_label.setName("Mo_label");
        Mo_label.setWrap(true);
        Mo_label.setBounds(400, 0, 100, 100);
        out.addActor(Mo_label);

        Label Zn_label = new Label(
                bottle.getPercent_Zn() + "%",
                new Label.LabelStyle(alice_48_black, Color.BLACK)
        );
        Zn_label.setAlignment(Align.center);
        Zn_label.setName("Zn_label");
        Zn_label.setWrap(true);
        Zn_label.setBounds(500, 0, 100, 100);
        out.addActor(Zn_label);

        Label remain_label = new Label(
                (int) (bottle.getCurrent_volume()*1000)+"ml.",
                new Label.LabelStyle(alice_72_8F8F8F_stroke_black, Color.BLACK)
        );
        remain_label.setAlignment(Align.center);
        remain_label.setName("remain_label");
        remain_label.setWrap(true);
        remain_label.setBounds(0, 120, 600, 100);
        remain_label.setTouchable(Touchable.disabled);
        out.addActor(remain_label);

        Label name_label = new Label(
                bottle.getName()+"",
                new Label.LabelStyle(alice_72_8F8F8F_stroke_black, Color.BLACK)
        );
        name_label.setAlignment(Align.center);
        name_label.setName("name_label");
        name_label.setWrap(true);
        name_label.setBounds(0, 600-170, 600, 100);
        name_label.setTouchable(Touchable.disabled);
        out.addActor(name_label);


        return out;
    }
}
