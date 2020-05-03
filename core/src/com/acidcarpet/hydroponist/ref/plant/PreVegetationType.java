package com.acidcarpet.hydroponist.ref.plant;

import com.acidcarpet.hydroponist.Elements;

public enum PreVegetationType {
    N(Elements.N),
    K(Elements.K);
    Elements elements;

    PreVegetationType(Elements elements) {
        this.elements = elements;
    }
}
