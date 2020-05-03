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

    private static BitmapFont alice_96_69AA35_stroke_5_2F5313;
    private static BitmapFont alice_96_000000_stroke_2_000000;
    private static BitmapFont alice_48_000000_stroke_1_000000;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/plant/data/plant.pack"));
        skin = new Skin(Gdx.files.internal("skin/plant/data/plant.json"), atlas);

        alice_96_69AA35_stroke_5_2F5313 = generate_alice_96_69AA35_stroke_5_2F5313();
        alice_96_000000_stroke_2_000000 = generate_alice_96_000000_stroke_2_000000();
        alice_48_000000_stroke_1_000000 = generate_alice_48_000000_stroke_1_000000();

    }
    public static void dispose_all(){

        atlas.dispose();
        skin.dispose();

        alice_96_69AA35_stroke_5_2F5313.dispose();
        alice_96_000000_stroke_2_000000.dispose();
        alice_48_000000_stroke_1_000000.dispose();

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

    public static BitmapFont generate_alice_96_69AA35_stroke_5_2F5313() {
        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 96;
        parameter.color = new Color(105/255f, 170/255f, 53/255f ,1);
        parameter.characters = GameConstants.FONT_CHARACTERS;

        parameter.borderWidth = 5;
        parameter.borderColor = new Color(47/255f, 83/255f, 19/255f ,1);

        BitmapFont font  = generator.generateFont(parameter);

        generator.dispose();
        return font;
    }
    public static BitmapFont generate_alice_96_000000_stroke_2_000000() {
        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 96;
        parameter.color = new Color(0, 0, 0 ,1);
        parameter.characters = GameConstants.FONT_CHARACTERS;

        parameter.borderWidth = 2;
        parameter.borderColor = new Color(0, 0, 0 ,1);

        BitmapFont font  = generator.generateFont(parameter);

        generator.dispose();
        return font;
    }
    public static BitmapFont generate_alice_48_000000_stroke_1_000000() {
        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 96;
        parameter.color = new Color(0, 0, 0 ,1);
        parameter.characters = GameConstants.FONT_CHARACTERS;

        parameter.borderWidth = 1;
        parameter.borderColor = new Color(0, 0, 0 ,1);

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

    public static BitmapFont getAlice_96_69AA35_stroke_5_2F5313() {
        return alice_96_69AA35_stroke_5_2F5313;
    }
    public static BitmapFont getAlice_96_000000_stroke_2_000000() {
        return alice_96_000000_stroke_2_000000;
    }
    public static BitmapFont getAlice_48_000000_stroke_1_000000() {
        return alice_48_000000_stroke_1_000000;
    }
}
