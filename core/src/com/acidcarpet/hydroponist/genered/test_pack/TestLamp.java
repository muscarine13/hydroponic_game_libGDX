package com.acidcarpet.hydroponist.genered.test_pack;

import com.acidcarpet.hydroponist.equipment.Lamp;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestLamp extends Lamp {
    public TestLamp(){
        super(
                1500,
                2.5,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_lamp_on")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_lamp_off")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_light_on")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_light_off"))
        );
    }

    @Override
    public String name() {
        return "Тестовая лампа";
    }

    @Override
    public String description() {
        return "Описание тестовой лампы";
    }
}
