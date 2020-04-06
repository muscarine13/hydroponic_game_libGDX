package com.acidcarpet.hydroponist.screen.shop;

import com.acidcarpet.hydroponist.storage.TestPack;

import java.util.*;

public class EquipShop {

    private static EquipShop instance;
    public static EquipShop getInstance(){
        if(instance==null) instance = new EquipShop();
        return instance;
    }

    private List<EquipOffer> equipOffers;
    public List<EquipOffer> getEquipOffers() {
        return equipOffers;
    }

    private EquipShop(){

        equipOffers = TestPack.getInstance().get_offers();

    }


}
