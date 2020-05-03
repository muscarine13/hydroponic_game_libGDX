package com.acidcarpet.hydroponist.ref.plant.flower;

public enum  FlowersType {
    BACA ("baca", "ягода", 50, 50, 10, 0.01d),
    FLOS ("flos", "цветок", 70, 30, 15, 0.005d),
    NUT ("nut", "орех", 40, 60, 5, 0.02d),
    FRUCTUS ("fructus", "фрукт", 90, 10, 20, 0.001d),
    SPINAM ("spinam", "колючка", 10, 90, 1, 0.05d);

    FlowersType(String latin, String name, int light_energy_consumption, int dark_energy_consumption, int gold_earn, double diamond_chance) {
        this.latin = latin;
        this.name = name;
        this.light_energy_consumption = light_energy_consumption;
        this.dark_energy_consumption = dark_energy_consumption;
        this.gold_earn = gold_earn;
        this.diamond_chance = diamond_chance;
    }

    String latin;
    String name;

    int light_energy_consumption;
    int dark_energy_consumption;

    int gold_earn;
    double diamond_chance;
}
