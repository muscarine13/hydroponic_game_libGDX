package com.acidcarpet.hydroponist.ref.bottle;

public enum  MicroPrimaryType {


    B("boron", 0.6, 0.2, 0.2),
    Cu("aeris",0.2,0.6, 0.2),
    Fe("ferrum", 0.2, 0.2, 0.6),
    D("accidum", 0, 0, 0);

    public final double volume = 0.1;

    String latin;
    double B_percent;
    double Cu_percent;
    double Fe_percent;

    MicroPrimaryType(String latin, double b_percent, double cu_percent, double fe_percent) {
        this.latin = latin;
        B_percent = b_percent;
        Cu_percent = cu_percent;
        Fe_percent = fe_percent;
    }

    public double getVolume() {
        return volume;
    }
}
