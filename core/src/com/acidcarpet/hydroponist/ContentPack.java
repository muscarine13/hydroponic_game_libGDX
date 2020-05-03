package com.acidcarpet.hydroponist;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ContentPack {
    private static TextureAtlas atlas;


    public static boolean set_all(){

        try{
            atlas = new TextureAtlas(Gdx.files.internal("content/data/content.pack"));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
    public static void dispose_all(){

        atlas.dispose();

    }

    public static TextureAtlas getAtlas() {
        return atlas;
    }

}
