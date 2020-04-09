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

    private static TextureAtlas atlas;
    private static Skin skin;


    private static BitmapFont alice_72_797E55;
    private static BitmapFont alice_62_797E55;
    private static BitmapFont alice_36_797E55;

    private static BitmapFont alice_48_A5D3FE;
    private static BitmapFont alice_48_CFFAD0;


    public static void set_all() {

        atlas = new TextureAtlas(Gdx.files.internal("skin/fan/data/fan.pack"));
        skin = new Skin(Gdx.files.internal("skin/fan/data/fan.json"), atlas);

        alice_72_797E55 = createFont(72, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));
        alice_62_797E55 = createFont(62, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));
        alice_36_797E55 = createFont(36, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));

        alice_48_A5D3FE = createFont(48, new Color(165 / 255f, 211 / 255f, 254 / 255f, 1));
        alice_48_CFFAD0 = createFont(48, new Color(207 / 255f, 250 / 255f, 208 / 255f, 1));

    }

    public static void dispose_all() {

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

        BitmapFont font = generator.generateFont(parameter);

        generator.dispose();
        return font;
    }

    public static TextureAtlas getAtlas() {
        return atlas;
    }

    public static Skin getSkin() {
        return skin;
    }

    public static BitmapFont getAlice_72_797E55() {
        return alice_72_797E55;
    }
    public static BitmapFont getAlice_62_797E55() {
        return alice_62_797E55;
    }
    public static BitmapFont getAlice_36_797E55() {
        return alice_36_797E55;
    }
    public static BitmapFont getAlice_48_A5D3FE() {
        return alice_48_A5D3FE;
    }
    public static BitmapFont getAlice_48_CFFAD0() {
        return alice_48_CFFAD0;
    }
}


