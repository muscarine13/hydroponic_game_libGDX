package com.acidcarpet.hydroponist.ref.bottle;

public enum MicroSecondaryType {


    Mn("manganese", 0.6, 0.2, 0.2),
    Mo("natrium",0.2,0.6, 0.2),
    Zn("spodium", 0.2, 0.2, 0.6),
    D("alcaline", 0, 0, 0);

    public final double volume = 0.1;

    String latin;
    double Mn_percent;
    double Mo_percent;
    double Zn_percent;

    MicroSecondaryType(String latin, double mn_percent, double mo_percent, double zn_percent) {
        this.latin = latin;
        Mn_percent = mn_percent;
        Mo_percent = mo_percent;
        Zn_percent = zn_percent;
    }

    public double getVolume() {
        return volume;
    }
}
