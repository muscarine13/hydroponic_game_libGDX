package com.acidcarpet.hydroponist.genered.test_pack;

import com.acidcarpet.hydroponist.equipment.Fan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestFan extends Fan {
    public TestFan(){
        super(
                2500,
                2.5,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_fan_on")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_fan_off"))
                );
    }
    @Override
    public String name() {
        return "Тестовый вентилятор";
    }

    @Override
    public String description() {
        return "Описание тестового вентилятора";
    }
}
