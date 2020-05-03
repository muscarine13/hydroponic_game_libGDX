package com.acidcarpet.hydroponist.ref.plant.flower;

import com.acidcarpet.hydroponist.Wrench;

public class Flower {

    FlowersType type;

    int coin;
    int diamond;

    public Flower(FlowersType type) {
        this.type = type;
        this.coin = 0;
        this.diamond = 0;
    }

    public int light_energy_consumption(){
        return type.light_energy_consumption;
    }
    public int dark_energy_consumption(){
        return type.dark_energy_consumption;
    }
    public synchronized void grow(){
        coin+=type.gold_earn;
        if(Wrench.try_double(type.diamond_chance)) diamond++;
    }

    public FlowersType getType() {
        return type;
    }
    public void setType(FlowersType type) {
        this.type = type;
    }
    public int getCoin() {
        return coin;
    }
    public int getDiamond() {
        return diamond;
    }

}
