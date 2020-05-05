package com.acidcarpet.hydroponist.lamp;

public enum TemperatureQuality {
    PERFECT(0.1,  0.2, 0.1, "Ледяная"),
    VERY_VERY_GOOD(0.2,  0.4, 0.9, "Обледенелая"),
    VERY_GOOD(0.4,  0.7, 2.5, "Холодная"),
    GOOD(0.7,  0.9, 7.5, "Прохладная"),
    NORMAL(0.9,  1.1, 78, "Обычная"),
    BAD(1.1,  1.3, 7.5, "Слегка теплая"),
    VERY_BAD(1.3,  1.6, 2.5, "Теплая"),
    VERY_VERY_BAD(1.6,  1.8, 0.9, "Горячая"),
    TRASH(1.8,  1.9, 0.1, "Черезвычайно горячая");

    double minPercent;
    double maxPercent;

    double chance;
    String name;

    TemperatureQuality(double minPercent, double maxPercent, double chance, String name) {
        this.minPercent = minPercent;
        this.maxPercent = maxPercent;
        this.chance = chance;
        this.name = name;
    }
}
