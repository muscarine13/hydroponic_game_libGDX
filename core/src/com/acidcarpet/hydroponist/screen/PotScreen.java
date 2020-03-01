package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.Pot;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;


public class PotScreen implements Screen {

    Game game;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    boolean refresh;

    BitmapFont alice_48_green;
    BitmapFont alice_48_black;

    PotScreen(Game game){
        this.game = game;
    }


    void back_button_click(){

    }

    public void take_off_button_click(){

    }
    public void drop_100ml_button_click(){

    }
    public void drop_1l_button_click(){

    }
    public void drop_10l_button_click(){

    }
    public void drop_all2_button_click(){

    }
    public void pro_help_button_click(){

    }

    @Override
    public void show() {
        this.game = game;

        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = ScreenAssets.getInstance().getPumpScreen_atlas();
        skin = ScreenAssets.getInstance().getPumpScreen_skin();
        Gdx.input.setInputProcessor(stage);

        alice_48_green = ScreenAssets.getInstance().getAlice_48_green();
        alice_48_black = ScreenAssets.getInstance().getAlice_48_green();

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

        stage.addActor(generate_info_pane());
        stage.addActor(generate_bottle_pane());
        stage.addActor(generate_pot_pane());

    }

    @Override
    public void render(float delta) {
        if(refresh){

            stage.getRoot().findActor("info_pane").clearListeners();
            stage.getRoot().removeActor(stage.getRoot().findActor("info_pane"));
            stage.addActor(generate_info_pane());

            stage.getRoot().findActor("bottle_pane").clearListeners();
            stage.getRoot().removeActor(stage.getRoot().findActor("bottle_pane"));
            stage.addActor(generate_bottle_pane());

            stage.getRoot().findActor("pot_pane").clearListeners();
            stage.getRoot().removeActor(stage.getRoot().findActor("pot_pane"));
            stage.addActor(generate_pot_pane());

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

    }

    private Group generate_info_pane(){

        Group out = new Group();

        Image background = new Image(atlas.findRegion("info_pane_background"));
        background.setPosition(40, 1200);
        background.setName("info_pane_background");
        out.addActor(background);





        Image micro_frame = new Image(atlas.findRegion("micro_frame"));
        micro_frame.setBounds((1080-300-20-40), 810-20-117-20-300, 300, 300);
        micro_frame.setName("micro_frame");
        out.addActor(micro_frame);




if(Box.getInstance().getPot()!=null){

    Label name_label = new Label(
            Box.getInstance().getPot().name() + "",
            new Label.LabelStyle(alice_48_green, Color.BLACK)
    );
    name_label.setAlignment(Align.right);
    name_label.setName("info_pane_name");
    name_label.setWrap(true);
    name_label.setBounds(20+40, 1920-20-117-20, 1040, 117);
    out.addActor(name_label);




}else{

    Label name_label = new Label(
            "ПУСТО",
            new Label.LabelStyle(alice_48_green, Color.BLACK)
    );
    name_label.setAlignment(Align.right);
    name_label.setName("info_pane_name");
    name_label.setWrap(true);
    name_label.setBounds(20+40, 1920-117-20, 1040, 117);
    out.addActor(name_label);

}



        return out;
    }


    private Group generate_macro_sub_pane(){

        Group out = new Group();

        Image macro_frame = new Image(atlas.findRegion("macro_frame"));
        macro_frame.setBounds(20+40, 810-20-117-20-300, 300, 300);
        macro_frame.setName("macro_frame");
        out.addActor(macro_frame);

        if(Box.getInstance().getPot()!=null){

            Label N_label = new Label(
                    Box.getInstance().getPot().element_ppm_N() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            N_label.setAlignment(Align.center);
            N_label.setName("macro_frame_N");
            N_label.setWrap(true);
            N_label.setBounds(20+15, 150, 100, 100);
            out.addActor(N_label);

            Label P_label = new Label(
                    Box.getInstance().getPot().element_ppm_P() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            P_label.setAlignment(Align.center);
            P_label.setName("macro_frame_P");
            P_label.setWrap(true);
            P_label.setBounds(100, 300-100, 100, 100);
            out.addActor(P_label);

            Label K_label = new Label(
                    Box.getInstance().getPot().element_ppm_K() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            K_label.setAlignment(Align.center);
            K_label.setName("macro_frame_K");
            K_label.setWrap(true);
            K_label.setBounds(300-100-15, 150, 100, 100);
            out.addActor(K_label);

            Label S_label = new Label(
                    Box.getInstance().getPot().element_ppm_S() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            S_label.setAlignment(Align.center);
            S_label.setName("macro_frame_S");
            S_label.setWrap(true);
            S_label.setBounds(20+15, 150-100, 100, 100);
            out.addActor(S_label);
            Label Mg_label = new Label(
                    Box.getInstance().getPot().element_ppm_Mg() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Mg_label.setAlignment(Align.center);
            Mg_label.setName("macro_frame_Mg");
            Mg_label.setWrap(true);
            Mg_label.setBounds(100, 0, 100, 100);
            out.addActor(Mg_label);

            Label Ca_label = new Label(
                    Box.getInstance().getPot().element_ppm_Ca() + "",
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
        macro_frame.setBounds(20+40, 810-20-117-20-300, 300, 300);
        macro_frame.setName("micro_frame");
        out.addActor(macro_frame);

        if(Box.getInstance().getPot()!=null){

            Label B_label = new Label(
                    Box.getInstance().getPot().element_ppm_B() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            B_label.setAlignment(Align.center);
            B_label.setName("micro_frame_B");
            B_label.setWrap(true);
            B_label.setBounds(20+15, 150, 100, 100);
            out.addActor(B_label);

            Label Cu_label = new Label(
                    Box.getInstance().getPot().element_ppm_Cu() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Cu_label.setAlignment(Align.center);
            Cu_label.setName("micro_frame_Cu");
            Cu_label.setWrap(true);
            Cu_label.setBounds(100, 300-100, 100, 100);
            out.addActor(Cu_label);

            Label Fe_label = new Label(
                    Box.getInstance().getPot().element_ppm_Fe() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Fe_label.setAlignment(Align.center);
            Fe_label.setName("micro_frame_Fe");
            Fe_label.setWrap(true);
            Fe_label.setBounds(300-100-15, 150, 100, 100);
            out.addActor(Fe_label);

            Label Mn_label = new Label(
                    Box.getInstance().getPot().element_ppm_Mn() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Mn_label.setAlignment(Align.center);
            Mn_label.setName("micro_frame_Mn");
            Mn_label.setWrap(true);
            Mn_label.setBounds(20+15, 150-100, 100, 100);
            out.addActor(Mn_label);

            Label Mo_label = new Label(
                    Box.getInstance().getPot().element_ppm_Mo() + "",
                    new Label.LabelStyle(alice_48_black, Color.BLACK)
            );
            Mo_label.setAlignment(Align.center);
            Mo_label.setName("micro_frame_Mo");
            Mo_label.setWrap(true);
            Mo_label.setBounds(100, 0, 100, 100);
            out.addActor(Mo_label);

            Label Zn_label = new Label(
                    Box.getInstance().getPot().element_ppm_Zn() + "",
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

            int percent = (int) (Box.getInstance().getPot().getCurrent_volume()/Box.getInstance().getPot().getMaximum_volume())*100;

            if(percent==0){
                Image pot_level_pane = new Image(atlas.findRegion("0%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=1&&percent<=10){
                Image pot_level_pane = new Image(atlas.findRegion("10%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=11&&percent<=20){
                Image pot_level_pane = new Image(atlas.findRegion("20%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=21&&percent<=30){
                Image pot_level_pane = new Image(atlas.findRegion("30%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=31&&percent<=40){
                Image pot_level_pane = new Image(atlas.findRegion("40%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=41&&percent<=50){
                Image pot_level_pane = new Image(atlas.findRegion("50%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=51&&percent<=60){
                Image pot_level_pane = new Image(atlas.findRegion("60%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=61&&percent<=70){
                Image pot_level_pane = new Image(atlas.findRegion("70%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=71&&percent<=80){
                Image pot_level_pane = new Image(atlas.findRegion("80%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=81&&percent<=90){
                Image pot_level_pane = new Image(atlas.findRegion("90%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }
            if (percent>=91&&percent<=100){
                Image pot_level_pane = new Image(atlas.findRegion("100%_pot_icon"));
                pot_level_pane.setPosition(0, 0);
                pot_level_pane.setName("pot_level_pane");
                out.addActor(pot_level_pane);
            }

            Image ph_icon = new Image(atlas.findRegion("ph_icon"));
            ph_icon.setPosition(0, 300-100);
            ph_icon.setName("ph_icon");
            out.addActor(ph_icon);

            Image ppm_icon = new Image(atlas.findRegion("ppm_icon"));
            ppm_icon.setPosition(300-100, 300-100);
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
            ppm_label.setBounds(300-100, 300-100, 100, 100);
            out.addActor(ppm_label);



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

        ImageButton drop_100ml_button = new ImageButton(skin, "100ml_button");
        drop_100ml_button.setBounds(150+20, 0, 150, 150);
        drop_100ml_button.setName("100ml_button");
        drop_100ml_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               drop_100ml_button_click();
            }
        });
        out.addActor(drop_100ml_button);

        ImageButton drop_1l_button = new ImageButton(skin, "1l_button");
        drop_1l_button.setBounds(150+20+150+20, 0, 150, 150);
        drop_1l_button.setName("1l_button");
        drop_1l_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                drop_1l_button_click();
            }
        });
        out.addActor(drop_1l_button);

        ImageButton drop_10l_button = new ImageButton(skin, "10l_button");
        drop_10l_button.setBounds(150+20+150+20+150+20, 0, 150, 150);
        drop_10l_button.setName("10l_button");
        drop_10l_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                drop_10l_button_click();
            }
        });
        out.addActor(drop_10l_button);

        ImageButton drop_all2_button = new ImageButton(skin, "all2_button");
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


    private Group generate_bottle_pane(){

    }
    private Group generate_pot_pane(){

    }
}
