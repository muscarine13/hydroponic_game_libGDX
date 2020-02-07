package com.acidcarpet.hydroponist.plant;

import java.awt.*;

public abstract class Product {
    private int lvl;

    private int price;
    private double price_multiplier;

    private double light_energy_price;
    private double dark_energy_price;

    private  double light_energy_multiplier;
    private double dark_energy_multiplier;

    public Product(
            String name,
            String description,

            int start_price,
            double price_multiplier,
            double light_energy_start_price,
            double dark_energy_start_price,
            double light_energy_multiplier,
            double dark_energy_multiplier

    ){

        lvl = 1;
        price = start_price;

        this.price_multiplier = price_multiplier;

        this.dark_energy_price = dark_energy_start_price;
        this.light_energy_price = light_energy_start_price;

        this.light_energy_multiplier = light_energy_multiplier;
        this.dark_energy_multiplier = dark_energy_multiplier;

    }

    public void grow(Plant plant){
        if(plant.buy(dark_energy_price, light_energy_price)){
            lvl++;

            price*=price_multiplier;

            light_energy_price+=light_energy_multiplier;
            dark_energy_price+=dark_energy_multiplier;
        }
    }

    abstract String name();
    abstract String description();
    abstract Image inventory_image();

    public int getLvl() {
        return lvl;
    }
    public int getPrice() {
        return price;
    }
    public double getPrice_multiplier() {
        return price_multiplier;
    }
    public double getLight_energy_price() {
        return light_energy_price;
    }
    public double getDark_energy_price() {
        return dark_energy_price;
    }
    public double getLight_energy_multiplier() {
        return light_energy_multiplier;
    }
    public double getDark_energy_multiplier() {
        return dark_energy_multiplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name() +
                "description=" + description() +
                "lvl=" + lvl +
                ", price=" + price +
                ", price_multiplier=" + price_multiplier +
                ", light_energy_price=" + light_energy_price +
                ", dark_energy_price=" + dark_energy_price +
                ", light_energy_multiplier=" + light_energy_multiplier +
                ", dark_energy_multiplier=" + dark_energy_multiplier +
                '}';
    }
}
