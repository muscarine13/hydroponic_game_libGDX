package com.acidcarpet.hydroponist.lamp;

public enum Tier {
    TIER_100(10, 100, 1, 5, 33.4, "I"),
    TIER_200(100, 200, 5, 10, 25.0,"II"),
    TIER_300(200, 300, 10, 15, 15.0,"III"),
    TIER_400(300, 400, 15, 20, 10.0,"IV"),
    TIER_500(400, 500, 20, 25, 7.5,"V"),
    TIER_600(500, 600, 25, 30, 5,"VI"),
    TIER_700(600, 700, 30, 35, 2.5,"VII"),
    TIER_800(700, 800, 35, 40, 1.0,"VIII"),
    TIER_900(800, 900, 40, 45, 0.5,"IX"),
    TIER_1000(900, 1000, 45, 50, 0.1,"X");

    int minPower;
    int maxPower;

    int minTemperature;
    int maxTemperature;

    double chance;
    String name;

    Tier(int minPower, int maxPower, int minTemperature, int maxTemperature, double chance, String name) {
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.name = name;
        this.chance = chance;
    }
}
