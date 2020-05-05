package com.acidcarpet.hydroponist.bottle;

public enum MacroSecondaryType {

    S("crustulum sulphuris", 0.7, 0.15, 0.15, 0.25),
    Mg("solution magnesii",0,0.7, 0.3, 0.25),
    Ca("calcium pulveris", 0, 0.3, 0.7, 0.25),
    D("aqua", 0, 0, 0, 0.25);

    public final double volume = 0.3;

    String latin;
    double S_percent;
    double Mg_percent;
    double Ca_percent;

    double chance;

    MacroSecondaryType(String latin, double s_percent, double mg_percent, double ca_percent, double chance) {
        this.latin = latin;
        S_percent = s_percent;
        Mg_percent = mg_percent;
        Ca_percent = ca_percent;
        this.chance = chance;
    }

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
