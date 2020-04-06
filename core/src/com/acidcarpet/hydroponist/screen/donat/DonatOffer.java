package com.acidcarpet.hydroponist.screen.donat;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class DonatOffer {

    public DonatOffer(
            String title,
            String description,
            boolean free,
            int price,
            Image icon
    ){

        this.title = title;
        this.description = description;

        this.free = free;

        this.price = price;
        this.icon = icon;
    }

    String title;
    String description;
    boolean free;
    Image icon;
    int price;

    public abstract void work();

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public boolean isFree() {
        return free;
    }
    public Image getIcon() {
        return icon;
    }
    public int getPrice() {
        return price;
    }
}
