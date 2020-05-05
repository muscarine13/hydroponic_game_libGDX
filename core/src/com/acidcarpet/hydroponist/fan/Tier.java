package com.acidcarpet.hydroponist.fan;

public enum Tier {
    TIER_50(10, 50, 1, 5, 33.4, "I"),
    TIER_100(50, 100, 5, 10, 25.0,"II"),
    TIER_150(100, 150, 10, 15, 15.0,"III"),
    TIER_200(150, 200, 15, 20, 10.0,"IV"),
    TIER_250(200, 250, 20, 25, 7.5,"V"),
    TIER_300(250, 300, 25, 30, 5,"VI"),
    TIER_350(300, 350, 30, 35, 2.5,"VII"),
    TIER_400(350, 400, 35, 40, 1.0,"VIII"),
    TIER_450(400, 450, 40, 45, 0.5,"IX"),
    TIER_500(450, 500, 45, 50, 0.1,"X");

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
