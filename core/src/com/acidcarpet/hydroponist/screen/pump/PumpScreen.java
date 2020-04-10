package com.acidcarpet.hydroponist.screen.pump;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.Fan;
import com.acidcarpet.hydroponist.equipment.Pump;
import com.acidcarpet.hydroponist.screen.box.BoxScreen;
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
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class PumpScreen implements Screen {

    Game game;

    long box_last_update;
    long inventory_last_update;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    private static BitmapFont alice_72_797E55;
    private static BitmapFont alice_62_797E55;
    private static BitmapFont alice_36_797E55;

    private static BitmapFont alice_48_ACE5F8;

    public PumpScreen(Game game){
        this.game = game;
        box_last_update = 1;
        inventory_last_update = 1;

    }

    private void takeoff_click(){
        Box.getInstance().take_off_pump();
    }
    private void off_click(){
        Box.getInstance().getPump().set_off();
    }
    private void on_click(){
        Box.getInstance().getPump().set_on();
    }
    private void item_equip_click(Pump pump){
        Box.getInstance().equip(pump);
    }
    private void item_delete_click(Pump pump){
        Inventory.getInstance().delete(pump);
        Inventory.update();
    }
    private void back_button_click(){
        game.setScreen(new BoxScreen(game));
    }

    @Override
    public void show() {

        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = PumpResources.getAtlas();
        skin = PumpResources.getSkin();
        Gdx.input.setInputProcessor(stage);

        alice_72_797E55 = PumpResources.getAlice_72_797E55();
        alice_62_797E55 = PumpResources.getAlice_62_797E55();
        alice_36_797E55 = PumpResources.getAlice_36_797E55();

        alice_48_ACE5F8 = PumpResources.getAlice_48_ACE5F8();

        Image background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        background.setName("background");
        stage.addActor(background);

        stage.addActor(generate_pump_pane());
        stage.addActor(generate_items_pane());
        stage.addActor(generate_buttons_pane());

    }

    @Override
    public void render(float delta) {

        if(box_last_update !=Box.get_last_update()){

            try{    stage.getRoot().findActor("pump_pane").clearListeners();                 } catch(Exception e){ e.printStackTrace();}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("pump_pane"));     } catch(Exception e){ e.printStackTrace();}

            try{    stage.addActor(generate_pump_pane());                                           } catch(Exception e){ e.printStackTrace();}

            box_last_update = Box.get_last_update();
        }

        if(inventory_last_update!=Inventory.last_update()){
            try{    stage.getRoot().findActor("items_pane").clearListeners();               } catch(Exception e){ e.printStackTrace();}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("items_pane"));   } catch(Exception e){ e.printStackTrace();}

            try{    stage.addActor(generate_items_pane());                                         } catch(Exception e){ e.printStackTrace();}

            inventory_last_update = Inventory.last_update();
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
    }

    private Group generate_pump_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("pump_background"));
        background.setBounds(0 , 0, 1080, 450);
        background.setName("pump_background");
        out.addActor(background);

        if(Box.getInstance().getPump()!=null){

            Image pump_pane = new Image(atlas.findRegion("pump_pane"));
            pump_pane.setPosition(0, 0);
            pump_pane.setName("pump_pane");
            out.addActor(pump_pane);

            LabelStyle title_style = new LabelStyle();
            title_style.font = alice_72_797E55;
            Label title_label = new  Label(Box.getInstance().getPump().getName(),title_style);
            title_label.setWrap(false);
            title_label.setAlignment(Align.center);
            title_label.setBounds(0, 450-120, 1080, 120);
            title_label.setName("title_label");
            out.addActor(title_label);

            LabelStyle description_style = new LabelStyle();
            description_style.font = alice_36_797E55;
            Label description_label = new Label(Box.getInstance().getPump().getDescription(), description_style);
            description_label.setWrap(true);
            description_label.setAlignment(Align.center);
            description_label.setBounds(20, 450-120-250, 1040, 250);
            description_label.setName("description_label");
            out.addActor(description_label);

            LabelStyle oxygen_style = new LabelStyle();
            oxygen_style.font = alice_48_ACE5F8;
            Label oxygen_label = new   Label(""+(int)(Box.getInstance().getPump().getOxygen_production()*1000)+"ml ", oxygen_style);
            oxygen_label.setWrap(false);
            oxygen_label.setAlignment(Align.right);
            oxygen_label.setBounds(215+325, 15, 325, 80);
            oxygen_label.setName("oxygen_label");
            out.addActor(oxygen_label);

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


            if(Box.getInstance().getPump().isOn()){
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

        out.setName("pump_pane");
        out.setPosition(40, 1920-450);

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



        for(Storable current_pump : Inventory.getInstance().get_list(Inventory.Type.PUMP)){

            table.add(generate_item((Pump)current_pump));
            table.row();

        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(true, false);
        pane.setBounds(0 ,0 ,1080 , 1310);
        out.addActor(pane);

        out.setName("items_pane");
        out.setPosition(40, 1920-1310-450);

        return out;
    }
    private Group generate_item(final Pump pump){
        Group out = new Group();

        Image item_pane = new Image(atlas.findRegion("sub_pump_pane"));
        item_pane.setPosition(0, 0);
        item_pane.setName("sub_pump_pane");
        item_pane.setTouchable(Touchable.disabled);
        out.addActor(item_pane);

        LabelStyle title_style = new LabelStyle();
        title_style.font = alice_62_797E55;
        Label title_label = new  Label(pump.getName(),title_style);
        title_label.setWrap(false);
        title_label.setAlignment(Align.center);
        title_label.setBounds(0, 220-120, 1080, 120);
        title_label.setName("title_label");
        out.addActor(title_label);

        LabelStyle oxygen_style = new LabelStyle();
        oxygen_style.font = alice_48_ACE5F8;
        Label oxygen_label = new   Label(""+(int)(pump.getOxygen_production()*1000)+"ml ", oxygen_style);
        oxygen_label.setWrap(false);
        oxygen_label.setAlignment(Align.right);
        oxygen_label.setBounds(215+325, 15, 325, 80);
        oxygen_label.setName("oxygen_label");
        out.addActor(oxygen_label);

        ImageButton equip_button = new ImageButton(skin, "equip_button");
        equip_button.setPosition(1080-200-15, 15);
        equip_button.setName("equip_button");
        equip_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                item_equip_click(pump);
            }
        });
        out.addActor(equip_button);

        ImageButton delete_button = new ImageButton(skin, "delete_button");
        delete_button.setPosition(15, 15);
        delete_button.setName("delete_button");
        delete_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                item_delete_click(pump);
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
        out.setPosition(40, 0);
        return out;
    }

}

