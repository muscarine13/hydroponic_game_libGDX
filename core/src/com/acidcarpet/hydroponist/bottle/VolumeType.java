package com.acidcarpet.hydroponist.bottle;

public enum VolumeType {

    VOLUME_100("Minima", 100, 89.0, "100ml"),
    VOLUME_500("Pusili", 500,7.5, "500ml"),
    VOLUME_1000("Normalem", 1000, 2.5, "1000ml"),
    VOLUME_2500("Magna", 2500, 0.9, "2500ml"),
    VOLUME_5000("Giant", 5000, 0.1, "5000ml");

    String latin;
    int volume;
    double chance;
    String volume_text;

    VolumeType(String latin, int volume, double chance, String volume_text) {
        this.latin = latin;
        this.volume = volume;
        this.chance = chance;
        this.volume_text = volume_text;
    }
}
