package com.acidcarpet.hydroponist.genered.test_pack;

import com.acidcarpet.hydroponist.equipment.Pump;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestPump extends Pump {

    public TestPump(){
        super(
                100,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_compressor_on")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_compressor_off"))
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
