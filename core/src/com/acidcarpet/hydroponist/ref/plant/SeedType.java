package com.acidcarpet.hydroponist.ref.plant;

import com.acidcarpet.hydroponist.Elements;

public enum  SeedType {
    N(Elements.N),
    D(Elements.EMPTY);

    Elements elements;

    SeedType(Elements elements) {
        this.elements = elements;
    }
}
