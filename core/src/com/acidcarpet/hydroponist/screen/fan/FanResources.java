package com.acidcarpet.hydroponist.screen.fan;

import com.acidcarpet.hydroponist.GameConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class FanResources {

    private static BitmapFont alice_48_green;
    private static BitmapFont alice_36_white;
    private static BitmapFont alice_25_black;
    private static BitmapFont alice_40_black;
    private static BitmapFont alice_28_555555;
    private static BitmapFont alice_36_373737_stroke_black;


    private static TextureAtlas atlas;
    private static Skin skin;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/fan/data/pack.pack"));
        skin = new Skin(Gdx.files.internal("skin/fan/data/pack.json"), atlas);

        alice_48_green = createFont(48, Color.GREEN);

        alice_36_white = createFont(36, new Color().set(203, 203, 203, 1));
        alice_25_black = createFont(25, Color.BLACK);
        alice_40_black = createFont(40, Color.BLACK);
        alice_28_555555 = createFont(28, new Color(55, 55, 55, 1));

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 36;
        parameter.color = new Color(37/255f,37/255f,37/255f,1);
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 2;

        alice_36_373737_stroke_black  = generator.generateFont(parameter);
        generator.dispose();


    }
    public static void dispose_all(){

        atlas.dispose();
        skin.dispose();

    }
    private static BitmapFont createFont(int size, Color color) {

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = color;
        parameter.characters = GameConstants.FONT_CHARACTERS;

        BitmapFont font  = generator.generateFont(parameter);

        generator.dispose();
        return font;
    }

    public static TextureAtlas getAtlas() {
        return atlas;
    }
    public static Skin getSkin() {
        return skin;
    }

    public static BitmapFont getAlice_48_green() {
        return alice_48_green;
    }
    public static BitmapFont getAlice_36_white() {
        return alice_36_white;
    }
    public static BitmapFont getAlice_25_black() {
        return alice_25_black;
    }
    public static BitmapFont getAlice_40_black() {
        return alice_40_black;
    }
    public static BitmapFont getAlice_28_555555() {
        return alice_28_555555;
    }
    public static BitmapFont getAlice_36_373737_stroke_black() {
        return alice_36_373737_stroke_black;
    }
}
