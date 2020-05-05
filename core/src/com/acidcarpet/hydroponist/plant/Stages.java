package com.acidcarpet.hydroponist.plant;

public enum Stages {
    SEED(0, 1000, 0.05),
    PRE_VEGETATION(1000,1500, 0.075),
    VEGETATION(1000,2000, 0.3),
    POST_VEGETATION(1500,2000, 0.1),
    PRE_BLOOM(2000,2500, 0.075),
    BLOOM(2000,3000, 0.3),
    POST_BLOOM(2500,3000, 0.1),
    HARVEST(0, 3000, 0.0);


    Stages(int minimum_ppm, int maximum_ppm, double time_multiplier) {
        this.minimum_ppm = minimum_ppm;
        this.maximum_ppm = maximum_ppm;
        this.time_multiplier = time_multiplier;
    }

    int minimum_ppm;
    int maximum_ppm;
    double time_multiplier;
}
