package com.acidcarpet.hydroponist.genered.test_pack;

import com.acidcarpet.hydroponist.equipment.Pot;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestPot extends Pot {
    public TestPot() {
        super(
                30,
                20,
                25.5,
               5.5,
                0.01d,
                0.01d,
                0.01d,
                0.01d,
                0.01d,
                0.01d,
                0.001d,
                0.001d,
                0.001d,
                0.001d,
                0.001d,
                0.001d,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_pot")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_pot_icon"))
                );
    }

    @Override
    public String name() {
        return "AquaPro Pot 50";
    }

    @Override
    public String description() {
        return "Описание оного";
    }
}
