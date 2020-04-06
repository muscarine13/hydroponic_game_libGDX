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
    private static BitmapFont alice_30_EDD929_stroke_5_9A8C0D; // Gold Price
    private static BitmapFont alice_24_9A8C0D; // Gold Description

    private static BitmapFont alice_48_1ADED2_stroke_5_089086; // Diamond Title
    private static BitmapFont alice_30_1ADED2_stroke_5_089086; // Diamond Price
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
        alice_30_EDD929_stroke_5_9A8C0D = generate_alice_30_EDD929_stroke_5_9A8C0D();
        alice_24_9A8C0D = generate_alice_24_9A8C0D();

        alice_48_1ADED2_stroke_5_089086 = generate_alice_48_1ADED2_stroke_5_089086();
        alice_30_1ADED2_stroke_5_089086 = generate_alice_30_1ADED2_stroke_5_089086();
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
    public static BitmapFont getAlice_30_EDD929_stroke_5_9A8C0D() {
        return alice_30_EDD929_stroke_5_9A8C0D;
    }
    public static BitmapFont getAlice_30_1ADED2_stroke_5_089086() {
        return alice_30_1ADED2_stroke_5_089086;
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
        parameter.color = new Color(246/255f,235/255f,134/255f,1.0f) ;
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor = new Color(154/255f, 140/255f, 13/255f,1.0f);
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
        parameter.color = new Color(123/255f,239/255f,230/255f,1.0f);
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor = (new Color(8/255f, 144/255f, 134/255f,1.0f));
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
        parameter.color = (new Color(246/255f,235/255f,134/255f,1f));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor = (new Color(154/255f, 140/255f, 13/255f,1f));
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
        parameter.color = (new Color(123/255f,239/255f,230/255f,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor = (new Color(8/255f, 144/255f, 134/255f,1));
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
        parameter.color = (new Color(175/255f,175/255f,175/255f,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        parameter.borderColor = (new Color(68/255f, 68/255f, 68/255f,1));
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
        parameter.color = (new Color(237/255f,217/255f,41/255f,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderColor = (new Color(154/255f, 140/255f,13/255f, 1));
        parameter.borderWidth = 5;
        parameter.borderStraight = true;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_30_EDD929_stroke_5_9A8C0D(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        parameter.color = (new Color(237/255f,217/255f,41/255f,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderColor = (new Color(154/255f, 140/255f,13/255f, 1));
        parameter.borderWidth = 1;
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
        parameter.size = 24;
        parameter.color = (new Color(154/255f, 140/255f,13/255f, 1));
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
        parameter.color = (new Color(26/255f,222/255f,210/255f,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderColor = (new Color(8/255f, 144/255f,134/255f, 1));
        parameter.borderWidth = 5;
        parameter.borderStraight = true;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }
    private static BitmapFont generate_alice_30_1ADED2_stroke_5_089086(){
        BitmapFont out;

        FileHandle fontFile = Gdx.files.internal("Alice-Regular.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        parameter.color = (new Color(26/255f,222/255f,210/255f,1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderColor = (new Color(8/255f, 144/255f,134/255f, 1));
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
        parameter.size = 24;
        parameter.color = (new Color(8/255f, 144/255f,134/255f, 1));
        parameter.characters = GameConstants.FONT_CHARACTERS;
        parameter.borderStraight = true;
        out  = generator.generateFont(parameter);
        generator.dispose();

        return out;
    }



}
