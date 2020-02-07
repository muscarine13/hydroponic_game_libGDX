package com.acidcarpet.hydroponist.player;

import com.acidcarpet.hydroponist.plant.Plant;

public class Player {
    public static final int START_MONEY = 2000;

    private static Player instance;
    public static Player getInstance(){
        if(instance==null) instance = new Player();
        return instance;
    }
    public static void reset(){
        instance=null;
    }

    private int money;

    public synchronized void add_money(int money){
        this.money+=money;
    }
    public synchronized boolean reduce_money(int money){
        if(this.money>=money){
            this.money-=money;
            return true;
        }else{
            return false;
        }
    }
    public int get_money(){
        return money;
    }


    private Player(){
        money = START_MONEY;
    }
}
