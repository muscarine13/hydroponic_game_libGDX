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
                new Image(TestPack.getInstance().get_atlas().findRegion("test_light_off")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_lamp_icon"))
        );
    }

    @Override
    public String name() {
        return "GroFlo LED 500W FITO PRO Series";
    }

    @Override
    public String description() {
        return "Крутейшая тестовая лампа из всех тестовых лам. Греет не сильно, а светит как пульсар. Самое то для начинающего садовода.";
    }
}
