package com.acidcarpet.hydroponist.screen.seedling;


import com.acidcarpet.hydroponist.plant.Plant;
import com.acidcarpet.hydroponist.storage.Inventory;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.List;

public abstract class SeedlingOffer {
    public SeedlingOffer(String title,
                         String description,
                         int coin_price,
                         int diamond_price,
                         Image icon){

        this.coin_price = coin_price;
        this.diamond_price = diamond_price;

        this.title = title;
        this.description = description;

        this.icon = icon;
    }

    private String title;
    private String description;

    private int coin_price;
    public boolean may_buy_coin(){
        if(coin_price<= Inventory.getInstance().getGold()){
            return true;
        }else{
            return false;
        }
    }
    public void buy_coin(){
        if(may_buy_coin()){
            Inventory.getInstance().setGold(Inventory.getInstance().getGold()-coin_price);

            Box.getInstance().setPlant(get_plant());

        }
    }

    private int diamond_price;
    public boolean may_buy_diamond(){
        if(diamond_price<=Inventory.getInstance().getDiamond()){
            return true;
        }else{
            return false;
        }
    }
    public void buy_diamond(){
        if(may_buy_diamond()){
            Inventory.getInstance().setDiamond(Inventory.getInstance().getDiamond()-diamond_price);

            Box.getInstance().setPlant(get_plant());

        }
    }

    private Image icon;

    public abstract Plant get_plant();

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getCoin_price() {
        return coin_price;
    }
    public int getDiamond_price() {
        return diamond_price;
    }
    public Image getIcon() {
        return icon;
    }
}
