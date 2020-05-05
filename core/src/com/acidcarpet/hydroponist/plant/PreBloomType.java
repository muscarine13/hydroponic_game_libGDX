package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.Elements;

public enum PreBloomType {
    P(Elements.P),
    K(Elements.K);

    Elements elements;

    PreBloomType(Elements elements) {
        this.elements = elements;
    }
}
