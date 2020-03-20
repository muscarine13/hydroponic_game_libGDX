package com.acidcarpet.hydroponist.genered.test_pack;

import com.acidcarpet.hydroponist.equipment.*;
import com.acidcarpet.hydroponist.plant.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;
import java.util.List;

public class TestPack {
    private static TestPack instance;
    public static TestPack getInstance(){
        if(instance==null) instance = new TestPack();
        return instance;
    }

    private TestPack(){
        atlas = new TextureAtlas(
                Gdx.files.internal("item/test_package/data/pack.pack")
        );
    }
    private TextureAtlas atlas;

    private TextureAtlas get_atlas(){
        return atlas;
    }

    public Lamp get_test_lamp(){
        return new Lamp(
                "TestGro LED 600W",
                "Тестовая лампа для новичков, нормально светит",
                1500,
                2.5,
                new Image(atlas.findRegion("test_lamp_on")),
                new Image(atlas.findRegion("test_lamp_off")),
                new Image(atlas.findRegion("test_light_on")),
                new Image(atlas.findRegion("test_light_off")),
                new Image(atlas.findRegion("test_lamp_icon"))
        );
    }
    public Fan get_test_fan(){
        return new Fan(
                "TestGro SmallWind 150",
                "Тестовый вентилятор для новичков, вроде дует",
                60.5,
                2.5,
                new Image(atlas.findRegion("test_fan_on")),
                new Image(atlas.findRegion("test_fan_off")),
                new Image(atlas.findRegion("test_fan_icon"))
        );
    }
    public Plant get_test_plant(){
        return new Plant(
                "Testus Plantus",
                250
        ) {
            @Override
            public List<PlantStage> set_stages() {
                List<PlantStage> out = new ArrayList<>();
//        out.add(new PlantStage( //76ppm
//                PlantStages.SEED,
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_seed_alive")),
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_seed_dead")),
//                1,
//                0,
//                1,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//
//                5,
//                0,
//                3,
//                0,
//                15,
//                15,
//                15,
//                13,
//                8,
//                4,
//                1,
//                1,
//                1,
//                1,
//                1,
//                1
//                ));
//
//        out.add(new PlantStage( //76ppm
//                PlantStages.SOAKING,
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_soaking_alive")),
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_soaking_dead")),
//                1,
//                0,
//                1,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//
//                5,
//                0,
//                3,
//                0,
//                15,
//                15,
//                15,
//                13,
//                8,
//                4,
//                1,
//                1,
//                1,
//                1,
//                1,
//                1
//        ));
//
//        out.add(new PlantStage( //76ppm
//                PlantStages.PRE_VEGETATION,
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_pre_vegetation_alive")),
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_pre_vegetation_dead")),
//                1,
//                0,
//                1,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//
//                5,
//                0,
//                3,
//                0,
//                15,
//                15,
//                15,
//                13,
//                8,
//                4,
//                1,
//                1,
//                1,
//                1,
//                1,
//                1
//        ));
//
//        out.add(new PlantStage( //76ppm
//                PlantStages.VEGETATION,
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_vegetation_alive")),
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_vegetation_dead")),
//                1,
//                0,
//                1,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//
//                5,
//                0,
//                3,
//                0,
//                15,
//                15,
//                15,
//                13,
//                8,
//                4,
//                1,
//                1,
//                1,
//                1,
//                1,
//                1
//        ));
//
//        out.add(new PlantStage( //76ppm
//                PlantStages.POST_VEGETATION,
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_post_vegetation_alive")),
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_post_vegetation_dead")),
//                1,
//                0,
//                1,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//
//                5,
//                0,
//                3,
//                0,
//                15,
//                15,
//                15,
//                13,
//                8,
//                4,
//                1,
//                1,
//                1,
//                1,
//                1,
//                1
//        ));
//
//        out.add(new PlantStage( //76ppm
//                PlantStages.PRE_BLOOM,
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_pre_bloom_alive")),
//                new Image(TestPack.getInstance().get_atlas().findRegion("test_plant_pre_bloom_dead")),
//                1,
//                0,
//                1,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//
//                5,
//                0,
//                3,
//                0,
//                15,
//                15,
//                15,
//                13,
//                8,
//                4,
//                1,
//                1,
//                1,
//                1,
//                1,
//                1
//        ));
                out.add(new PlantStage( //76ppm
                        PlantStages.BLOOM,
                        new Image(atlas.findRegion("test_plant_bloom_alive")),
                        new Image(atlas.findRegion("test_plant_bloom_dead")),
                        1,
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

                        5,
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
                        new Image(atlas.findRegion("test_plant_post_bloom_alive")),
                        new Image(atlas.findRegion("test_plant_post_bloom_dead")),
                        1,
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

                        5,
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
                        new Image(atlas.findRegion("test_plant_harvest_alive")),
                        new Image(atlas.findRegion("test_plant_harvest_dead")),
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
                        13,
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
        };
    }
    public Pot get_test_pot(){
        return new Pot(
                "TestGro Aqua50 PRO",
                "Профессиональный горшок для выращивания на гидропонике. Тестовый конечно.",
                30,
                20,
                5.5,
                (int)0.01*10000,
                (int)0.01*10000,
                (int)0.01*10000,
                (int)0.01*10000,
                (int)0.01*10000,
                (int)0.01*10000,
                (int)0.01*10000,
                (int)0.001*10000,
                (int)0.001*10000,
                (int)0.001*10000,
                (int)0.001*10000,
                (int)0.001*10000,
                new Image(atlas.findRegion("test_pot")),
                new Image(atlas.findRegion("test_pot_icon"))
        );

    }
    public Pump get_test_pump(){
        return new Pump(
                "TestGro Oxy100 Start",
                "Описание компрессора новичка из тестового набора. Ничего особенного",
                100,
                new Image(atlas.findRegion("test_compressor_on")),
                new Image(atlas.findRegion("test_compressor_off")),
                new Image(atlas.findRegion("test_pump_icon"))
        );
    }
    public Bottle get_test_bottle(){
        return new Bottle(
                "TestGro Universal",
                "Описание бутыля с удобрением. Тестовый образец",
                0.5,
                5,
                12,
                11,
                10,
                9,
                8,
                7,
                6,
                5,
                4,
                3,
                2,
                1,
                new Image(atlas.findRegion("test_bottle_icon"))
        );
    }
}
