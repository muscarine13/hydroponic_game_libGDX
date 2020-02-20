package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;


import java.awt.*;

import static java.lang.String.*;

public class LampScreen implements Screen {

    Game game;
    private final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    BitmapFont alice_48_green;
    BitmapFont alice_36_white;
    BitmapFont alice_25_black;

    Group infopane_empty;

    public LampScreen(Game game){
        this.game = game;
    }


    private void takeoff_click(){

    }
    private void off_click(){

    }
    private void on_click(){

    }

    private Group generate_infopane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("infopane_background"));
        background.setPosition(0 , 0);
        background.setName("infopane_background");
        out.addActor(background);

        if(Box.getInstance().getLamp()!=null){// лампа есть и надо получить ее новую карточку

            Label title_label = new   Label(
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
                    Box.getInstance().getLamp().getLm_production()+"",
                    new LabelStyle(alice_25_black,  Color.BLACK)
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
                    format("%.2f", Box.getInstance().getLamp().getT_add()),
                    new LabelStyle(alice_25_black,  Color.BLACK)
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
    private Group generate_scrollpane(){
        Group out = new Group();
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
        alice_25_black = createFont(36, Color.BLACK);

        Group infopane = generate_infopane();
        infopane.setBounds(40, 1070, 1080, 810);

        stage.addActor(infopane);

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
