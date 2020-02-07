package com.acidcarpet.hydroponist.player;

import java.util.List;

public class Store {
    private static Store instance;
    public static Store getInstance(){
        if(instance==null) instance = new Store();
        return instance;
    }

    private List<Offer> offers;
}
