package com.acidcarpet.hydroponist.bottle;

public enum  PurityType {
    PERCENT_10("inepta", 0.1, 1.0, "in"),
    PERCENT_20("nuntius", 0.2, 5.0, "nun"),
    PERCENT_30("contaminabit", 0.2,10.0, "con"),
    PERCENT_40("technica", 0.4,20.0, "t"),
    PERCENT_50("purum", 0.5, 28.0, "p"),
    PERCENT_60("pro analysi", 0.6,20.0, "pa"),
    PERCENT_70("purissimum", 0.7, 10.0, "pm"),
    PERCENT_80("purissimum speciale", 0.8, 5.0, "ps"),
    PERCENT_95("absoluta", 0.95, 1.0, "a!");

    String latin;
   double percent;
   double chance;
   String latin_short;

    PurityType(String latin, double percent, double chance, String latin_short) {
        this.latin = latin;
        this.percent = percent;
        this.chance = chance;
        this.latin_short = latin_short;
    }


}
