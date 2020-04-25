package com.acidcarpet.hydroponist.ref.bottle;

public enum VolumeType {

    VOLUME_100("minima", 100, 89.0),
    VOLUME_500("pusili", 500,7.5),
    VOLUME_1000("normalem", 1000, 2.5),
    VOLUME_2500("magna", 2500, 0.9),
    VOLUME_5000("giant", 5000, 0.1);

    String latin;
    int volume;
    double chance;

    VolumeType(String latin, int volume, double chance) {
        this.latin = latin;
        this.volume = volume;
        this.chance = chance;
    }
}
