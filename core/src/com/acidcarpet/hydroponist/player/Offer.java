package com.acidcarpet.hydroponist.player;

import javafx.scene.image.Image;

import java.util.List;

public abstract class Offer {

    int price;
    List<Storable> items;

    Offer(int price){
        this.price = price;
        items = set_items();
    }

    abstract List<Storable> set_items();
    abstract Image offer_image();

}
