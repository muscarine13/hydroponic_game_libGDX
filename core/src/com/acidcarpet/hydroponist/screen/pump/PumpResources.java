package com.acidcarpet.hydroponist.screen.pump;

import com.acidcarpet.hydroponist.GameConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PumpResources {

    private static BitmapFont alice_72_797E55;
    private static BitmapFont alice_62_797E55;
    private static BitmapFont alice_36_797E55;

    private static BitmapFont alice_48_ACE5F8;

    private static TextureAtlas atlas;
    private static Skin skin;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/pump/data/pump.pack"));
        skin = new Skin(Gdx.files.internal("skin/pump/data/pump.json"), atlas);

        alice_72_797E55 = createFont(72, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));
        alice_62_797E55 = createFont(62, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));
        alice_36_797E55 = createFont(36, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));

        alice_48_ACE5F8 = createFont(48, new Color(172 / 255f, 229 / 255f, 248 / 255f, 1));

    }
    public static void dispose_all(){

        atlas.dispose();
        skin.dispose();

        alice_72_797E55 = createFont(72, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));
        alice_62_797E55 = createFont(62, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));
        alice_36_797E55 = createFont(36, new Color(121 / 255f, 126 / 255f, 85 / 255f, 1));

        alice_48_ACE5F8 = createFont(48, new Color(172 / 255f, 229 / 255f, 248 / 255f, 1));

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

    public static BitmapFont getAlice_72_797E55() {
        return alice_72_797E55;
    }
    public static BitmapFont getAlice_62_797E55() {
        return alice_62_797E55;
    }
    public static BitmapFont getAlice_36_797E55() {
        return alice_36_797E55;
    }
    public static BitmapFont getAlice_48_ACE5F8() {
        return alice_48_ACE5F8;
    }
}
