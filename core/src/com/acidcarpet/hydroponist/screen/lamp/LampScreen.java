package com.acidcarpet.hydroponist.screen.lamp;

import com.acidcarpet.hydroponist.box.Box;
import com.acidcarpet.hydroponist.lamp.Lamp;
import com.acidcarpet.hydroponist.screen.box.BoxScreen;
import com.acidcarpet.hydroponist.storage.Inventory;
import com.acidcarpet.hydroponist.storage.Storable;
import com.acidcarpet.hydroponist.storage.Type;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class LampScreen implements Screen {
    private static boolean refresh;
    public static void update(){
        refresh = true;
    }

    Game game;



    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    BitmapFont alice_72_797E55;
    BitmapFont alice_62_797E55;
    BitmapFont alice_36_797E55;

    BitmapFont alice_48_F09191;
    BitmapFont alice_48_FFEF5E;


    public LampScreen(Game game){
        this.game = game;
    }

    private void takeoff_click(){
        Inventory.getInstance().add(Box.getInstance().getLamp());
        Box.getInstance().setLamp(null);
    }
    private void off_click(){
        Box.getInstance().getLamp().setOn(false);
    }
    private void on_click(){
        Box.getInstance().getLamp().setOn(true);
    }
    private void item_equip_click(Lamp lamp){
       Box.getInstance().setLamp(lamp);
       Inventory.getInstance().delete(lamp);
    }
    private void item_delete_click(Lamp lamp){
        Inventory.getInstance().delete(lamp);
        Inventory.update();
    }
    private void back_button_click(){
        game.setScreen(new BoxScreen(game));
    }

    @Override
    public void show() {
        stage = new Stage(new ExtendViewport(1080, 1920));

        LampResources.set_all();
        atlas = LampResources.getAtlas();
        skin = LampResources.getSkin();
        Gdx.input.setInputProcessor(stage);

         alice_72_797E55 = LampResources.getAlice_72_797E55();
         alice_62_797E55 = LampResources.getAlice_62_797E55();
         alice_36_797E55 = LampResources.getAlice_36_797E55();

         alice_48_F09191 = LampResources.getAlice_48_F09191();
         alice_48_FFEF5E = LampResources.getAlice_48_FFEF5E();

        Image background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        background.setName("background");
        stage.addActor(background);

        stage.addActor(generate_lamp_pane());
        stage.addActor(generate_items_pane());
        stage.addActor(generate_buttons_pane());
    }

    @Override
    public void render(float delta) {

        if(refresh){

            try{    stage.getRoot().findActor("lamp_pane").clearListeners();                 } catch(Exception e){ e.printStackTrace();}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("lamp_pane"));     } catch(Exception e){ e.printStackTrace();}

            try{    stage.addActor(generate_lamp_pane());                                           } catch(Exception e){ e.printStackTrace();}

            try{    stage.getRoot().findActor("items_pane").clearListeners();               } catch(Exception e){ e.printStackTrace();}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("items_pane"));   } catch(Exception e){ e.printStackTrace();}

            try{    stage.addActor(generate_items_pane());                                         } catch(Exception e){ e.printStackTrace();}

            refresh=false;
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
        LampResources.dispose_all();
    }

    private Group generate_lamp_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("lamp_background"));
        background.setBounds(0 , 0, 1080, 450);
        background.setName("lamp_background");
        out.addActor(background);

        if(Box.getInstance().getLamp()!=null){

            Image fan_pane = new Image(atlas.findRegion("lamp_pane"));
            fan_pane.setPosition(0, 0);
            fan_pane.setName("lamp_pane");
            out.addActor(fan_pane);

            LabelStyle title_style = new LabelStyle();
            title_style.font = alice_72_797E55;
            Label title_label = new  Label(Box.getInstance().getLamp().get_name(),title_style);
            title_label.setWrap(false);
            title_label.setAlignment(Align.center);
            title_label.setBounds(0, 450-120, 1080, 120);
            title_label.setName("title_label");
            out.addActor(title_label);

            LabelStyle description_style = new LabelStyle();
            description_style.font = alice_36_797E55;
            Label description_label = new Label(Box.getInstance().getLamp().get_description(), description_style);
            description_label.setWrap(true);
            description_label.setAlignment(Align.center);
            description_label.setBounds(20, 450-120-250, 1040, 250);
            description_label.setName("description_label");
            out.addActor(description_label);

            LabelStyle temperature_style = new LabelStyle();
            temperature_style.font = alice_48_F09191;
            Label temperature_label = new   Label("+"+Box.getInstance().getLamp().getTemperature()+"C  ", temperature_style);
            temperature_label.setWrap(false);
            temperature_label.setAlignment(Align.right);
            temperature_label.setBounds(215, 15, 325, 80);
            temperature_label.setName("temperature_label");
            out.addActor(temperature_label);

            LabelStyle light_style = new LabelStyle();
            light_style.font = alice_48_FFEF5E;
            Label light_label = new   Label(""+(int)(Box.getInstance().getLamp().getEnergy_production())+"W ", light_style);
            light_label.setWrap(false);
            light_label.setAlignment(Align.right);
            light_label.setBounds(215+325, 15, 325, 80);
            light_label.setName("light_label");
            out.addActor(light_label);

            ImageButton take_off_button = new ImageButton(skin, "take_off_button");
            take_off_button.setName("take_off_button");
            take_off_button.setPosition(15, 15);
            take_off_button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    takeoff_click();
                }
            });
            out.addActor(take_off_button);


            if(Box.getInstance().getLamp().isOn()){
                ImageButton off_button = new ImageButton(skin, "off_button");
                off_button.setName("power_button");
                off_button.setPosition(1080-15-200, 15);
                off_button.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        off_click();
                    }
                });
                out.addActor(off_button);
            }else{
                ImageButton on_button = new ImageButton(skin, "on_button");
                on_button.setName("power_button");
                on_button.setPosition(1080-15-200, 15);
                on_button.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        on_click();
                    }
                });
                out.addActor(on_button);
            }

        }

        out.setName("lamp_pane");
        out.setPosition(0, 1920-450);

        return out;
    }

    private Group generate_items_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("items_background"));
        background.setPosition(0 , 0);
        background.setName("items_background");
        out.addActor(background);

        Table table = new Table();
        table.defaults().width(1080).height(230);

        for(Storable current_lamp : Inventory.getInstance().get_list(Type.LAMP)){

            table.add(generate_item((Lamp)current_lamp));
            table.row();

        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(true, false);
        pane.setBounds(0 ,0 ,1080 , 1310);
        out.addActor(pane);

        out.setName("items_pane");
        out.setPosition(0, 1920-1310-450);

        return out;
    }
    private Group generate_item(final Lamp lamp){
        Group out = new Group();

        Image item_pane = new Image(atlas.findRegion("sub_lamp_pane"));
        item_pane.setPosition(0, 0);
        item_pane.setName("sub_lamp_pane");
        item_pane.setTouchable(Touchable.disabled);
        out.addActor(item_pane);

        LabelStyle title_style = new LabelStyle();
        title_style.font = alice_62_797E55;
        Label title_label = new  Label(lamp.get_name(),title_style);
        title_label.setWrap(false);
        title_label.setAlignment(Align.center);
        title_label.setBounds(0, 220-120, 1080, 120);
        title_label.setName("title_label");
        out.addActor(title_label);

        LabelStyle temperature_style = new LabelStyle();
        temperature_style.font = alice_48_F09191;
        Label temperature_label = new   Label("+"+lamp.getTemperature()+"C ", temperature_style);
        temperature_label.setWrap(false);
        temperature_label.setAlignment(Align.right);
        temperature_label.setBounds(215, 15, 325, 80);
        temperature_label.setName("temperature_label");
        out.addActor(temperature_label);

        LabelStyle light_style = new LabelStyle();
        light_style.font = alice_48_FFEF5E;
        Label light_label = new   Label(""+(int)(lamp.getEnergy_production())+"W ", light_style);
        light_label.setWrap(false);
        light_label.setAlignment(Align.right);
        light_label.setBounds(215+325, 15, 325, 80);
        light_label.setName("light_label");
        out.addActor(light_label);

        ImageButton equip_button = new ImageButton(skin, "equip_button");
        equip_button.setPosition(1080-200-15, 15);
        equip_button.setName("equip_button");
        equip_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                item_equip_click(lamp);
            }
        });
        out.addActor(equip_button);

        ImageButton delete_button = new ImageButton(skin, "delete_button");
        delete_button.setPosition(15, 15);
        delete_button.setName("delete_button");
        delete_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                item_delete_click(lamp);
            }
        });
        out.addActor(delete_button);

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
        out.setPosition(0, 0);
        return out;
    }

}
