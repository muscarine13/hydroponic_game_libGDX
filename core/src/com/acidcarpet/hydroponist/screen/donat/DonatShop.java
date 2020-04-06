package com.acidcarpet.hydroponist.screen.donat;

import com.acidcarpet.hydroponist.storage.TestPack;

import java.util.List;

public class DonatShop {

    private static DonatShop instance;
    public static DonatShop getInstance(){
        if(instance==null) instance = new DonatShop();
        return instance;
    }

    private List<DonatOffer> donatOffers;

    public List<DonatOffer> getDonatOffers() {
        return donatOffers;
    }

    private DonatShop(){

        donatOffers = TestPack.getInstance().get_donats();

    }

}
