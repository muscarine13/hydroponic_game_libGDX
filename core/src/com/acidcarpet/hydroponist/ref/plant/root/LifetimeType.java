package com.acidcarpet.hydroponist.ref.plant.root;

public enum LifetimeType {
    VERY_VERY_FAST(600),
    VERY_FAST(1200),
    FAST(1800),
    NORMAL(2000),
    SLOW(2400),
    VERY_SLOW(3000),
    VERY_VERY_SLOW(3600);

    public int seconds;

    LifetimeType(int seconds) {
        this.seconds = seconds;
    }
}
