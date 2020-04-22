package com.acidcarpet.hydroponist.ref.lamp;

public enum EnergyQuality {

    TRASH(0.1,  0.2, 0.1, "сломанная"),
    VERY_VERY_BAD(0.2,  0.4, 0.9, "еле работающая"),
    VERY_BAD(0.4,  0.7, 2.5, "слабая"),
    BAD(0.7,  0.9, 7.5, "тусклая"),
    NORMAL(0.9,  1.1, 78, "средняя"),
    GOOD(1.1,  1.3, 7.5, "яркая"),
    VERY_GOOD(1.3,  1.6, 2.5, "производительная"),
    VERY_VERY_GOOD(1.6,  1.8, 0.9, "сильная"),
    PERFECT(1.8,  1.9, 0.1, "черезвычайно сильная");

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
