package com.acidcarpet.hydroponist.fan;

public enum EnergyQuality {

    TRASH(0.1,  0.2, 0.1, "Неработающий"),
    VERY_VERY_BAD(0.2,  0.4, 0.9, "Поврежденный"),
    VERY_BAD(0.4,  0.7, 2.5, "Изношенный"),
    BAD(0.7,  0.9, 7.5, "Старый"),
    NORMAL(0.9,  1.1, 78, "Средний"),
    GOOD(1.1,  1.3, 7.5, "Смазанный"),
    VERY_GOOD(1.3,  1.6, 2.5, "Доработанный"),
    VERY_VERY_GOOD(1.6,  1.8, 0.9, "Ускоренный"),
    PERFECT(1.8,  1.9, 0.1, "Эксклюзивный");

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
