package com.acidcarpet.hydroponist.ref.lamp;

public enum EnergyQuality {
    FROM_10_TO_20(1.1,  1.2, 0.1, "сломанная"),
    FROM_20_TO_30(1.2,  1.3, 0.9, "еле работающая"),
    FROM_30_TO_40(1.3,  1.4, 2.5, "слабая"),
    FROM_40_TO_50(1.4,  1.5, 7.5, "тусклая"),
    FROM_50_TO_60(1.5,  1.6, 78, "средняя"),
    FROM_60_TO_70(1.6,  1.7, 7.5, "яркая"),
    FROM_70_TO_80(1.7,  1.8, 2.5, "производительная"),
    FROM_80_TO_90(1.8,  1.9, 0.9, "сильная"),
    FROM_90_TO_100(1.9,  2.0, 0.1, "черезвычайно сильная");

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
