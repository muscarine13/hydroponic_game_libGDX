package com.acidcarpet.hydroponist.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ScreenAssets {
    private final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";


    private static ScreenAssets instance;
    public static ScreenAssets getInstance(){
        if(instance==null) instance = new ScreenAssets();
        return instance;
    }

    BitmapFont alice_48_green;
    BitmapFont alice_48_black;
    BitmapFont alice_36_white;
    BitmapFont alice_36_373737_stroke_black;
    BitmapFont alice_25_black;
    BitmapFont alice_40_black;
    BitmapFont alice_28_555555;
    BitmapFont alice_72_8F8F8F_stroke_black;

    BitmapFont alice_144_green;
    BitmapFont alice_64_black;

    private TextureAtlas BoxScreen_atlas;
    private Skin BoxScreen_skin;

    private TextureAtlas LampScreen_atlas;
    private Skin LampScreen_skin;

    private TextureAtlas FanScreen_atlas;
    private Skin FanScreen_skin;

    private TextureAtlas PumpScreen_atlas;
    private Skin PumpScreen_skin;

    private TextureAtlas PotScreen_atlas;
    private Skin PotScreen_skin;

    private TextureAtlas PlantScreen_atlas;
    private Skin PlantScreen_skin;

    private ScreenAssets(){

        BoxScreen_atlas = new TextureAtlas(Gdx.files.internal("skin/box/skin/skin.atlas"));
        BoxScreen_skin = new Skin(Gdx.files.internal("skin/box/skin/skin.json"), BoxScreen_atlas);

        LampScreen_atlas = new TextureAtlas(Gdx.files.internal("skin/lamp/data/pack.pack"));
        LampScreen_skin = new Skin(Gdx.files.internal("skin/lamp/data/pack.json"), LampScreen_atlas);

        FanScreen_atlas = new TextureAtlas(Gdx.files.internal("skin/fan/data/pack.pack"));
        FanScreen_skin = new Skin(Gdx.files.internal("skin/fan/data/pack.json"), FanScreen_atlas);

        PumpScreen_atlas = new TextureAtlas(Gdx.files.internal("skin/pump/data/pack.pack"));
        PumpScreen_skin = new Skin(Gdx.files.internal("skin/pump/data/pack.json"), PumpScreen_atlas);

        PotScreen_atlas = new TextureAtlas(Gdx.files.internal("skin/pot/data/pot_screen.pack"));
        PotScreen_skin = new Skin(Gdx.files.internal("skin/pot/data/pot_screen.json"), PotScreen_atlas);

        PlantScreen_atlas = new TextureAtlas(Gdx.files.internal("skin/plant/data/plant_screen.pack"));
        PlantScreen_skin = new Skin(Gdx.files.internal("skin/plant/data/plant_screen.json"), PlantScreen_atlas);


        alice_48_green = createFont(48, Color.GREEN);
        alice_48_black = createFont(48, Color.BLACK);
        alice_36_white = createFont(36, new Color().set(203, 203, 203, 1));
        alice_25_black = createFont(25, Color.BLACK);
        alice_40_black = createFont(40, Color.BLACK);
        alice_28_555555 = createFont(28, new Color(55, 55, 55, 1));
        alice_72_8F8F8F_stroke_black = createFont(72, new Color(143, 143, 143 ,1));

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

        alice_144_green = createFont(144, Color.BLACK);
        alice_64_black = createFont(64, Color.GREEN);

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
    public BitmapFont getAlice_48_black() {
        return alice_48_black;
    }
    public BitmapFont getAlice_72_8F8F8F_stroke_black() {
        return alice_72_8F8F8F_stroke_black;
    }
    public BitmapFont getAlice_144_green() {
        return alice_144_green;
    }
    public BitmapFont getAlice_64_black() {
        return alice_64_black;
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

    public TextureAtlas getFanScreen_atlas() {
        return FanScreen_atlas;
    }
    public Skin getFanScreen_skin() {
        return FanScreen_skin;
    }

    public TextureAtlas getPumpScreen_atlas() {
        return PumpScreen_atlas;
    }
    public Skin getPumpScreen_skin() {
        return PumpScreen_skin;
    }

    public TextureAtlas getPotScreen_atlas() {
        return PotScreen_atlas;
    }
    public Skin getPotScreen_skin() {
        return PotScreen_skin;
    }

    public TextureAtlas getPlantScreen_atlas() {
        return PlantScreen_atlas;
    }
    public Skin getPlantScreen_skin() {
        return PlantScreen_skin;
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
