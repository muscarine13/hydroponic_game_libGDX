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

    private static BitmapFont alice_72_8F51F5;
    private static BitmapFont alice_62_797E55;

    private static BitmapFont alice_72_30155B;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/pot/data/pot.pack"));
        skin = new Skin(Gdx.files.internal("skin/pot/data/pot.json"), atlas);

        alice_72_8F51F5 = createFont(72, new Color(143/255f,81/255f,245/255f, 1));
        alice_62_797E55 = createFont(62, new Color(121/255f,126/255f,85/255f, 1));

        alice_72_30155B = createFont(72, new Color(48/255f,21/255f,91/255f, 1));

    }
    public static void dispose_all(){

        atlas.dispose();
        skin.dispose();

        alice_72_8F51F5.dispose();
        alice_62_797E55.dispose();
        alice_72_30155B.dispose();

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

    public static BitmapFont getAlice_72_8F51F5() {
        return alice_72_8F51F5;
    }
    public static BitmapFont getAlice_62_797E55() {
        return alice_62_797E55;
    }
    public static BitmapFont getAlice_72_30155B() {
        return alice_72_30155B;
    }
}
