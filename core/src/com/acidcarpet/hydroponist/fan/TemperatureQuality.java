package com.acidcarpet.hydroponist.fan;

public enum TemperatureQuality {
    PERFECT(0.1,  0.2, 0.1, "замерзший"),
    VERY_VERY_GOOD(0.2,  0.4, 0.9, "замораживающий"),
    VERY_GOOD(0.4,  0.7, 2.5, "морозяший"),
    GOOD(0.7,  0.9, 7.5, "остужающий"),
    NORMAL(0.9,  1.1, 78, "обычный"),
    BAD(1.1,  1.3, 7.5, "теплый"),
    VERY_BAD(1.3,  1.6, 2.5, "нагревающий"),
    VERY_VERY_BAD(1.6,  1.8, 0.9, "греющий"),
    TRASH(1.8,  1.9, 0.1, "раскаленный");

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
