package com.acidcarpet.hydroponist.screen.donat;

import com.acidcarpet.hydroponist.GameConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DonatResources {

    private static BitmapFont alice_150_F6EB86_stroke_5_9A8C0D; // Gold Big
    private static BitmapFont alice_150_7BEFE6_stroke_5_089086; // Diamond Big

    private static BitmapFont alice_64_F6EB86_stroke_5_9A8C0D; // Gold Small
    private static BitmapFont alice_64_7BEFE6_stroke_5_089086; // Diamond Small
    private static BitmapFont alice_64_AFAFAF_stroke_5_444444; // Grey Small

    private static BitmapFont alice_48_EDD929_stroke_5_9A8C0D; // Gold Title
    private static BitmapFont alice_24_9A8C0D; // Gold Description

    private static BitmapFont alice_48_1ADED2_stroke_5_089086; // Diamond Title
    private static BitmapFont alice_24_089086; // Diamond Description

    private static TextureAtlas atlas;
    private static Skin skin;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/donat/data/donat.pack"));
        skin = new Skin(Gdx.files.internal("skin/donat/data/donat.json"), atlas);

        alice_150_F6EB86_stroke_5_9A8C0D  = generate_alice_150_F6EB86_stroke_5_9A8C0D();
        alice_150_7BEFE6_stroke_5_089086 = generate_alice_150_7BEFE6_stroke_5_089086();

        alice_64_F6EB86_stroke_5_9A8C0D = generate_alice_64_F6EB86_stroke_5_9A8C0D();
        alice_64_7BEFE6_stroke_5_089086 = generate_alice_64_7BEFE6_stroke_5_089086();
        alice_64_AFAFAF_stroke_5_444444 = generate_alice_64_AFAFAF_stroke_5_444444();

        alice_48_EDD929_stroke_5_9A8C0D = generate_alice_48_EDD929_stroke_5_9A8C0D();
        alice_24_9A8C0D = generate_alice_24_9A8C0D();

        alice_48_1ADED2_stroke_5_089086 = generate_alice_48_1ADED2_stroke_5_089086();
        alice_24_089086 = generate_alice_24_089086();

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

    public static BitmapFont getAlice_150_F6EB86_stroke_5_9A8C0D() {
        return alice_150_F6EB86_stroke_5_9A8C0D;
    }
    public static BitmapFont getAlice_150_7BEFE6_stroke_5_089086() {
        return alice_150_7BEFE6_stroke_5_089086;
    }
    public static BitmapFont getAlice_64_F6EB86_stroke_5_9A8C0D() {
        return alice_64_F6EB86_stroke_5_9A8C0D;
    }
    public static BitmapFont getAlice_64_7BEFE6_stroke_5_089086() {
        return alice_64_7BEFE6_stroke_5_089086;
    }
    public static BitmapFont getAlice_64_AFAFAF_stroke_5_444444() {
        return alice_64_AFAFAF_stroke_5_444444;
    }
    public static BitmapFont getAlice_48_EDD929_stroke_5_9A8C0D() {
        return alice_48_EDD929_stroke_5_9A8C0D;
    }
    public static BitmapFont getAlice_24_9A8C0D() {
        return alice_24_9A8C0D;
    }
    public static BitmapFont getAlice_48_1ADED2_stroke_5_089086() {
        return alice_48_1ADED2_stroke_5_089086;
    }
    public static BitmapFont getAlice_24_089086() {
        return alice_24_089086;
    }

    public static TextureAtlas getAtlas() {
        return atlas;
    }
    public static Skin getSkin() {
        return skin;
    }

    private static BitmapFont generate_alice_150_F6EB86_stroke_5_9A8C0D(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 150;
        parameter.color.add(new Color(246,235,134,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor.add(new Color(154, 140, 13,1));
        parameter.borderWidth = 5;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_150_7BEFE6_stroke_5_089086(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 150;
        parameter.color.add(new Color(123,239,230,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor.add(new Color(8, 144, 134,1));
        parameter.borderWidth = 5;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_64_F6EB86_stroke_5_9A8C0D(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 64;
        parameter.color.add(new Color(246,235,134,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor.add(new Color(154, 140, 13,1));
        parameter.borderWidth = 5;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_64_7BEFE6_stroke_5_089086(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 64;
        parameter.color.add(new Color(123,239,230,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor.add(new Color(8, 144, 134,1));
        parameter.borderWidth = 5;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_64_AFAFAF_stroke_5_444444(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 64;
        parameter.color.add(new Color(175,175,175,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor.add(new Color(68, 68, 68,1));
        parameter.borderWidth = 5;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }

    private static BitmapFont generate_alice_48_EDD929_stroke_5_9A8C0D(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 48;
        parameter.color.add(new Color(237,217,41,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderColor.add(new Color(154, 140,13, 1));
        parameter.borderWidth = 5;
        parameter.borderStraight = true;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_24_9A8C0D(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 48;
        parameter.color.add(new Color(154, 140,13, 1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_48_1ADED2_stroke_5_089086(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 48;
        parameter.color.add(new Color(26,222,210,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderColor.add(new Color(8, 144,134, 1));
        parameter.borderWidth = 5;
        parameter.borderStraight = true;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_24_089086(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 48;
        parameter.color.add(new Color(8, 144,134, 1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }



}
