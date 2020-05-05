package com.acidcarpet.hydroponist.bottle;

public enum MicroSecondaryType {


    Mn("manganese", 0.6, 0.2, 0.2, 0.25, "Mn"),
    Mo("natrium",0.2,0.6, 0.2, 0.25, "Mo"),
    Zn("spodium", 0.2, 0.2, 0.6, 0.25, "Zn"),
    D("alcaline", 0, 0, 0, 0.25, "pH+");

    public static final double volume = 0.1;

    String latin;
    double Mn_percent;
    double Mo_percent;
    double Zn_percent;

    double chance;
    String latin_short;

    MicroSecondaryType(String latin, double mn_percent, double mo_percent, double zn_percent, double chance, String latin_short) {
        this.latin = latin;
        Mn_percent = mn_percent;
        Mo_percent = mo_percent;
        Zn_percent = zn_percent;
        this.chance = chance;
        this.latin_short = latin_short;
    }

    public static double getVolume() {
        return volume;
    }

    public String getLatin() {
        return latin;
    }

    public double getMn_percent() {
        return Mn_percent;
    }

    public double getMo_percent() {
        return Mo_percent;
    }

    public double getZn_percent() {
        return Zn_percent;
    }

    public double getChance() {
        return chance;
    }

    public String getLatin_short() {
        return latin_short;
    }
}
