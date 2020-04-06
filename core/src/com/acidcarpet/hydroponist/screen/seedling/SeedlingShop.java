package com.acidcarpet.hydroponist.screen.seedling;

import com.acidcarpet.hydroponist.storage.TestPack;

import java.util.List;

public class SeedlingShop {

    private static SeedlingShop instance;
    public static SeedlingShop getInstance(){
        if(instance==null) instance = new SeedlingShop();
        return instance;
    }

    private List<SeedlingOffer> seedlingOffers;
    public List<SeedlingOffer> getSeedlingOffers() {
        return seedlingOffers;
    }

    private SeedlingShop(){

        seedlingOffers = TestPack.getInstance().get_seedlings();

    }
}
