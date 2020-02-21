package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.Lamp;
import com.acidcarpet.hydroponist.genered.test_pack.TestLamp;
import com.acidcarpet.hydroponist.player.Inventory;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
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

public class LampScreen implements Screen {

    Game game;
    private final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    BitmapFont alice_48_green;
    BitmapFont alice_36_white;
    BitmapFont alice_36_373737_stroke_black;
    BitmapFont alice_25_black;
    BitmapFont alice_40_black;
    BitmapFont alice_28_555555;

    Group infopane_empty;
    Group scrollpane_empty;

    public LampScreen(Game game){
        this.game = game;

    }


    private void takeoff_click(){

    }
    private void off_click(){

    }
    private void on_click(){

    }
    private void item_equip_click(Lamp lamp){

        System.out.println("1123");
    }
    private void item_delete_click(Lamp lamp){
        System.out.println("asdasdasd");
    }

    private Group generate_infopane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("infopane_background"));
        background.setPosition(0 , 0);
        background.setName("infopane_background");
        out.addActor(background);

        if(Box.getInstance().getLamp()!=null){// лампа есть и надо получить ее новую карточку

            Image item_icon = Box.getInstance().getLamp().get_image_item();
            item_icon.setBounds(20, 490, 300, 300);
            item_icon.setName("infopane_item_image");
            out.addActor(item_icon);

            Label title_label = new  Label(
                    Box.getInstance().getLamp().name(),
                    new LabelStyle(alice_48_green, Color.GREEN)
            );
            title_label.setWrap(true);
            title_label.setAlignment(Align.center);
            title_label.setBounds(340, 490, 700, 300);
            title_label.setName("infopane_name_label");
            out.addActor(title_label);

            Label description_label = new   Label(
                    Box.getInstance().getLamp().description(),
                    new LabelStyle(alice_36_white, Color.GREEN)
            );
            description_label.setWrap(true);
            description_label.setAlignment(Align.center);
            description_label.setBounds(20, 170, 1040, 300);
            description_label.setName("infopane_description_label");
            out.addActor(description_label);

            Image light_icon = new Image(atlas.findRegion("light_icon"));
            light_icon.setBounds(20, 20, 150, 150);
            light_icon.setName("infopane_light_icon");
            out.addActor(light_icon);
            Label light_label = new Label(
                    ""+Box.getInstance().getLamp().getLm_production(),
                    new LabelStyle(alice_40_black,  Color.BLACK)
            );
            light_label.setAlignment(Align.right);
            light_label.setBounds(20, 20, 140, 150);
            light_label.setName("infopane_light_label");
            out.addActor(light_label);

            Image temp_icon = new Image((atlas.findRegion("temperature_icon")));
            temp_icon.setName("infopane_temp_icon");
            temp_icon.setBounds(20+150+20, 20, 150, 150);
            out.addActor(temp_icon);
            Label temp_label = new Label(
                    "+"+format("%.2f", Box.getInstance().getLamp().getT_add()),
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


            if(Box.getInstance().getLamp().isOn()){
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
                    "В данный момент у вас нет активной лампы. Темновая фаза растения протекает только при экипированной лампе, хоть и отключенной. Во время попытки вырасти без лампы будет убавлятся здоровье.",
                    new LabelStyle(alice_36_white, Color.GREEN)
            );
            description_label.setWrap(true);
            description_label.setAlignment(Align.center);
            description_label.setBounds(20, 20, 1040, 450);
            description_label.setName("infopane_description_label");
            out.addActor(description_label);

        }

        return out;

    }

    private Group generate_item(final Lamp lamp){
        Group out = new Group();
        //out.setTouchable(Touchable.disabled);
        try {

            Image item_icon = lamp.get_image_item();
            //item_icon.setTouchable(Touchable.disabled);
            item_icon.setName("item_icon");
            item_icon.setPosition(0, 0);
            out.addActor(item_icon);

            ImageButton equip = new ImageButton(skin, "equip_button");
            equip.setBounds(0, 0, 120, 120);
            equip.setName("item_equip_button");
            equip.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("123123");
                    item_equip_click(lamp);
                }
            });
            out.addActor(equip);


            ImageButton delete = new ImageButton(skin, "delete_button");
            delete.setBounds(340 - 120, 0, 120, 120);
            delete.setName("item_delete_button");
            delete.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    item_delete_click(lamp);
                }
            });
            out.addActor(delete);

            Image item_frontpane = new Image(atlas.findRegion("item_frontpane"));
            item_frontpane.setPosition(0, 0);
            item_frontpane.setName("item_frontpane");
            item_frontpane.setTouchable(Touchable.disabled);
            out.addActor(item_frontpane);

            Label light_label = new Label(
                    lamp.getLm_production() + "",
                    new LabelStyle(alice_28_555555, Color.BLACK)
            );
            light_label.setAlignment(Align.right);
            light_label.setName("item_light_label");
            light_label.setWrap(true);
            light_label.setBounds(0, 250, 80, 90);
            out.addActor(light_label);

            Label temp_label = new Label(
                    lamp.getT_add() + "",
                    new LabelStyle(alice_28_555555, Color.BLACK)
            );
            temp_label.setAlignment(Align.right);
            temp_label.setName("item_temp_label");
            temp_label.setWrap(true);
            temp_label.setBounds(250, 250, 80, 90);
            out.addActor(temp_label);

            Label name_label = new Label(
                    lamp.name(),
                    new LabelStyle(alice_36_373737_stroke_black, Color.BLACK)
            );
            name_label.setAlignment(Align.center);
            name_label.setName("item_light_label");
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
        for(Lamp current_lamp : Inventory.getInstance().get_lamp_inventory()){
            if(i>=3) {
                i=0;
                table.row();
            }
            table.add(generate_item(current_lamp));
            i++;

        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(true, false);
        pane.setBounds(0 ,0 ,1080 , 740);
        out.addActor(pane);

        return out;
    }


    @Override
    public void show() {

        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = new TextureAtlas(Gdx.files.internal("skin/lamp/data/pack.pack"));
        skin = new Skin(Gdx.files.internal("skin/lamp/data/pack.json"), atlas);
        Gdx.input.setInputProcessor(stage);

        alice_48_green = createFont(48, Color.GREEN);
        alice_36_white = createFont(36, new Color().set(203, 203, 203, 1));
        alice_25_black = createFont(25, Color.BLACK);
        alice_40_black = createFont(40, Color.BLACK);
        alice_28_555555 = createFont(28, new Color(55, 55, 55, 1));


        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 36;
        parameter.color.add(new Color(37,37,37,1));
        parameter.characters = FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor.add(Color.BLACK);
        parameter.borderWidth = 2;

       alice_36_373737_stroke_black  = generator.generateFont(parameter);
       generator.dispose();

       ImageButton back_button = new ImageButton(skin, "back_button");
       back_button.setPosition((1080/2)-350, 40);
       back_button.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               System.out.println("back");
           }
       });
       stage.addActor(back_button);

        Group infopane = generate_infopane();
        infopane.setBounds(40, 1070, 1080, 810);

        Group scrollpane = generate_scrollpane();
        scrollpane.setPosition(40, 310);



        stage.addActor(infopane);
        stage.addActor(scrollpane);


    }

    @Override
    public void render(float delta) {

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
    private BitmapFont createFont(int size, Color color) {

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color.add(color);
        parameter.characters = FONT_CHARACTERS;


        BitmapFont font  = generator.generateFont(parameter);

        generator.dispose();
        return font;
    }
}
