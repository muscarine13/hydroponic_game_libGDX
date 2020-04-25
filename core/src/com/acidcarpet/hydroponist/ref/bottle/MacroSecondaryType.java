package com.acidcarpet.hydroponist.ref.bottle;

public enum MacroSecondaryType {

    S("sulpurea", 0.7, 0.15, 0.15),
    Mg("magnesium",0,0.7, 0.3),
    Ca("calcium", 0, 0.3, 0.7),
    D("clean", 0, 0, 0);

    public final double volume = 0.3;

    String latin;
    double S_percent;
    double Mg_percent;
    double Ca_percent;

    MacroSecondaryType(String latin, double s_percent, double mg_percent, double ca_percent) {
        this.latin = latin;
        S_percent = s_percent;
        Mg_percent = mg_percent;
        Ca_percent = ca_percent;
    }

    public double getVolume() {
        return volume;
    }
}
