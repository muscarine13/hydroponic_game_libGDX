package com.acidcarpet.hydroponist.genered.test_pack;

import com.acidcarpet.hydroponist.equipment.Compressor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestCompressor extends Compressor {

    TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("item/compressor/test/skin/test_compressor.pack"));
    public TestCompressor(){
        super(
                100,
                new Image(new TextureAtlas(Gdx.files.internal("item/test_package/data/test_pack.pack")).findRegion("test_compressor_on")),
                new Image(new TextureAtlas(Gdx.files.internal("item/test_package/data/test_pack.pack")).findRegion("test_compressor_off"))
        );
    }
    @Override
    public String name() {
        return "Тестовый компрессор";
    }

    @Override
    public String description() {
        return "Обычный тестовый компрессор для обычных тестов";
    }


}
