package com.acidcarpet.hydroponist.plant.flower;

public enum  FlowersType {
    BACA ("baca", "ягода", 50,  10, 0.01d),
    FLOS ("flos", "цветок", 70,  15, 0.005d),
    NUT ("nut", "орех", 40, 5, 0.02d),
    FRUCTUS ("fructus", "фрукт", 90,  20, 0.001d),
    SPINAM ("spinam", "колючка", 10, 1, 0.05d);

    FlowersType(String latin, String name, int light_energy_consumption, int gold_earn, double diamond_chance) {
        this.latin = latin;
        this.name = name;
        this.light_energy_consumption = light_energy_consumption;

        this.gold_earn = gold_earn;
        this.diamond_chance = diamond_chance;
    }

    String latin;
    String name;

    int light_energy_consumption;


    int gold_earn;
    double diamond_chance;

    public String getLatin() {
        return latin;
    }

    public String getName() {
        return name;
    }

    public int getLight_energy_consumption() {
        return light_energy_consumption;
    }

    public int getGold_earn() {
        return gold_earn;
    }

    public double getDiamond_chance() {
        return diamond_chance;
    }
}
