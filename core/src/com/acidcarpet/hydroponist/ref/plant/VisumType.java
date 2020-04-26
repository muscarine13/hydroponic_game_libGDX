package com.acidcarpet.hydroponist.ref.plant;

import com.acidcarpet.hydroponist.Elements;

public enum VisumType {
    B_Mn(Elements.B, Elements.Mn, 100, 0, 70, 30, "pratum"),
    B_Mo(Elements.B, Elements.Mo,90, 10, 60, 40, "ferox"),
    B_Zn(Elements.B, Elements.Zn,80, 20, 50, 50, "domum"),
    B_D(Elements.B, Elements.EMPTY,70, 30, 40, 60, "mane"),
    Cu_Mn(Elements.Cu, Elements.Mn,60, 40, 30, 70, "sero"),
    Cu_Mo(Elements.Cu, Elements.Mo,50, 50, 20, 80, "vulgaris"),
    Cu_Zn(Elements.Cu, Elements.Zn,40, 60, 10, 90, "venenata"),
    Cu_D(Elements.Cu, Elements.EMPTY,30, 70, 0, 100, "edulis"),
    Fe_Mn(Elements.Fe, Elements.Mn,40, 60, 10, 90, "pulchram"),
    Fe_Mo(Elements.Fe, Elements.Mo,50, 50, 20, 80, "deformem"),
    Fe_Zn(Elements.Fe, Elements.Zn,60, 40, 30, 70, "clara"),
    Fe_D(Elements.Fe, Elements.EMPTY,70, 30, 40, 60, "fortis"),
    D_Mn(Elements.EMPTY, Elements.Mn,80, 20, 50, 50, "infirmi"),
    D_Mo(Elements.EMPTY, Elements.Mo,90, 10, 60, 40, "rudis"),
    D_Zn(Elements.EMPTY, Elements.Zn,100, 0, 70, 30, "mollis");

    Elements micro_primary;
    Elements micro_secondary;

    int pre_vegetation_chance;
    int post_vegetation_chance;
    int pre_bloom_chance;
    int post_bloom_chance;

    String latin;

    VisumType(Elements micro_primary, Elements micro_secondary, int pre_vegetation_chance, int post_vegetation_chance, int pre_bloom_chance, int post_bloom_chance, String latin) {
        this.micro_primary = micro_primary;
        this.micro_secondary = micro_secondary;
        this.pre_vegetation_chance = pre_vegetation_chance;
        this.post_vegetation_chance = post_vegetation_chance;
        this.pre_bloom_chance = pre_bloom_chance;
        this.post_bloom_chance = post_bloom_chance;
        this.latin = latin;
    }
}
