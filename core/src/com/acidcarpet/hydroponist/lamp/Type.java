package com.acidcarpet.hydroponist.lamp;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public enum Type {
    LED_RED(2.5, 1.9, 1.1, "красная LED лампа", "led_red"),
    DNaT(7.5, 1.8, 1.2, "лампа ДНаТ", "dnat"),
    INCANDESCENT(10, 1.7, 1.3, "лампа накаливания",  "incandescent"),
    HALOGEN(20, 1.6, 1.4, "галогеновая лампа", "halide"),
    LED_FULL(20, 1.5, 1.5, "LED лампа полного спектра", "led_full"),
    METAL_HALOGEN(20, 1.4, 1.6, "металл-галогеновая лампа", "metal_halide"),
    FLUORESCENT(10, 1.3, 1.7, "люминисцентная лампа", "fluorescent"),
    DAYLIGHT(7.5, 1.2, 1.8, "лампа дневного света", "daylight"),
    LED_BLUE(2.5, 1.1, 1.9, "синяя LED лампа", "led_blue");

    double chance;

    double grow_multiplier;
    double bloom_multiplier;

    String name;
    String id;

    Type(double chance,  double bloom_multiplier,double grow_multiplier, String name, String id) {
        this.chance = chance;
        this.grow_multiplier = grow_multiplier;
        this.bloom_multiplier = bloom_multiplier;
        this.name = name;
        this.id = id;
    }
}
