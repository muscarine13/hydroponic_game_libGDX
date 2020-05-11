package com.acidcarpet.hydroponist;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ContentPack {

    private static TextureAtlas all_atlas;

    public static boolean set_all(){

        try{

            all_atlas = new TextureAtlas(Gdx.files.internal("content/data_all/content_all.pack"));
            System.out.println("TRUE");

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }



    }
    public static void dispose_all(){

       all_atlas.dispose();

    }

    public static TextureAtlas getAll_atlas() {
        return all_atlas;
    }
}
