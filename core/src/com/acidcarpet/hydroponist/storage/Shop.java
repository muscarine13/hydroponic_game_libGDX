package com.acidcarpet.hydroponist.storage;

import java.util.*;

public class Shop {

    private static Shop instance;
    public static Shop getInstance(){
        if(instance==null) instance = new Shop();
        return instance;
    }

    private List<Offer> offers;
    public List<Offer> getOffers() {
        return offers;
    }

    private Shop(){

        offers = TestPack.getInstance().get_offers();

    }


}
