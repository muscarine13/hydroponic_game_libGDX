package com.acidcarpet.hydroponist.screen.box;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class BoxResources {

    private static TextureAtlas atlas;
    private static Skin skin;

    public static void set_all(){

        atlas = new TextureAtlas(Gdx.files.internal("skin/box/skin/skin.atlas"));
        skin = new Skin(Gdx.files.internal("skin/box/skin/skin.json"), atlas);

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
