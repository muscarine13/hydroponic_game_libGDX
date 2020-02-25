package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.Fan;
import com.acidcarpet.hydroponist.equipment.Lamp;
import com.acidcarpet.hydroponist.player.Inventory;
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

import static java.lang.String.*;

public class FanScreen implements Screen {

    Game game;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    BitmapFont alice_48_green;
    BitmapFont alice_36_white;
    BitmapFont alice_36_373737_stroke_black;
    BitmapFont alice_25_black;
    BitmapFont alice_40_black;
    BitmapFont alice_28_555555;

    boolean refresh;

    public FanScreen(Game game){
        this.game = game;

    }

    private void takeoff_click(){
        Inventory.getInstance().takeoff_fan();
        refresh = true;
    }
    private void off_click(){
        Box.getInstance().getFan().set_off();
        refresh = true;
    }
    private void on_click(){
        Box.getInstance().getFan().set_on();
        refresh = true;
    }
    private void item_equip_click(Fan fan){
        Inventory.getInstance().equip_fan(fan);
        refresh = true;
    }
    private void item_delete_click(Fan fan){
        Inventory.getInstance().delete_fan(fan);
        refresh = true;
    }
    private void back_button_click(){
        game.setScreen(new BoxScreen(game));

    }

    private Group generate_infopane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("infopane_background"));
        background.setPosition(0 , 0);
        background.setName("infopane_background");
        out.addActor(background);

        if(Box.getInstance().getFan()!=null){// лампа есть и надо получить ее новую карточку

            Image item_icon = Box.getInstance().getFan().get_image_item();
            item_icon.setBounds(20, 490, 300, 300);
            item_icon.setName("infopane_item_image");
            out.addActor(item_icon);

            Label title_label = new  Label(
                    Box.getInstance().getFan().name(),
                    new LabelStyle(alice_48_green, Color.GREEN)
            );
            title_label.setWrap(true);
            title_label.setAlignment(Align.center);
            title_label.setBounds(340, 490, 700, 300);
            title_label.setName("infopane_name_label");
            out.addActor(title_label);

            Label description_label = new   Label(
                    Box.getInstance().getFan().description(),
                    new LabelStyle(alice_36_white, Color.GREEN)
            );
            description_label.setWrap(true);
            description_label.setAlignment(Align.center);
            description_label.setBounds(20, 170, 1040, 300);
            description_label.setName("infopane_description_label");
            out.addActor(description_label);

            Image co2_icon = new Image(atlas.findRegion("co2_icon"));
            co2_icon.setBounds(20, 20, 150, 150);
            co2_icon.setName("infopane_co2_icon");
            out.addActor(co2_icon);
            Label co2_label = new Label(
                    ""+Box.getInstance().getFan().getCO2_production(),
                    new LabelStyle(alice_40_black,  Color.BLACK)
            );
            co2_label.setAlignment(Align.right);
            co2_label.setBounds(20, 20, 140, 150);
            co2_label.setName("infopane_co2_label");
            out.addActor(co2_label);

            Image temp_icon = new Image((atlas.findRegion("temperature_icon")));
            temp_icon.setName("infopane_temp_icon");
            temp_icon.setBounds(20+150+20, 20, 150, 150);
            out.addActor(temp_icon);
            Label temp_label = new Label(
                    "-"+format("%.2f", Box.getInstance().getFan().getT_reduce()),
                    new LabelStyle(alice_40_black,  Color.BLACK)
            );
            temp_label.setAlignment(Align.right);
            temp_label.setBounds(20+150+20, 20, 140, 150);
            temp_label.setName("infopane_temp_label");
            out.addActor(temp_label);

            ImageButton takeoff_button = new ImageButton(skin, "takeoff_button");
            takeoff_button.setName("infopane_takeoff_button");
            takeoff_button.setBounds(910, 20, 150, 150);
            takeoff_button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    takeoff_click();
                }
            });
            out.addActor(takeoff_button);


            if(Box.getInstance().getFan().isOn()){
                ImageButton off_button = new ImageButton(skin, "off_button");
                off_button.setName("infopane_power_button");
                off_button.setBounds(740, 20, 150, 150);
                off_button.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        off_click();
                    }
                });
                out.addActor(off_button);
            }else{
                ImageButton on_button = new ImageButton(skin, "on_button");
                on_button.setName("infopane_power_button");
                on_button.setBounds(740, 20, 150, 150);
                on_button.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        on_click();
                    }
                });
                out.addActor(on_button);
            }


        }
        else{// лампы нет никакой и нужна заглушка

            Label title_label = new   Label(
                    "ПУСТО",
                    new LabelStyle(alice_48_green, Color.GREEN)
            );
            title_label.setWrap(true);
            title_label.setAlignment(Align.center);
            title_label.setBounds(340, 490, 700, 300);
            title_label.setName("infopane_name_label");
            out.addActor(title_label);


            Label description_label = new   Label(
                    "В данный момент у вас нет активного вентилятора. Растение не будет получать необходимый объем цо2 для роста и жизни. Так же не будет понижаться температура внутри бокса.",
                    new LabelStyle(alice_36_white, Color.GREEN)
            );
            description_label.setWrap(true);
            description_label.setAlignment(Align.center);
            description_label.setBounds(20, 20, 1040, 450);
            description_label.setName("infopane_description_label");
            out.addActor(description_label);

        }


        out.setName("infopane");
        out.setPosition(40, 1070);

        return out;

    }

    private Group generate_item(final Fan fan){
        Group out = new Group();
        //out.setTouchable(Touchable.disabled);
        try {

            Image item_icon = fan.get_image_item();
            //item_icon.setTouchable(Touchable.disabled);
            item_icon.setName("item_icon");
            item_icon.setBounds(0, 0, 340, 340);
            out.addActor(item_icon);

            ImageButton equip = new ImageButton(skin, "equip_button");
            equip.setBounds(0, 0, 120, 120);
            equip.setName("item_equip_button");
            equip.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {

                    item_equip_click(fan);
                }
            });
            out.addActor(equip);


            ImageButton delete = new ImageButton(skin, "delete_button");
            delete.setBounds(340 - 120, 0, 120, 120);
            delete.setName("item_delete_button");
            delete.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    item_delete_click(fan);
                }
            });
            out.addActor(delete);

            Image item_frontpane = new Image(atlas.findRegion("item_frontpane"));
            item_frontpane.setPosition(0, 0);
            item_frontpane.setName("item_frontpane");
            item_frontpane.setTouchable(Touchable.disabled);
            out.addActor(item_frontpane);

            Label co2_label = new Label(
                    fan.getCO2_production() + "",
                    new LabelStyle(alice_28_555555, Color.BLACK)
            );
            co2_label.setAlignment(Align.right);
            co2_label.setName("item_co2_label");
            co2_label.setWrap(true);
            co2_label.setBounds(0, 250, 80, 90);
            out.addActor(co2_label);

            Label temp_label = new Label(
                    "+"+fan.getT_reduce(),
                    new LabelStyle(alice_28_555555, Color.BLACK)
            );
            temp_label.setAlignment(Align.right);
            temp_label.setName("item_temp_label");
            temp_label.setWrap(true);
            temp_label.setBounds(250, 250, 80, 90);
            out.addActor(temp_label);

            Label name_label = new Label(
                    fan.name(),
                    new LabelStyle(alice_36_373737_stroke_black, Color.BLACK)
            );
            name_label.setAlignment(Align.center);
            name_label.setName("item_name_label");
            name_label.setWrap(true);
            name_label.setTouchable(Touchable.disabled);
            name_label.setBounds(0, 0, 340, 340);
            out.addActor(name_label);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return out;
    }
    private Group generate_scrollpane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("scrollpane_background"));
        background.setPosition(0 , 0);
        background.setName("scrollpane_background");
        out.addActor(background);

        Table table = new Table();
        table.defaults().width(340).height(340);

        int i = 0;
        for(Fan current_fan : Inventory.getInstance().get_fan_inventory()){
            if(i>=3) {
                i=0;
                table.row();
            }
            table.add(generate_item(current_fan));
            i++;

        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(true, false);
        pane.setBounds(0 ,0 ,1080 , 740);
        out.addActor(pane);

        out.setName("scrollpane");
        out.setPosition(40, 310);

        return out;
    }


    @Override
    public void show() {

        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = ScreenAssets.getInstance().getFanScreen_atlas();
        skin = ScreenAssets.getInstance().getFanScreen_skin();
        Gdx.input.setInputProcessor(stage);

        alice_48_green = ScreenAssets.getInstance().alice_48_green;
        alice_36_white = ScreenAssets.getInstance().alice_36_white;
        alice_25_black = ScreenAssets.getInstance().alice_25_black;
        alice_40_black = ScreenAssets.getInstance().alice_40_black;
        alice_28_555555 = ScreenAssets.getInstance().alice_28_555555;
        alice_36_373737_stroke_black = ScreenAssets.getInstance().alice_36_373737_stroke_black;

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

        stage.addActor(generate_infopane());
        stage.addActor(generate_scrollpane());
    }

    @Override
    public void render(float delta) {

        if(refresh){

            stage.getRoot().findActor("infopane").clearListeners();
            stage.getRoot().removeActor(stage.getRoot().findActor("infopane"));
            stage.addActor(generate_infopane());

            stage.getRoot().findActor("scrollpane").clearListeners();
            stage.getRoot().removeActor(stage.getRoot().findActor("scrollpane"));
            stage.addActor(generate_scrollpane());

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
        skin.dispose();
        atlas.dispose();
        stage.dispose();
    }

}
