package com.acidcarpet.hydroponist.ref.bottle;

public enum  PurityType {
    PERCENT_10("inepta", 0.1, 1.0),
    PERCENT_20("nuntius", 0.2, 5.0),
    PERCENT_30("contaminabit", 0.2,10.0),
    PERCENT_40("technica", 0.4,20.0),
    PERCENT_50("purum", 0.5, 28.0),
    PERCENT_60("pro analysi", 0.6,20.0),
    PERCENT_70("purissimum", 0.7, 10.0),
    PERCENT_80("purissimum speciale", 0.8, 5.0),
    PERCENT_95("absoluta", 0.95, 1.0);

    String latin;
   double percent;
   double chance;

    PurityType(String latin, double percent, double chance) {
        this.latin = latin;
        this.percent = percent;
        this.chance = chance;
    }
}
