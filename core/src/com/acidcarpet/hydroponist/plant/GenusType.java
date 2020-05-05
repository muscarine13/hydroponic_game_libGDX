package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.Elements;

public enum  GenusType {

    S_S(Elements.S, Elements.S, "Serpentbloom", "Змеецвет", 0.9 , "S_S"),
    S_Mg(Elements.S, Elements.Mg, "Flosmarea", "Морской цветок", 0.9, "S_Mg"),
    S_Ca(Elements.S, Elements.Ca, "Hirsutaefolia", "Волосатый кактус", 0.8, "S_Ca"),
    Mg_Mg(Elements.Mg, Elements.Mg, "Аdamantemfructus", "Алмазник", 0.7, "Mg_Mg"),
    Mg_S(Elements.Mg, Elements.S, "Aurumherba", "Золототрав", 0.6, "Mg_S"),
    Mg_Ca(Elements.Mg, Elements.Ca,"Plantaccidens", "Случайник", 0.5, "Mg_Ca"),
    Ca_Ca(Elements.Ca, Elements.Ca, "Elephantizania", "Лопух слоновий", 0.4, "Ca_Ca"),
    Ca_S(Elements.Ca, Elements.S, "Radixenimus", "Большекорень", 0.3, "Ca_S"),
    Ca_Mg(Elements.Ca, Elements.Mg, "Ingetilignum", "Древень гигансткий", 0.7, "Ca_Mg");

    Elements vegetation_element;
    Elements bloom_element;

    String latin;
    String name;

    double percent_day;
    String code;


    GenusType(Elements vegetation_element, Elements bloom_element, String latin, String name, double percent_day, String code) {
        this.vegetation_element = vegetation_element;
        this.bloom_element = bloom_element;
        this.latin = latin;
        this.name = name;
        this.percent_day = percent_day;
        this.code = code;
    }
}
