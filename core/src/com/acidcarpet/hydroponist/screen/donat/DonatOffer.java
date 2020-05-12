package com.acidcarpet.hydroponist.screen.donat;

public abstract class DonatOffer {

    public DonatOffer(
            String title,
            String description,
            boolean free,
            int price

    ){

        this.title = title;
        this.description = description;

        this.free = free;

        this.price = price;

    }

    String title;
    String description;
    boolean free;

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

    public int getPrice() {
        return price;
    }
}
