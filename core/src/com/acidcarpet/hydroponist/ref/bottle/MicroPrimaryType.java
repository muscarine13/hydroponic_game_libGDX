package com.acidcarpet.hydroponist.ref.bottle;

public enum  MicroPrimaryType {


    B("boron", 0.6, 0.2, 0.2, 0.25, "B"),
    Cu("aeris",0.2,0.6, 0.2, 0.25, "Cu"),
    Fe("ferrum", 0.2, 0.2, 0.6, 0.25, "Fe"),
    D("accidum", 0, 0, 0, 0.25, "ph-");

    public final double volume = 0.1;

    String latin;
    double B_percent;
    double Cu_percent;
    double Fe_percent;

    double chance;

    String latin_short;

    MicroPrimaryType(String latin, double b_percent, double cu_percent, double fe_percent, double chance, String latin_short) {
        this.latin = latin;
        B_percent = b_percent;
        Cu_percent = cu_percent;
        Fe_percent = fe_percent;
        this.chance = chance;
        this.latin_short = latin_short;
    }

    public double getVolume() {
        return volume;
    }
}
