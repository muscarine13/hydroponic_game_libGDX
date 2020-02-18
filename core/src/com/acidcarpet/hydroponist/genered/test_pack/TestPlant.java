package com.acidcarpet.hydroponist.genered.test_pack;

import com.acidcarpet.hydroponist.plant.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * вода
 * 70-1050 Прорастание семян
 * 1050-1400 Укоренение срезанных клонов
 * 1400-1750 Для роста растения
 * 1750-2100 Плодоношение
 * 2100-3500 Редко для больших растений
 * труп
 *
 *
 * 15 15 15   13      8       4      1 1 1 1 1 1
 * 19.7%       17.1%    10.52%   5.26%   1.31%
 *
 *
 * 70--
 * 13.3       11.9    10.64   3.682  0.917
 * -
 * --1050--
 * 206        179.55  110.46  55.23  13.755
 *
 * --1400--
 * 275.8      239.4   147.28  73.64  18.34
 *
 *--1750--
 * 344.75    299.25   184.1 92.05 22.925
 *
 * --2100--
 *
 *
 *
 */
public class TestPlant extends Plant {
    public TestPlant() {
        super(250);
    }

    @Override
    public List<PlantStage> set_stages() {
        List<PlantStage> out = new ArrayList<>();

        out.add(new PlantStage( //76ppm
                PlantStages.SEED,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_seed_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_seed_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
                ));

        out.add(new PlantStage( //76ppm
                PlantStages.SOAKING,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_soaking_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_soaking_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
        ));

        out.add(new PlantStage( //76ppm
                PlantStages.PRE_VEGETATION,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_pre_vegetation_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_pre_vegetation_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
        ));

        out.add(new PlantStage( //76ppm
                PlantStages.VEGETATION,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_vegetation_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_vegetation_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
        ));

        out.add(new PlantStage( //76ppm
                PlantStages.POST_VEGETATION,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_post_vegetation_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_post_vegetation_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
        ));

        out.add(new PlantStage( //76ppm
                PlantStages.PRE_BLOOM,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_pre_bloom_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_pre_bloom_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
        ));

        out.add(new PlantStage( //76ppm
                PlantStages.BLOOM,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_bloom_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_bloom_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
        ));

        out.add(new PlantStage( //76ppm
                PlantStages.POST_BLOOM,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_post_bloom_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_post_bloom_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
        ));

        out.add(new PlantStage( //76ppm
                PlantStages.HARVEST,
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_harvest_alive")),
                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_harvest_dead")),
                10,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,

                15,
                0,
                3,
                0,
                15,
                15,
                15,
                13,
                8,
                4,
                1,
                1,
                1,
                1,
                1,
                1
        ));

        return out;
    }

    @Override
    public Leave get_new_leave() {
        return new Leave(
                100,
                4,
                5,
                1,
                2,
                12,
                1,
                5,
                16,
                28,
                175
        );
    }

    @Override
    public Root get_new_root() {
        return new Root(
               200,
                2,
                15,
                5.5,
                6.5,
                20,
                30,
                0,
                3500,
                1.2
        );
    }

    @Override
    public Product get_new_product() {
        return new Product(
                "Тестовый фрукт",
                "Описание тестового фрукта",
                100,
                1.2,
                90,
                30,
                10,
                12
        );
    }
}
