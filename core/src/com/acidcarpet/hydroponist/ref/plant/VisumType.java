package com.acidcarpet.hydroponist.ref.plant;

public enum VisumType {
    B_Mn(100, 0, 70, 30, "pratum"),
    B_Mo(90, 10, 60, 40, "ferox"),
    B_Zn(80, 20, 50, 50, "domum"),
    B_D(70, 30, 40, 60, "mane"),
    Cu_Mn(60, 40, 30, 70, "sero"),
    Cu_Mo(50, 50, 20, 80, "vulgaris"),
    Cu_Zn(40, 60, 10, 90, "venenata"),
    Cu_D(30, 70, 0, 100, "edulis"),
    Fe_Mn(40, 60, 10, 90, "pulchram"),
    Fe_Mo(50, 50, 20, 80, "deformem"),
    Fe_Zn(60, 40, 30, 70, "clara"),
    Fe_D(70, 30, 40, 60, "fortis"),
    D_Mn(80, 20, 50, 50, "infirmi"),
    D_Mo(90, 10, 60, 40, "rudis"),
    D_Zn(100, 0, 70, 30, "mollis");

    int pre_vegetation_chance;
    int post_vegetation_chance;
    int pre_bloom_chance;
    int post_bloom_chance;

    String latin;

    VisumType(int pre_vegetation_chance, int post_vegetation_chance, int pre_bloom_chance, int post_bloom_chance, String latin) {
        this.pre_vegetation_chance = pre_vegetation_chance;
        this.post_vegetation_chance = post_vegetation_chance;
        this.pre_bloom_chance = pre_bloom_chance;
        this.post_bloom_chance = post_bloom_chance;
        this.latin = latin;
    }
}
