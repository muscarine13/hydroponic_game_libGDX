package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;


import java.awt.*;

public class LampScreen implements Screen {

    private final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    BitmapFont alice_48_green;
    BitmapFont alice_36_white;
    BitmapFont alice_25_black;

    Group infopane_empty;


    private Group generate_infopane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("infopane_background"));
        background.setPosition(0 , 0);
        background.setName("infopane_background");
        out.addActor(background);

        if(Box.getInstance().getLamp()!=null){// лампа есть и надо получить ее новую карточку



        }else{// лампы нет никакой и нужна заглушка

            LabelStyle name_style = new LabelStyle(alice_48_green, Color.GREEN);
            Label title_label = new   Label("ПУСТО", name_style);

            title_label.setWrap(true);
            title_label.setAlignment(Align.center);
            title_label.setBounds(0, 0, 0, 0);
            title_label.setName("infopane_name_label");
        }






        return out;

    }


    @Override
    public void show() {

        alice_48_green = createFont(48, Color.GREEN);

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
