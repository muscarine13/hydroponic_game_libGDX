package com.acidcarpet.hydroponist.ref.plant.flower;

import com.acidcarpet.hydroponist.Wrench;

public class Flower {

    int lvl;

    FlowersType type;

    int coin;
    int diamond;

    public Flower(FlowersType type) {
        this.type = type;
        this.coin = 0;
        this.diamond = 0;
        lvl = 1;
    }

    public int light_energy_consumption(){
        return type.light_energy_consumption;
    }
    public int dark_energy_consumption(){
        return 100-type.light_energy_consumption;
    }
    public synchronized void grow(){
        coin+=type.gold_earn;
        if(Wrench.try_double(type.diamond_chance)) diamond++;
        lvl++;
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

    public int getLvl() {
        return lvl;
    }
}
