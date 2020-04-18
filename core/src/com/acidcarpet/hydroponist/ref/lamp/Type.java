package com.acidcarpet.hydroponist.ref.lamp;

public enum Type {
    LED_RED(0.1, 1.9, 1.1, "красная LED лампа"),
    DNaT(0.9, 1.8, 1.2, "лампа ДНаТ"),
    INCANDESCENT(2.5, 1.7, 1.3, "лампа накаливания"),
    HALOGEN(7.5, 1.6, 1.4, "галогеновая лампа"),
    LED_FULL(78, 1.5, 1.5, "LED лампа полного спектра"),
    METAL_HALOGEN(7.5, 1.4, 1.6, "металл-галогеновая лампа лампа"),
    FLUORESCENT(2.5, 1.3, 1.7, "люминисцентная лампа"),
    DAYLIGHT(0.9, 1.2, 1.8, "лампа дневного света"),
    LED_BLUE(0.1, 1.1, 1.9, "синяя LED лампа");

    double chance;

    double grow_multiplier;
    double bloom_multiplier;

    String name;

    Type(double chance, double grow_multiplier, double bloom_multiplier, String name) {
        this.chance = chance;
        this.grow_multiplier = grow_multiplier;
        this.bloom_multiplier = bloom_multiplier;
        this.name = name;
    }
}
