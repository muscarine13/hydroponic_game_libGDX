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
                25,
               6,
                10,
               10,
                10,
                18,
                8,
               4,
                1,
                1,
                1,
                1,
                1,
                1,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_pot"))

                );
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
