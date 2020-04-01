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

    }
    private TextureAtlas atlas;

    public TextureAtlas get_atlas(){
        return atlas;
    }
    public  void set_atlas(){
        atlas = new TextureAtlas(
                Gdx.files.internal("item/test_package/data/pack.pack")
        );
    }
    public void dispose_atlas(){
        atlas.dispose();
    }

    public Lamp get_LED_65_lamp(){
        return new Lamp(
                "TestGro LED 65",
                "Лампа для новичков мощностью 65W. Повышает температуру всего на 3 с половиной градуса. Отличная лампа для начала.",
                65,
                3.5,
                new Image(atlas.findRegion("LED_65_lamp_on")),
                new Image(atlas.findRegion("LED_65_lamp_off")),
                new Image(atlas.findRegion("LED_65_light_on")),
                new Image(atlas.findRegion("LED_65_light_off")),
                new Image(atlas.findRegion("LED_65_lamp_icon"))
        );
    }
    public Lamp get_LED_200_lamp(){
        return new Lamp(
                "TestGro LED 200",
                "Лампа для новичков мощностью целых 200W. Повышает температуру на четсные 5.8 градусов. Отличная лампа для любителя.",
                200,
                5.8,
                new Image(atlas.findRegion("LED_200_lamp_on")),
                new Image(atlas.findRegion("LED_200_lamp_off")),
                new Image(atlas.findRegion("LED_200_light_on")),
                new Image(atlas.findRegion("LED_200_light_off")),
                new Image(atlas.findRegion("LED_200_lamp_icon"))
        );
    }
    public Lamp get_LED_1000_lamp(){
        return new Lamp(
                "TestGro LED 1000 PRO",
                "Лампа для новичков мощностью 1000W. Очень сильно повышает температуру на 22.5 градуса. Отличная лампа для профессионалов, знающих что они делают..",
                1000,
                22.5,
                new Image(atlas.findRegion("LED_1000_lamp_on")),
                new Image(atlas.findRegion("LED_1000_lamp_off")),
                new Image(atlas.findRegion("LED_1000_light_on")),
                new Image(atlas.findRegion("LED_1000_light_off")),
                new Image(atlas.findRegion("LED_1000_lamp_icon"))
        );
    }

    public Fan get_FAN_N_fan(){
        return new Fan(
                "TestGro FAN-N",
                "Маленький канальный вентилятор. Больше гудит чем дует, но для начала впролне подойдет для выращивания маленьких тестовых растений.",
                1.5,
                3.1,
                new Image(atlas.findRegion("FAN_N_fan_on")),
                new Image(atlas.findRegion("FAN_N_fan_off")),
                new Image(atlas.findRegion("FAN_N_fan_icon"))
        );
    }
    public Fan get_FAN_A_fan(){
        return new Fan(
                "TestGro FAN-A",
                "Средненький канальный вентилятор. Нормально дует и очень хорошо охлаждает. Вполне может помочь при выращивании средних и маленьких тестовых посевов.",
                3.2,
                5.5,
                new Image(atlas.findRegion("FAN_A_fan_on")),
                new Image(atlas.findRegion("FAN_A_fan_off")),
                new Image(atlas.findRegion("FAN_A_fan_icon"))
        );
    }
    public Fan get_FAN_P_fan(){
        return new Fan(
                "TestGro FAN-P",
                "Большой канальный вентилятор. Дует как турбина самолета и охлаждает так же. Походит для всего.",
                15.5,
                19.1,
                new Image(atlas.findRegion("FAN_P_fan_on")),
                new Image(atlas.findRegion("FAN_P_fan_off")),
                new Image(atlas.findRegion("FAN_P_fan_icon"))
        );
    }

    public Pot get_MINI_pot(){
        return new Pot(
                "TestGro Pot MINI",
                "Маленькое любительствое ведерко на 20л. По виду самодельное. Подойдет для маленьких тестовых растений.",
                20.0,
                new Image(atlas.findRegion("MINI_pot")),
                new Image(atlas.findRegion("MINI_pot_icon"))
        );

    }
    public Pot get_MIDDLE_pot(){
        return new Pot(
                "TestGro Pot MIDDLE",
                "Среднее профессиональное ведерко на 40л. Подойдет для маленьких и средних тестовых растений.",
                40.0,
                new Image(atlas.findRegion("MIDDLE_pot")),
                new Image(atlas.findRegion("MIDDLE_pot_icon"))
        );

    }
    public Pot get_MAXI_pot(){
        return new Pot(
                "TestGro Pot MAXI",
                "Большое профессиональное ведерко на 60л. Подойдет для любых тестовых растений.",
                60.0,
                new Image(atlas.findRegion("MAXI_pot")),
                new Image(atlas.findRegion("MAXI_pot_icon"))
        );

    }

    public Pump get_WIND_pump(){
        return new Pump(
                "TestGro WIND",
                "Маленький воздушный компрессор для маленьких тестовых растений в маленьких тестовых горшках.",
                10,
                new Image(atlas.findRegion("WIND_compressor_on")),
                new Image(atlas.findRegion("WIND_compressor_off")),
                new Image(atlas.findRegion("WIND_pump_icon"))
        );
    }
    public Pump get_CYCLONE_pump(){
        return new Pump(
                "TestGro CYCLONE",
                "Средний воздушный компрессор для средних тестовых растений включительно.",
                20,
                new Image(atlas.findRegion("CYCLONE_compressor_on")),
                new Image(atlas.findRegion("CYCLONE_compressor_off")),
                new Image(atlas.findRegion("CYCLONE_pump_icon"))
        );
    }
    public Pump get_TORNADO_pump(){
        return new Pump(
                "TestGro TORNADO",
                "Большой воздушный компрессор для любых тестовых растений.",
                50,
                new Image(atlas.findRegion("TORNADO_compressor_on")),
                new Image(atlas.findRegion("TORNADO_compressor_off")),
                new Image(atlas.findRegion("TORNADO_pump_icon"))
        );
    }

    public Bottle get_pH_up_bottle(){
        return new Bottle(
                "TestGro pH UP",
                "Жидкость, повышающая pH",
                0.5,
                14,
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
                new Image(atlas.findRegion("pH_up"))
        );
    }
    public Bottle get_pH_down_bottle(){
        return new Bottle(
                "TestGro pH DOWN",
                "Жидкость, пинижающая pH",
                0.5,
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
                new Image(atlas.findRegion("pH_down"))
        );
    }
    public Bottle get_water_bottle(){
        return new Bottle(
                "TestGro Clean Water",
                "Чистая дистиллированная вода без солей",
                100.0,
                5.5,
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
                new Image(atlas.findRegion("aqua"))
        );
    }

    public Bottle get_nutrient_N_bottle(){
        return new Bottle(
                "TestGro N Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
                10,
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
                new Image(atlas.findRegion("macro_N"))
        );
    }
    public Bottle get_nutrient_P_bottle(){
        return new Bottle(
                "TestGro P Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
                0,
                10,
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
                new Image(atlas.findRegion("macro_P"))
        );
    }
    public Bottle get_nutrient_K_bottle(){
        return new Bottle(
                "TestGro K Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
                0,
                0,
                10,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                new Image(atlas.findRegion("macro_K"))
        );
    }
    public Bottle get_nutrient_S_bottle(){
        return new Bottle(
                "TestGro S Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
                0,
                0,
                0,
                10,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                new Image(atlas.findRegion("macro_S"))
        );
    }
    public Bottle get_nutrient_Mg_bottle(){
        return new Bottle(
                "TestGro Mg Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
                0,
                0,
                0,
                0,
                10,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                new Image(atlas.findRegion("macro_Mg"))
        );
    }
    public Bottle get_nutrient_Ca_bottle(){
        return new Bottle(
                "TestGro Ca Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
                0,
                0,
                0,
                0,
                0,
                10,
                0,
                0,
                0,
                0,
                0,
                0,
                new Image(atlas.findRegion("macro_Ca"))
        );
    }
    public Bottle get_nutrient_B_bottle(){
        return new Bottle(
                "TestGro B Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
                0,
                0,
                0,
                0,
                0,
                0,
                5,
                0,
                0,
                0,
                0,
                0,
                new Image(atlas.findRegion("micro_B"))
        );
    }
    public Bottle get_nutrient_Cu_bottle(){
        return new Bottle(
                "TestGro Cu Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                5,
                0,
                0,
                0,
                0,
                new Image(atlas.findRegion("micro_Cu"))
        );
    }
    public Bottle get_nutrient_Fe_bottle(){
        return new Bottle(
                "TestGro Fe Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
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
                0,
                0,
                new Image(atlas.findRegion("micro_Fe"))
        );
    }
    public Bottle get_nutrient_Mn_bottle(){
        return new Bottle(
                "TestGro Mn Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
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
                0,
                new Image(atlas.findRegion("micro_Mn"))
        );
    }
    public Bottle get_nutrient_Mo_bottle(){
        return new Bottle(
                "TestGro Mo Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
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
                new Image(atlas.findRegion("micro_Mo"))
        );
    }
    public Bottle get_nutrient_Zn_bottle(){
        return new Bottle(
                "TestGro Zn Nutrient",
                "Удобрение, сдержащее только 1 элемент. Такие удобрения используются для тестирования.",
                0.5,
                5.5,
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
                new Image(atlas.findRegion("micro_Zn"))
        );
    }

    public Plant get_Malco_plant(){
        return new Plant(
                "Testplanta Malco",
                1000
        ) {
            @Override
            public List<PlantStage> set_stages() {
                List<PlantStage> out = new ArrayList<>();

                out.add(new PlantStage( //76ppm
                        PlantStages.SEED,
                        new Image(TestPack.getInstance().get_atlas().findRegion("Malco_seed_alive")),
                        new Image(TestPack.getInstance().get_atlas().findRegion("Malco_seed_dead")),
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

                        20,
                        0,
                        2,
                        0,
                        48,
                        42,
                        38,
                        20,
                        20,
                        20,
                        20,
                        16,
                        10,
                        2,
                        2,
                        2
                ));

                out.add(new PlantStage( //76ppm
                        PlantStages.VEGETATION,
                        new Image(TestPack.getInstance().get_atlas().findRegion("Malco_vegetation_alive")),
                        new Image(TestPack.getInstance().get_atlas().findRegion("Malco_vegetation_dead")),
                        10,
                        5,
                        1,
                        0,
                        120,
                        105,
                        95,
                        50,
                        50,
                        50,
                        50,
                        40,
                        25,
                        5,
                        5,
                        5,

                        40,
                        10,
                        5,
                        0,
                        240,
                        210,
                        190,
                        100,
                        100,
                        100,
                        100,
                        80,
                        10,
                        10,
                        10,
                        10
                ));

                out.add(new PlantStage( //76ppm
                        PlantStages.BLOOM,
                        new Image(TestPack.getInstance().get_atlas().findRegion("Malco_bloom_alive")),
                        new Image(TestPack.getInstance().get_atlas().findRegion("Malco_bloom_dead")),
                        10,
                        1,
                        0,
                        1,
                        240,
                        210,
                        190,
                        100,
                        100,
                        100,
                        100,
                        80,
                        50,
                        10,
                        10,
                        10,

                        20,
                        2,
                        0,
                        5,
                        480,
                        420,
                        380,
                        200,
                        200,
                        200,
                        200,
                        160,
                        100,
                        20,
                        20,
                        20
                ));

                out.add(new PlantStage( //76ppm
                        PlantStages.HARVEST,
                        new Image(TestPack.getInstance().get_atlas().findRegion("Malco_harvest_alive")),
                        new Image(TestPack.getInstance().get_atlas().findRegion("Malco_harvest_dead")),
                        10,
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
                        0,
                        0,

                        20,
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
                        0,
                        0
                ));



                return out;
            }

            @Override
            public Leave get_new_leave() {
                return new Leave(
                        100,
                        5,
                        0.5,
                        3,
                        2,
                        12,
                        13,
                        0.00000012,
                        0.1,
                        10,
                        45,
                        1
                );
            }

            @Override
            public Root get_new_root() {
                return new Root(
                        200,
                        2,
                        0.01,
                        1,
                        13,
                        20,
                        30,
                        0,
                        10000,
                        0.00012
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
}
