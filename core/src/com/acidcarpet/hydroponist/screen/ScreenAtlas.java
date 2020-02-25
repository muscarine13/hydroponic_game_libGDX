package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.genered.test_pack.TestPack;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ScreenAtlas {
    private final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";




    private static ScreenAtlas instance;
    public static ScreenAtlas getInstance(){
        if(instance==null) instance = new ScreenAtlas();
        return instance;
    }

    BitmapFont alice_48_green;
    BitmapFont alice_36_white;
    BitmapFont alice_36_373737_stroke_black;
    BitmapFont alice_25_black;
    BitmapFont alice_40_black;
    BitmapFont alice_28_555555;

    private TextureAtlas BoxScreen_atlas;
    private Skin BoxScreen_skin;

    private TextureAtlas LampScreen_atlas;
    private Skin LampScreen_skin;

    private ScreenAtlas(){

        BoxScreen_atlas = new TextureAtlas(Gdx.files.internal("skin/box/skin/skin.atlas"));
        BoxScreen_skin = new Skin(Gdx.files.internal("skin/box/skin/skin.json"), BoxScreen_atlas);

        LampScreen_atlas = new TextureAtlas(Gdx.files.internal("skin/lamp/data/pack.pack"));
        LampScreen_skin = new Skin(Gdx.files.internal("skin/lamp/data/pack.json"), LampScreen_atlas);

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

    }

    public BitmapFont getAlice_48_green() {
        return alice_48_green;
    }
    public BitmapFont getAlice_36_white() {
        return alice_36_white;
    }
    public BitmapFont getAlice_36_373737_stroke_black() {
        return alice_36_373737_stroke_black;
    }
    public BitmapFont getAlice_25_black() {
        return alice_25_black;
    }
    public BitmapFont getAlice_40_black() {
        return alice_40_black;
    }
    public BitmapFont getAlice_28_555555() {
        return alice_28_555555;
    }

    public TextureAtlas getBoxScreen_atlas() {
        return BoxScreen_atlas;
    }
    public Skin getBoxScreen_skin() {
        return BoxScreen_skin;
    }

    public TextureAtlas getLampScreen_atlas() {
        return LampScreen_atlas;
    }
    public Skin getLampScreen_skin() {
        return LampScreen_skin;
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
