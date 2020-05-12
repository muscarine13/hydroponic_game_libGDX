package com.acidcarpet.hydroponist.screen.shop;


import com.acidcarpet.hydroponist.bottle.Bottle;
import com.acidcarpet.hydroponist.bottle.BottleGenerator;
import com.acidcarpet.hydroponist.fan.FanGenerator;
import com.acidcarpet.hydroponist.lamp.LampGenerator;
import com.acidcarpet.hydroponist.storage.Storable;

import java.util.ArrayList;
import java.util.List;

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
        offers.add(new EquipOffer(
                "Рандом вентилятор",
                "Рагдом вентилятор на символическую сумму",
                1000,
                100
        ) {
            @Override
            public List<Storable> set_items() {
                List<Storable> out = new ArrayList<>();

                out.add(FanGenerator.generate_random());


                return out;
            }
        });
        offers.add(new EquipOffer(
                "Рандом бутыль",
                "Рагдом бутыль на символическую сумму",
                1000,
                100
        ) {
            @Override
            public List<Storable> set_items() {
                List<Storable> out = new ArrayList<>();

                out.add(BottleGenerator.generate_bottle());


                return out;
            }
        });


        equipOffers = offers;

    }


}
