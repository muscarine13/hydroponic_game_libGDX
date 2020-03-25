package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.equipment.Box;

public class Product {
    String name;
    String description;

    private int lvl;

    private int price;
    private double price_multiplier;

    private int light_energy;
    private int dark_energy;

    private  double light_energy_multiplier;
    private double dark_energy_multiplier;

    public Product(
            String name,
            String description,

            int start_price,
            double price_multiplier,

            int light_energy,
            int dark_energy,
            double light_energy_multiplier,
            double dark_energy_multiplier
    ){

        this.name = name;
        this.description = description;

        lvl = 1;
        price = start_price;

        this.price_multiplier = price_multiplier;

        this.dark_energy = dark_energy;
        this.light_energy = light_energy;

        this.light_energy_multiplier = light_energy_multiplier;
        this.dark_energy_multiplier = dark_energy_multiplier;

    }

    public void grow(){
        if(Box.getInstance().getPlant().may_grow_product(light_energy, dark_energy)){
            lvl++;

            price*=price_multiplier;

            light_energy +=light_energy_multiplier;
            dark_energy +=dark_energy_multiplier;
        }
    }

    public int getLvl() {
        return lvl;
    }
    public int getPrice() {
        return price;
    }
    public double getPrice_multiplier() {
        return price_multiplier;
    }
    public double getLight_energy() {
        return light_energy;
    }
    public double getDark_energy() {
        return dark_energy;
    }
    public double getLight_energy_multiplier() {
        return light_energy_multiplier;
    }
    public double getDark_energy_multiplier() {
        return dark_energy_multiplier;
    }


}
