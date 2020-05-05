package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.Elements;

public enum  PostBloomType {
    P(Elements.P),
    D(Elements.EMPTY);

    Elements elements;

    PostBloomType(Elements elements) {
        this.elements = elements;
    }
}
