package com.acidcarpet.hydroponist.screen.pot;

import com.acidcarpet.hydroponist.GameConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PotResources {
    private static TextureAtlas atlas;
    private static Skin skin;

    private static BitmapFont alice_48_green;
    private static BitmapFont alice_48_black;
    private static BitmapFont alice_72_8F8F8F_stroke_black;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/pot/data/pot_screen.pack"));
        skin = new Skin(Gdx.files.internal("skin/pot/data/pot_screen.json"), atlas);

        alice_48_green = createFont(48, Color.GREEN);
        alice_48_black = createFont(48, Color.BLACK);
        alice_72_8F8F8F_stroke_black = createFont(72, new Color(143, 143, 143 ,1));

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
        parameter.color.add(color);
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
    public static BitmapFont getAlice_48_black() {
        return alice_48_black;
    }
    public static BitmapFont getAlice_72_8F8F8F_stroke_black() {
        return alice_72_8F8F8F_stroke_black;
    }
}
