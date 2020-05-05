package com.acidcarpet.hydroponist.screen.shop;



import com.acidcarpet.hydroponist.lamp.LampGenerator;
import com.acidcarpet.hydroponist.storage.Storable;

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

        List<EquipOffer> offers = new ArrayList<>();

        offers.add(new EquipOffer(
                "Рандом лампа",
                "Рагдом лампа на символическую сумму",
                1000,
                100
        ) {
            @Override
            public List<Storable> set_items() {
                List<Storable> out = new ArrayList<>();

                out.add(LampGenerator.generate_random());


                return out;
            }
        });


        equipOffers = offers;

    }


}
