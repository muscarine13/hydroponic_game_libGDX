package com.acidcarpet.hydroponist.ref.lamp;

public enum EnergyQuality {

    PERFECT(0.1,  0.2, 0.1, "сломанная"),
    VERY_VERY_GOOD(0.2,  0.4, 0.9, "еле работающая"),
    VERY_GOOD(0.4,  0.7, 2.5, "слабая"),
    GOOD(0.7,  0.9, 7.5, "тусклая"),
    NORMAL(0.9,  1.1, 78, "средняя"),
    BAD(1.1,  1.3, 7.5, "яркая"),
    VERY_BAD(1.3,  1.6, 2.5, "производительная"),
    VERY_VERY_BAD(1.6,  1.8, 0.9, "сильная"),
    TRASH(1.8,  1.9, 0.1, "черезвычайно сильная");

    double minPercent;
    double maxPercent;

    double chance;

    String name;

    EnergyQuality(double minPercent, double maxPercent, double chance, String name) {
        this.minPercent = minPercent;
        this.maxPercent = maxPercent;
        this.chance = chance;
        this.name = name;
    }
}
