package com.acidcarpet.hydroponist.genered.test_pack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TestPack {
    private static TestPack instance;
    public static TestPack getInstance(){
        if(instance==null) instance = new TestPack();
        return instance;
    }

    private TestPack(){
        atlas = new TextureAtlas(
                Gdx.files.internal("item/test_package/data/test_pack.pack")
        );
    }
    private TextureAtlas atlas;

    public TextureAtlas get_atlas(){
        return atlas;
    }


}
