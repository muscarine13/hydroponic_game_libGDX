package com.acidcarpet.hydroponist.screen.donat;

import com.acidcarpet.hydroponist.storage.Inventory;

import java.util.ArrayList;
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

        List<DonatOffer> offer = new ArrayList<>();

        offer.add(new DonatOffer(
                "100 алмазов",
                "Сто алмазов просто так. выбрано что это не за деньги.",
                true,
                0
        ) {
            @Override
            public void work() {
                Inventory.getInstance().setDiamond(Inventory.getInstance().getDiamond()+100);
            }
        });
        offer.add(new DonatOffer(
                "100 алмазов",
                "Сто алмазов просто так. Эти уже платные.",
                false,
                29
        ) {
            @Override
            public void work() {
                Inventory.getInstance().setDiamond(Inventory.getInstance().getDiamond()+100);
            }
        });

        donatOffers = offer;


    }

}
