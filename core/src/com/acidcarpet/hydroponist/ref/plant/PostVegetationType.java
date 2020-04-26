package com.acidcarpet.hydroponist.ref.plant;

import com.acidcarpet.hydroponist.Elements;

public enum PostVegetationType {
    K(Elements.K),
    P(Elements.P);

    Elements elements;

    PostVegetationType(Elements elements) {
        this.elements = elements;
    }
}
