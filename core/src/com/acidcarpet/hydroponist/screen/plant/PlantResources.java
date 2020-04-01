package com.acidcarpet.hydroponist.screen.plant;

import com.acidcarpet.hydroponist.GameConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PlantResources {

    private static TextureAtlas atlas;
    private static Skin skin;

    private static BitmapFont alice_144_green;
    private static BitmapFont alice_64_black;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/plant/data/plant_screen.pack"));
        skin = new Skin(Gdx.files.internal("skin/plant/data/plant_screen.json"), atlas);

        alice_144_green = createFont(144, Color.BLACK);
        alice_64_black = createFont(64, Color.GREEN);

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

    public static BitmapFont getAlice_144_green() {
        return alice_144_green;
    }
    public static BitmapFont getAlice_64_black() {
        return alice_64_black;
    }
}
