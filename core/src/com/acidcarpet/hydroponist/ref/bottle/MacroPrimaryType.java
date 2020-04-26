package com.acidcarpet.hydroponist.ref.bottle;

public enum MacroPrimaryType {

    N("in cibum", 0.5, 0.25, 0.25, 0.25),
    P("in flore",0.1,0.6, 0.3, 0.25),
    K("enim herba", 0.1, 0.3, 0.6, 0.25),
    D("et stercora", 0, 0, 0, 0.25);

    public final double volume = 0.5;

    String latin;
    double N_percent;
    double P_percent;
    double K_percent;

    double chance;

    MacroPrimaryType(String latin, double n_percent, double p_percent, double k_percent, double chance) {
        this.latin = latin;
        N_percent = n_percent;
        P_percent = p_percent;
        K_percent = k_percent;
        this.chance = chance;
    }

    MacroPrimaryType(String latin, double n_percent, double p_percent, double k_percent) {
        this.latin = latin;
        N_percent = n_percent;
        P_percent = p_percent;
        K_percent = k_percent;
    }

    public double getVolume() {
        return volume;
    }
}
