package com.acidcarpet.hydroponist.screen.seedling;

import com.acidcarpet.hydroponist.plant.Plant;
import com.acidcarpet.hydroponist.plant.PlantGenerator;


import java.util.ArrayList;
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
        List<SeedlingOffer> offers = new ArrayList<>();

        offers.add(new SeedlingOffer(
                "Рандомное растение",
                "Полностью рандомное растестение. Все типы, все продолжительноти и тд.",
                1000,
                100
        ) {
            @Override
            public Plant get_plant() {
                return PlantGenerator.generate_random();
            }
        });

        seedlingOffers = offers;

    }
}
