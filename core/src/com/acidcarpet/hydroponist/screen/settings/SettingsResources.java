package com.acidcarpet.hydroponist.screen.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SettingsResources {

    private static TextureAtlas atlas;
    private static Skin skin;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/settings/data/settings.pack"));
        skin = new Skin(Gdx.files.internal("skin/settings/data/settings.json"), atlas);

    }
    public static void dispose_all(){

        atlas.dispose();
        skin.dispose();

    }

    public static TextureAtlas getAtlas() {
        return atlas;
    }
    public static Skin getSkin() {
        return skin;
    }

}
