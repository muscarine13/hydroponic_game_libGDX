package com.acidcarpet.hydroponist;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ContentPack {
    private static TextureAtlas lamp_atlas;
    private static TextureAtlas plant_atlas;
    private static TextureAtlas fan_atlas;
    private static TextureAtlas pot_atlas;


    public static boolean set_all(){

        try{
            lamp_atlas = new TextureAtlas(Gdx.files.internal("content/data/lamp.pack"));
            plant_atlas = new TextureAtlas(Gdx.files.internal("content/data/plant.pack"));
            fan_atlas = new TextureAtlas(Gdx.files.internal("content/data/fan.pack"));
            pot_atlas = new TextureAtlas(Gdx.files.internal("content/data/pot.pack"));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }






    }
    public static void dispose_all(){

        lamp_atlas.dispose();
        plant_atlas.dispose();
        fan_atlas.dispose();
        pot_atlas.dispose();

    }

    public static TextureAtlas getLamp_atlas() {
        return lamp_atlas;
    }

    public static TextureAtlas getPlant_atlas() {
        return plant_atlas;
    }

    public static TextureAtlas getFan_atlas() {
        return fan_atlas;
    }

    public static TextureAtlas getPot_atlas() {
        return pot_atlas;
    }
}
