package com.acidcarpet.hydroponist.ref.plant;

public enum LifetimeType {
    VERY_VERY_FAST(600, 1000, 2000, 10, 20),
    VERY_FAST(1200,2000, 3000, 20, 30),
    FAST(1800,3000, 4000, 30, 40),
    NORMAL(2000,4000, 5000, 40, 50),
    SLOW(2400,5000, 6000, 50, 60),
    VERY_SLOW(3000,6000, 7000, 60, 70),
    VERY_VERY_SLOW(3600,10000, 20000, 100, 200);

    public int seconds;
    int coin_minimum;
    int coin_maximum;

    int diamond_minimum;
    int diamond_maximum;

    LifetimeType(int seconds, int coin_minimum, int coin_maximum, int diamond_minimum, int diamond_maximum) {
        this.seconds = seconds;
        this.coin_minimum = coin_minimum;
        this.coin_maximum = coin_maximum;
        this.diamond_minimum = diamond_minimum;
        this.diamond_maximum = diamond_maximum;
    }
}
