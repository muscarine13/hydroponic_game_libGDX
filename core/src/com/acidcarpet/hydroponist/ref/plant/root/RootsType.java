package com.acidcarpet.hydroponist.ref.plant.root;

public enum RootsType {
    PIVOTAL(0.9, 10, 2.5, 4.5),
    P_1(0.8, 20, 3, 5),
    P_2(0.7, 30, 3.5, 5.5),
    P_3(0.6, 40, 4, 6),
    P_4(0.5, 50, 4.5, 6.5),
    F_4(0.4, 60, 5, 7),
    F_3(0.3, 70, 5.5, 7.5),
    F_2(0.2, 80, 6, 8),
    F_1(0.1, 90, 6.5, 8.5),
    FIBROUS(0.01, 100, 7, 9);

    double length;
    int maximum_side_roots;

    double ph_min;
    double ph_max;

    RootsType(double length, int maximum_side_roots, double ph_min, double ph_max) {
        this.length = length;
        this.maximum_side_roots = maximum_side_roots;
        this.ph_min = ph_min;
        this.ph_max = ph_max;
    }
}