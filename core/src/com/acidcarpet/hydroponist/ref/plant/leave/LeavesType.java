package com.acidcarpet.hydroponist.ref.plant.leave;

public enum LeavesType {
    VERY_HIGH(0.9, 0.1,0.6, 0.6, 0.6, 10, 90 ,15,45),
    HIGH(0.8, 0.2,0.7, 0.7, 0.7, 30, 70 ,15,40),
    NORMAL(0.7, 0.3,0.8, 0.8, 0.8, 50, 50 ,15,35),
    WIDE(0.6, 0.4,0.9, 0.9, 0.9, 70, 30 ,10,35),
    VERY_WIDE(0.5, 0.5,1.0, 1.0, 1.0, 90, 10 ,5,35);


    LeavesType(double percent_height, double percent_width, double energy_multiplier, double oxygen_multiplier, double water_multiplier, int light_energy, int dark_energy, int min_temperature, int max_temperature) {
        this.percent_height = percent_height;
        this.percent_width = percent_width;
        this.energy_multiplier = energy_multiplier;
        this.oxygen_multiplier = oxygen_multiplier;
        this.water_multiplier = water_multiplier;
        this.light_energy = light_energy;
        this.dark_energy = dark_energy;
        this.min_temperature = min_temperature;
        this.max_temperature = max_temperature;
    }

    double percent_height;
    double percent_width;

    double energy_multiplier;
    double oxygen_multiplier;
    double water_multiplier;

    int light_energy;
    int dark_energy;


    int min_temperature;
    int max_temperature;

    public double getPercent_height() {
        return percent_height;
    }

    public double getPercent_width() {
        return percent_width;
    }

    public double getEnergy_multiplier() {
        return energy_multiplier;
    }

    public double getOxygen_multiplier() {
        return oxygen_multiplier;
    }

    public double getWater_multiplier() {
        return water_multiplier;
    }

    public int getLight_energy() {
        return light_energy;
    }

    public int getDark_energy() {
        return dark_energy;
    }

    public int getMin_temperature() {
        return min_temperature;
    }

    public int getMax_temperature() {
        return max_temperature;
    }
}
